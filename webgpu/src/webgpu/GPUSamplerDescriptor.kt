package webgpu

data class GPUSamplerDescriptor(
    override val label: String = "",
    val addressModeU: GPUAddressMode = GPUAddressMode.ClampToEdge,
    val addressModeV: GPUAddressMode = GPUAddressMode.ClampToEdge,
    val addressModeW: GPUAddressMode = GPUAddressMode.ClampToEdge,
    val magFilter: GPUFilterMode = GPUFilterMode.Nearest,
    val minFilter: GPUFilterMode = GPUFilterMode.Nearest,
    val mipmapFilter: GPUMipmapFilterMode = GPUMipmapFilterMode.Nearest,
    val lodMinClamp: Float = 0f,
    val lodMaxClamp: Float = 32f,
    val compare: GPUCompareFunction = GPUCompareFunction.Undefined,
    val maxAnisotropy: UShort = 1u,
) : GPUObjectDescriptorBase 