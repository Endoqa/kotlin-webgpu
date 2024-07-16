package webgpu

data class GPUTextureDescriptor(
    override val label: String = "",
    val size: GPUExtent3D,
    val mipLevelCount: GPUIntegerCoordinate = 1u,
    val sampleCount: GPUSize32 = 1u,
    val dimension: GPUTextureDimension = GPUTextureDimension.`2D`,
    val format: GPUTextureFormat,
    val usage: GPUTextureUsageFlags,
    val viewFormats: List<GPUTextureFormat> = mutableListOf(),
) : GPUObjectDescriptorBase
