package webgpu

import java.lang.foreign.Arena

public data class GPUColor(
    public val r: Double,
    public val g: Double,
    public val b: Double,
    public val a: Double,
) {
    public companion object {
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
