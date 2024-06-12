package webgpu

public data class GPUTextureDescriptor(
    override val label: String = "",
    public val size: GPUExtent3D,
    public val mipLevelCount: GPUIntegerCoordinate = 1u,
    public val sampleCount: GPUSize32 = 1u,
    public val dimension: GPUTextureDimension = GPUTextureDimension.`2D`,
    public val format: GPUTextureFormat,
    public val usage: GPUTextureUsageFlags,
    public val viewFormats: List<GPUTextureFormat> = mutableListOf(),
) : GPUObjectDescriptorBase {

}
