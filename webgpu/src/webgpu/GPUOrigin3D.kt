package webgpu

import webgpu.c.WGPUOrigin3D
import java.lang.foreign.Arena

data class GPUOrigin3D(
    val x: GPUIntegerCoordinate = 0u,
    val y: GPUIntegerCoordinate = 0u,
    val z: GPUIntegerCoordinate = 0u,
) {
    companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(interop: GPUOrigin3D, native: WGPUOrigin3D) {
            native.x = interop.x
            native.y = interop.y
            native.z = interop.z
        }
    }
}
