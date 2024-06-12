package webgpu

import java.lang.foreign.Arena

public data class GPUTextureViewDescriptor(
    override val label: String = "",
    public val format: GPUTextureFormat = GPUTextureFormat.Undefined,
    public val dimension: GPUTextureViewDimension = GPUTextureViewDimension.Undefined,
    public val aspect: GPUTextureAspect = GPUTextureAspect.All,
    public val baseMipLevel: GPUIntegerCoordinate = 0u,
    public val mipLevelCount: GPUIntegerCoordinate = 0u,
    public val baseArrayLayer: GPUIntegerCoordinate = 0u,
    public val arrayLayerCount: GPUIntegerCoordinate = 0u,
) : GPUObjectDescriptorBase {
    public companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(interop: GPUTextureViewDescriptor, native: WGPUTextureViewDescriptor) {
            TODO()
        }
    }
}
