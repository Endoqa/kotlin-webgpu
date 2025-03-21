package wgpu

public data class GPUSamplerDescriptor(
    override var label: String = "",
    public var addressModeU: GPUAddressMode = GPUAddressMode.ClampToEdge,
    public var addressModeV: GPUAddressMode = GPUAddressMode.ClampToEdge,
    public var addressModeW: GPUAddressMode = GPUAddressMode.ClampToEdge,
    public var magFilter: GPUFilterMode = GPUFilterMode.Nearest,
    public var minFilter: GPUFilterMode = GPUFilterMode.Nearest,
    public var mipmapFilter: GPUMipmapFilterMode = GPUMipmapFilterMode.Nearest,
    public var lodMinClamp: Float = 0f,
    public var lodMaxClamp: Float = 32f,
    public var compare: GPUCompareFunction? = null,
    public var maxAnisotropy: UShort = 1U,
) : GPUObjectDescriptorBase(label = label)
