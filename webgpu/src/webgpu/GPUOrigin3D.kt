package webgpu

import java.lang.foreign.Arena

public data class GPUOrigin3D(
    public val x: GPUIntegerCoordinate = 0u,
    public val y: GPUIntegerCoordinate = 0u,
    public val z: GPUIntegerCoordinate = 0u,
) {
    public companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(interop: GPUOrigin3D, native: WGPUOrigin3D) {
            TODO()
        }
    }
}
