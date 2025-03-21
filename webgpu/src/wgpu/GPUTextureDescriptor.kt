package wgpu

public data class GPUTextureDescriptor(
    override var label: String = "",
    public var size: GPUExtent3D,
    public var mipLevelCount: GPUIntegerCoordinate = 1U,
    public var sampleCount: GPUSize32 = 1U,
    public var dimension: GPUTextureDimension = GPUTextureDimension.`2D`,
    public var format: GPUTextureFormat,
    public var usage: GPUTextureUsageFlags,
    public var viewFormats: List<GPUTextureFormat> = listOf(),
) : GPUObjectDescriptorBase(label = label)
