package webgpu

data class GPUTextureViewDescriptor(
    override val label: String = "",
    val format: GPUTextureFormat = GPUTextureFormat.Undefined,
    val dimension: GPUTextureViewDimension = GPUTextureViewDimension.Undefined,
    val aspect: GPUTextureAspect = GPUTextureAspect.All,
    val baseMipLevel: GPUIntegerCoordinate = 0u,
    val mipLevelCount: GPUIntegerCoordinate = 0u,
    val baseArrayLayer: GPUIntegerCoordinate = 0u,
    val arrayLayerCount: GPUIntegerCoordinate = 0u,
) : GPUObjectDescriptorBase 