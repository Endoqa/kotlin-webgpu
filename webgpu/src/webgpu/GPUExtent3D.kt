package webgpu

import java.lang.foreign.Arena

public data class GPUExtent3D(
    public val width: GPUIntegerCoordinate,
    public val height: GPUIntegerCoordinate = 1u,
    public val depthOrArrayLayers: GPUIntegerCoordinate = 1u,
) {
    public companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(interop: GPUExtent3D, native: WGPUExtent3D) {
            TODO()
        }
    }
}
