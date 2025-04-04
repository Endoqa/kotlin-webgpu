package wgpu

import kotlinx.coroutines.Deferred
import lib.wgpu.*
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

public actual class GPUDevice(
    private val device: WGPUDevice
) : GPUObjectBase {
    actual override var label: String
        get() = TODO("Not yet implemented")
        set(value) {
            unsafeScope { wgpuDeviceSetLabel(device, value.into()) }
        }

    public actual val features: GPUSupportedFeatures by lazy {
        GPUSupportedFeatures { ptr -> wgpuDeviceGetFeatures(device, ptr) }
    }
    public actual val limits: GPUSupportedLimits by lazy {
        GPUSupportedLimits.from { ptr -> wgpuDeviceGetLimits(device, ptr) }
    }
    public actual val adapterInfo: GPUAdapterInfo by lazy {
        GPUAdapterInfo.from { ptr -> wgpuDeviceGetAdapterInfo(device, ptr) }
    }
    public actual val queue: GPUQueue by lazy {
        GPUQueue(wgpuDeviceGetQueue(device))
    }


    public actual val lost: Deferred<GPUDeviceLostInfo>
        get() = TODO("Not yet implemented")

    public actual fun destroy() {
        wgpuDeviceDestroy(device)
    }

    public actual fun createBuffer(descriptor: GPUBufferDescriptor): GPUBuffer {
        return unsafeScope {
            GPUBuffer(wgpuDeviceCreateBuffer(device, descriptor.into().`$mem`))
        }
    }

    public actual fun createTexture(descriptor: GPUTextureDescriptor): GPUTexture {
        return unsafeScope { GPUTexture(wgpuDeviceCreateTexture(device, descriptor.into().`$mem`)) }
    }

    public actual fun createSampler(descriptor: GPUSamplerDescriptor): GPUSampler {
        return unsafeScope { GPUSampler(wgpuDeviceCreateSampler(device, descriptor.into().`$mem`)) }
    }

    public actual fun createBindGroupLayout(descriptor: GPUBindGroupLayoutDescriptor): GPUBindGroupLayout {
        return unsafeScope { GPUBindGroupLayout(wgpuDeviceCreateBindGroupLayout(device, descriptor.into().`$mem`)) }
    }

    public actual fun createPipelineLayout(descriptor: GPUPipelineLayoutDescriptor): GPUPipelineLayout {
        return unsafeScope { GPUPipelineLayout(wgpuDeviceCreatePipelineLayout(device, descriptor.into().`$mem`)) }
    }

    public actual fun createBindGroup(descriptor: GPUBindGroupDescriptor): GPUBindGroup {
        return unsafeScope { GPUBindGroup(wgpuDeviceCreateBindGroup(device, descriptor.into().`$mem`)) }
    }

    public actual fun createShaderModule(descriptor: GPUShaderModuleDescriptor): GPUShaderModule {
        return unsafeScope {
            val desc = descriptor.into()
            val wgslDesc = WGPUShaderSourceWGSL.allocate(this)
            desc.nextInChain = wgslDesc.`$mem`

            wgslDesc.chain.sType = WGPUSType.ShaderSourceWGSL
            descriptor.code.into(wgslDesc.code)

            GPUShaderModule(wgpuDeviceCreateShaderModule(device, desc.`$mem`))
        }
    }

    public actual fun createComputePipeline(descriptor: GPUComputePipelineDescriptor): GPUComputePipeline {
        return unsafeScope { GPUComputePipeline(wgpuDeviceCreateComputePipeline(device, descriptor.into().`$mem`)) }
    }

    public actual fun createRenderPipeline(descriptor: GPURenderPipelineDescriptor): GPURenderPipeline {
        return unsafeScope { GPURenderPipeline(wgpuDeviceCreateRenderPipeline(device, descriptor.into().`$mem`)) }
    }

    public actual suspend fun createComputePipelineAsync(descriptor: GPUComputePipelineDescriptor): GPUComputePipeline {
        return unsafeScope {
            suspendCoroutine { cont ->
                val info = createCreateComputePipelineAsyncCallback { status, pipeline, message, _, _ ->
                    when (status) {
                        WGPUCreatePipelineAsyncStatus.Success -> cont.resume(GPUComputePipeline(pipeline))
                        else -> cont.resumeWithException(Exception(String.from(message)))
                    }
                }
                wgpuDeviceCreateComputePipelineAsync(device, descriptor.into().`$mem`, info)
            }
        }
    }

    public actual suspend fun createRenderPipelineAsync(descriptor: GPURenderPipelineDescriptor): GPURenderPipeline {
        return unsafeScope {
            suspendCoroutine { cont ->
                val info = createCreateRenderPipelineAsyncCallback { status, pipeline, message, _, _ ->
                    when (status) {
                        WGPUCreatePipelineAsyncStatus.Success -> cont.resume(GPURenderPipeline(pipeline))
                        else -> cont.resumeWithException(Exception(String.from(message)))
                    }
                }
                wgpuDeviceCreateRenderPipelineAsync(device, descriptor.into().`$mem`, info)
            }
        }
    }

    public actual fun createCommandEncoder(descriptor: GPUCommandEncoderDescriptor): GPUCommandEncoder {
        return unsafeScope { GPUCommandEncoder(wgpuDeviceCreateCommandEncoder(device, descriptor.into().`$mem`)) }
    }

    public actual fun createRenderBundleEncoder(descriptor: GPURenderBundleEncoderDescriptor): GPURenderBundleEncoder {
        return unsafeScope {
            GPURenderBundleEncoder(
                wgpuDeviceCreateRenderBundleEncoder(
                    device,
                    descriptor.into().`$mem`
                )
            )
        }
    }

    public actual fun createQuerySet(descriptor: GPUQuerySetDescriptor): GPUQuerySet {
        return unsafeScope { GPUQuerySet(wgpuDeviceCreateQuerySet(device, descriptor.into().`$mem`)) }
    }

    public actual fun pushErrorScope(filter: GPUErrorFilter) {
        wgpuDevicePushErrorScope(device, filter.into())
    }

    public actual suspend fun popErrorScope(): GPUError? {
        return unsafeScope {
            suspendCoroutine { cont ->
                val info = createPopErrorScopeCallback { status, type, message, _, _ ->
                    when (status) {
                        WGPUPopErrorScopeStatus.Success -> cont.resume(GPUError(type, String.from(message)))
                        else -> cont.resumeWithException(Exception("Failed to pop error scope: $status"))
                    }
                }
                wgpuDevicePopErrorScope(device, info)
            }
        }
    }


    public fun into(): WGPUDevice = device
}
