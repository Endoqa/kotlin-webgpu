package webgpu

import webgpu.c.WGPUExtent3D
import java.lang.foreign.Arena

data class GPUExtent3D(
    val width: GPUIntegerCoordinate,
    val height: GPUIntegerCoordinate = 1u,
    val depthOrArrayLayers: GPUIntegerCoordinate = 1u,
) {
    companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(interop: GPUExtent3D, native: WGPUExtent3D) {
            native.width = interop.width
            native.height = interop.height
            native.depthOrArrayLayers = native.depthOrArrayLayers
        }
    }
}
