package webgpu

import java.lang.foreign.Arena

public data class GPUSamplerDescriptor(
    override val label: String = "",
    public val addressModeU: GPUAddressMode = GPUAddressMode.ClampToEdge,
    public val addressModeV: GPUAddressMode = GPUAddressMode.ClampToEdge,
    public val addressModeW: GPUAddressMode = GPUAddressMode.ClampToEdge,
    public val magFilter: GPUFilterMode = GPUFilterMode.Nearest,
    public val minFilter: GPUFilterMode = GPUFilterMode.Nearest,
    public val mipmapFilter: GPUMipmapFilterMode = GPUMipmapFilterMode.Nearest,
    public val lodMinClamp: Float = 0f,
    public val lodMaxClamp: Float = 32f,
    public val compare: GPUCompareFunction = GPUCompareFunction.Undefined,
    public val maxAnisotropy: UShort = 1u,
) : GPUObjectDescriptorBase {
    public companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(interop: GPUSamplerDescriptor, native: WGPUSamplerDescriptor) {
            TODO()
        }
    }
}
