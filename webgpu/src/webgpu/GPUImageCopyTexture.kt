package webgpu

import webgpu.c.WGPUImageCopyTexture
import java.lang.foreign.Arena

data class GPUImageCopyTexture(
    val texture: GPUTexture,
    val mipLevel: GPUIntegerCoordinate = 0u,
    val origin: GPUOrigin3D = GPUOrigin3D(),
    val aspect: GPUTextureAspect = GPUTextureAspect.All,
) {
    companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(interop: GPUImageCopyTexture, native: WGPUImageCopyTexture) {
            native.texture = interop.texture.texture
            native.mipLevel = interop.mipLevel
            GPUOrigin3D.convert(interop.origin, native.origin)
        }
    }
}
