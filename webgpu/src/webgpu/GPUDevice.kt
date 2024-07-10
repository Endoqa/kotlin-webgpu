package webgpu

import Converter
import not
import java.lang.foreign.Arena
import java.lang.foreign.MemorySegment
import java.lang.foreign.ValueLayout
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class GPUDevice(
    internal val device_: WGPUDevice,
    internal val desc_: GPUDeviceDescriptor,
    internal val arena: Arena,
) {


    // [SameObject]
    val queue: GPUQueue = initQueue()

    private fun initQueue(): GPUQueue {
        val queue_ = wgpuDeviceGetQueue(device_)
        return GPUQueue(queue_, arena)
    }

    fun destroy() {
        wgpuDeviceDestroy(device_)
    }


    fun createBuffer(descriptor: GPUBufferDescriptor): GPUBuffer {
        val desc = WGPUBufferDescriptor.allocate(arena)

        with(arena) {
            Converter.convert(this, descriptor.label) { desc.label = it }
            desc.mappedAtCreation = Converter.convert(descriptor.mappedAtCreation)
            desc.size = descriptor.size
            desc.usage = descriptor.usage
        }

        val buffer = wgpuDeviceCreateBuffer(device_, desc.`$mem`)
        return GPUBuffer(buffer, descriptor, this, arena)
    }

    fun createTexture(descriptor: GPUTextureDescriptor): GPUTexture {
        val desc = WGPUTextureDescriptor.allocate(arena)

        with(arena) {
            Converter.convert(this, descriptor.label) { desc.label = it }
            desc.usage = descriptor.usage
            GPUExtent3D.convert(descriptor.size, desc.size)
            desc.dimension = descriptor.dimension
            desc.mipLevelCount = descriptor.mipLevelCount
            desc.sampleCount = descriptor.sampleCount
            desc.format = descriptor.format
            desc.viewFormatCount = Converter.convert(this,
                { desc.viewFormats = it },
                descriptor.viewFormats,
                ValueLayout.JAVA_INT,
                { format, mem -> mem.setAtIndex(ValueLayout.JAVA_INT, 0L, format.value) })
        }

        val texture = wgpuDeviceCreateTexture(device_, desc.`$mem`)
        return GPUTexture(texture, descriptor, arena)
    }

    fun createSampler(descriptor: GPUSamplerDescriptor = GPUSamplerDescriptor()): GPUSampler {
        val desc = WGPUSamplerDescriptor.allocate(arena)

        with(arena) {
            Converter.convert(this, descriptor.label) { desc.label = it }
            desc.addressModeU = descriptor.addressModeU
            desc.addressModeV = descriptor.addressModeV
            desc.addressModeW = descriptor.addressModeW
            desc.magFilter = descriptor.magFilter
            desc.minFilter = descriptor.minFilter
            desc.mipmapFilter = descriptor.mipmapFilter
            desc.lodMinClamp = descriptor.lodMinClamp
            desc.lodMaxClamp = descriptor.lodMaxClamp
            desc.compare = descriptor.compare
            desc.maxAnisotropy = descriptor.maxAnisotropy
        }

        val sampler = wgpuDeviceCreateSampler(device_, desc.`$mem`)
        return GPUSampler(sampler, descriptor)
    }


    fun createBindGroupLayout(descriptor: GPUBindGroupLayoutDescriptor): GPUBindGroupLayout {
        val desc = WGPUBindGroupLayoutDescriptor.allocate(arena)

        with(arena) {
            Converter.convert(this, descriptor.label) { desc.label = it }
            desc.entryCount =
                Converter.convert(
                    this,
                    { desc.entries = it },
                    descriptor.entries,
                    WGPUBindGroupLayoutEntry.layout,
                    { entry, mem ->
                        GPUBindGroupLayoutEntry.convert(entry, WGPUBindGroupLayoutEntry(mem))
                    }
                )
        }

        val layout = wgpuDeviceCreateBindGroupLayout(device_, desc.`$mem`)
        return GPUBindGroupLayout(layout, descriptor)
    }


    fun createPipelineLayout(descriptor: GPUPipelineLayoutDescriptor): GPUPipelineLayout {
        val desc = WGPUPipelineLayoutDescriptor.allocate(arena)

        with(arena) {
            Converter.convert(this, descriptor.label) { desc.label = it }
            desc.bindGroupLayoutCount =
                Converter.convert(
                    this,
                    { desc.bindGroupLayouts = it },
                    descriptor.bindGroupLayouts,
                    ValueLayout.ADDRESS,
                    { layout, mem -> mem.setAtIndex(ValueLayout.ADDRESS, 0L, layout.layout_) }
                )
        }

        val layout = wgpuDeviceCreatePipelineLayout(device_, desc.`$mem`)
        return GPUPipelineLayout(layout, descriptor)
    }

    fun createBindGroup(descriptor: GPUBindGroupDescriptor): GPUBindGroup {
        val desc = WGPUBindGroupDescriptor.allocate(arena)

        with(arena) {
            Converter.convert(this, descriptor.label) { desc.label = it }
            desc.layout = descriptor.layout.layout_
            desc.entryCount =
                Converter.convert(
                    this,
                    { desc.entries = it },
                    descriptor.entries,
                    WGPUBindGroupEntry.layout,
                    { entry, mem ->
                        GPUBindGroupEntry.convert(entry, WGPUBindGroupEntry(mem))
                    }
                )
        }

        val bindGroup = wgpuDeviceCreateBindGroup(device_, desc.`$mem`)
        return GPUBindGroup(bindGroup, descriptor)
    }

    //


    fun createShaderModule(descriptor: GPUShaderModuleDescriptor): GPUShaderModule {
        val smDesc = WGPUShaderModuleDescriptor.allocate(arena)

        val wgslDesc = WGPUShaderModuleWGSLDescriptor.allocate(arena)
        wgslDesc.chain.sType = WGPUSType.ShaderModuleWGSLDescriptor

        with(arena) {
            Converter.convert(this, descriptor.label) { smDesc.label = it }
            Converter.convert(this, descriptor.code) { wgslDesc.code = it }
        }

        smDesc.nextInChain = wgslDesc.`$mem`

        val module = wgpuDeviceCreateShaderModule(device_, smDesc.`$mem`)
        return GPUShaderModule(module, descriptor)
    }

    suspend fun createComputePipeline(descriptor: GPUComputePipelineDescriptor) {
        val desc = WGPUComputePipelineDescriptor.allocate(arena)

        with(arena) {
            GPUComputePipelineDescriptor.convert(descriptor, desc)
        }

        return Arena.ofConfined().use { temp ->
            suspendCoroutine<GPUComputePipeline> { cont ->
                val callback =
                    webgpu.callback.WGPUCreateComputePipelineAsyncCallback2 { status, pipeline, message, _, _ ->
                        when (status) {
                            WGPUCreatePipelineAsyncStatus.Success -> cont.resume(
                                GPUComputePipeline(
                                    pipeline,
                                    descriptor,
                                    temp
                                )
                            )

                            else -> cont.resumeWithException(wgpuError(status, message))
                        }
                    }

                val cb = WGPUCreateComputePipelineAsyncCallbackInfo2.allocate(temp)
                cb.mode = WGPUCallbackMode.AllowSpontaneous
                cb.callback = callback.allocate(temp)


                with(temp) {
                    wgpuDeviceCreateComputePipelineAsync2(
                        device_,
                        desc.`$mem`,
                        cb,
                    )
                }

            }
        }
    }

    suspend fun createRenderPipeline(descriptor: GPURenderPipelineDescriptor): GPURenderPipeline {
        val desc = WGPURenderPipelineDescriptor.allocate(arena)

        with(arena) {
            GPURenderPipelineDescriptor.convert(descriptor, desc)
        }

        return Arena.ofConfined().use { temp ->
            suspendCoroutine<GPURenderPipeline> { cont ->
                val callback =
                    webgpu.callback.WGPUCreateRenderPipelineAsyncCallback2 { status, pipeline, message, _, _ ->
                        when (status) {
                            WGPUCreatePipelineAsyncStatus.Success -> cont.resume(
                                GPURenderPipeline(
                                    pipeline,
                                    descriptor
                                )
                            )

                            else -> cont.resumeWithException(wgpuError(status, message))
                        }
                    }

                val cb = WGPUCreateRenderPipelineAsyncCallbackInfo2.allocate(temp)
                cb.callback = callback.allocate(temp)
                cb.mode = WGPUCallbackMode.AllowSpontaneous

                with(temp) {
                    wgpuDeviceCreateRenderPipelineAsync2(
                        device_, desc.`$mem`, cb
                    )
                    wgpuDeviceTick(device_)
                }
            }
        }


    }

    fun createRenderBundleEncoder(descriptor: GPURenderBundleEncoderDescriptor): GPURenderBundleEncoder {
        val desc = WGPURenderBundleEncoderDescriptor.allocate(arena)

        with(arena) {
            Converter.convert(this, descriptor.label) { desc.label = it }
            desc.colorFormatCount = Converter.convert(
                this,
                { desc.colorFormats = it },
                descriptor.colorFormats,
                ValueLayout.JAVA_INT,
                { format, mem -> mem.setAtIndex(ValueLayout.JAVA_INT, 0L, format.value) }
            )
            desc.depthStencilFormat = descriptor.depthStencilFormat
            desc.sampleCount = descriptor.sampleCount
            desc.depthReadOnly = Converter.convert(descriptor.depthReadOnly)
            desc.stencilReadOnly = Converter.convert(descriptor.stencilReadOnly)
        }

        val encoder = wgpuDeviceCreateRenderBundleEncoder(device_, desc.`$mem`)
        return GPURenderBundleEncoder(encoder, descriptor, arena)
    }

    fun createCommandEncoder(descriptor: GPUCommandEncoderDescriptor = GPUCommandEncoderDescriptor()): GPUCommandEncoder {
        val desc = WGPUCommandEncoderDescriptor.allocate(arena)

        with(arena) {
            Converter.convert(this, descriptor.label) { desc.label = it }
        }

        val encoder = wgpuDeviceCreateCommandEncoder(device_, desc.`$mem`)
        return GPUCommandEncoder(encoder, this, descriptor, arena)
    }

    fun createQuerySet(descriptor: GPUQuerySetDescriptor): GPUQuerySet {
        val desc = WGPUQuerySetDescriptor.allocate(arena)

        with(arena) {
            Converter.convert(this, descriptor.label) { desc.label = it }
            desc.type = descriptor.type
            desc.count = descriptor.count
        }

        val querySet = wgpuDeviceCreateQuerySet(device_, desc.`$mem`)
        return GPUQuerySet(querySet, descriptor)
    }


    fun pushErrorScope(filter: GPUErrorFilter) {
        wgpuDevicePushErrorScope(device_, filter)
    }

    suspend fun popErrorScope(): GPUError? {
        return Arena.ofConfined().use { temp ->
            suspendCoroutine { cont ->
                val callback = webgpu.callback.WGPUPopErrorScopeCallback2 { _, type, message, _, _ ->
                    val m = if (!message) message.getString(0) else "no message"

                    when (type) {
                        WGPUErrorType.NoError -> cont.resume(null)
                        WGPUErrorType.Validation -> cont.resume(GPUValidationError(m))
                        WGPUErrorType.OutOfMemory -> cont.resume(GPUOutOfMemoryError(m))
                        WGPUErrorType.Internal -> cont.resume(GPUInternalError(m))
                        WGPUErrorType.Unknown,
                        WGPUErrorType.DeviceLost -> cont.resumeWithException(IllegalStateException(m))

                        else -> cont.resumeWithException(IllegalStateException("unhandled error type $type - $m"))
                    }
                }

                val cb = WGPUPopErrorScopeCallbackInfo2.allocate(temp)
                cb.mode = WGPUCallbackMode.AllowSpontaneous
                cb.callback = callback.allocate(temp)

                with(temp) {
                    wgpuDevicePopErrorScope2(device_, cb)
                }
            }
        }
    }


    fun _internalDevice(): WGPUDevice {
        return device_
    }
}