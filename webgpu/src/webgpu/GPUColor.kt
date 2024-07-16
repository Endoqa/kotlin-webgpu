package webgpu

import webgpu.c.WGPUColor
import java.lang.foreign.Arena

data class GPUColor(
    val r: Double,
    val g: Double,
    val b: Double,
    val a: Double,
) {
    companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(interop: GPUColor, native: WGPUColor) {
            native.r = interop.r
            native.g = interop.g
            native.b = interop.b
            native.a = interop.a
        }
    }
}
