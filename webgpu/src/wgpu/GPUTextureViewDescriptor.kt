package wgpu

public data class GPUTextureViewDescriptor(
    override var label: String = "",
    public var format: GPUTextureFormat? = null,
    public var dimension: GPUTextureViewDimension? = null,
    public var usage: GPUTextureUsageFlags = 0U,
    public var aspect: GPUTextureAspect = GPUTextureAspect.All,
    public var baseMipLevel: GPUIntegerCoordinate = 0U,
    public var mipLevelCount: GPUIntegerCoordinate? = null,
    public var baseArrayLayer: GPUIntegerCoordinate = 0U,
    public var arrayLayerCount: GPUIntegerCoordinate? = null,
) : GPUObjectDescriptorBase(label = label)
