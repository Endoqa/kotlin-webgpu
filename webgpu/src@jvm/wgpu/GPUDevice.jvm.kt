package wgpu

import lib.wgpu.WGPUDevice

public actual class GPUDevice(
    private val device: WGPUDevice
) : GPUObjectBase {
    actual override var label: String
        get() = TODO("Not yet implemented")
        set(value) {}
    actual val features: GPUSupportedFeatures
        get() = TODO("Not yet implemented")
    actual val limits: GPUSupportedLimits
        get() = TODO("Not yet implemented")
    actual val adapterInfo: GPUAdapterInfo
        get() = TODO("Not yet implemented")
    actual val queue: GPUQueue
        get() = TODO("Not yet implemented")
    actual val lost: GPUDeviceLostInfo
        get() = TODO("Not yet implemented")

    actual fun destroy() {
    }

    actual fun createBuffer(descriptor: GPUBufferDescriptor): GPUBuffer {
        TODO("Not yet implemented")
    }

    actual fun createTexture(descriptor: GPUTextureDescriptor): GPUTexture {
        TODO("Not yet implemented")
    }

    actual fun createSampler(descriptor: GPUSamplerDescriptor): GPUSampler {
        TODO("Not yet implemented")
    }

    actual fun createBindGroupLayout(descriptor: GPUBindGroupLayoutDescriptor): GPUBindGroupLayout {
        TODO("Not yet implemented")
    }

    actual fun createPipelineLayout(descriptor: GPUPipelineLayoutDescriptor): GPUPipelineLayout {
        TODO("Not yet implemented")
    }

    actual fun createBindGroup(descriptor: GPUBindGroupDescriptor): GPUBindGroup {
        TODO("Not yet implemented")
    }

    actual fun createShaderModule(descriptor: GPUShaderModuleDescriptor): GPUShaderModule {
        TODO("Not yet implemented")
    }

    actual fun createComputePipeline(descriptor: GPUComputePipelineDescriptor): GPUComputePipeline {
        TODO("Not yet implemented")
    }

    actual fun createRenderPipeline(descriptor: GPURenderPipelineDescriptor): GPURenderPipeline {
        TODO("Not yet implemented")
    }

    actual suspend fun createComputePipelineAsync(descriptor: GPUComputePipelineDescriptor): GPUComputePipeline {
        TODO("Not yet implemented")
    }

    actual suspend fun createRenderPipelineAsync(descriptor: GPURenderPipelineDescriptor): GPURenderPipeline {
        TODO("Not yet implemented")
    }

    actual fun createCommandEncoder(descriptor: GPUCommandEncoderDescriptor): GPUCommandEncoder {
        TODO("Not yet implemented")
    }

    actual fun createRenderBundleEncoder(descriptor: GPURenderBundleEncoderDescriptor): GPURenderBundleEncoder {
        TODO("Not yet implemented")
    }

    actual fun createQuerySet(descriptor: GPUQuerySetDescriptor): GPUQuerySet {
        TODO("Not yet implemented")
    }

    actual fun pushErrorScope(filter: GPUErrorFilter) {
    }

    actual suspend fun popErrorScope(): GPUError? {
        TODO("Not yet implemented")
    }

}