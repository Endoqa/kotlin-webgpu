package webgpu

import java.lang.foreign.Arena

public data class GPUImageCopyTexture(
    public val texture: GPUTexture,
    public val mipLevel: GPUIntegerCoordinate = 0u,
    public val origin: GPUOrigin3D = GPUOrigin3D(),
    public val aspect: GPUTextureAspect = GPUTextureAspect.All,
) {
    public companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(interop: GPUImageCopyTexture, native: WGPUImageCopyTexture) {
            native.texture = interop.texture.texture
            native.mipLevel = interop.mipLevel
            GPUOrigin3D.convert(interop.origin, native.origin)
        }
    }
}
