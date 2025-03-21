package wgpu

public expect class GPUDevice : GPUObjectBase {
    override var label: String

    public val features: GPUSupportedFeatures

    public val limits: GPUSupportedLimits

    public val adapterInfo: GPUAdapterInfo

    public val queue: GPUQueue

    public val lost: GPUDeviceLostInfo

    public fun destroy()

    public fun createBuffer(descriptor: GPUBufferDescriptor): GPUBuffer

    public fun createTexture(descriptor: GPUTextureDescriptor): GPUTexture

    public fun createSampler(descriptor: GPUSamplerDescriptor = GPUSamplerDescriptor()): GPUSampler

    public fun createBindGroupLayout(descriptor: GPUBindGroupLayoutDescriptor): GPUBindGroupLayout

    public fun createPipelineLayout(descriptor: GPUPipelineLayoutDescriptor): GPUPipelineLayout

    public fun createBindGroup(descriptor: GPUBindGroupDescriptor): GPUBindGroup

    public fun createShaderModule(descriptor: GPUShaderModuleDescriptor): GPUShaderModule

    public fun createComputePipeline(descriptor: GPUComputePipelineDescriptor): GPUComputePipeline

    public fun createRenderPipeline(descriptor: GPURenderPipelineDescriptor): GPURenderPipeline

    public suspend fun createComputePipelineAsync(descriptor: GPUComputePipelineDescriptor): GPUComputePipeline

    public suspend fun createRenderPipelineAsync(descriptor: GPURenderPipelineDescriptor): GPURenderPipeline

    public fun createCommandEncoder(descriptor: GPUCommandEncoderDescriptor = GPUCommandEncoderDescriptor()): GPUCommandEncoder

    public fun createRenderBundleEncoder(descriptor: GPURenderBundleEncoderDescriptor): GPURenderBundleEncoder

    public fun createQuerySet(descriptor: GPUQuerySetDescriptor): GPUQuerySet

    public fun pushErrorScope(filter: GPUErrorFilter)

    public suspend fun popErrorScope(): GPUError?
}
