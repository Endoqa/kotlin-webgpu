package webgpu

import Converter
import java.lang.foreign.Arena

public data class GPUBufferBindingLayout(
    public val type: GPUBufferBindingType = GPUBufferBindingType.Uniform,
    public val hasDynamicOffset: Boolean = false,
    public val minBindingSize: GPUSize64 = 0u,
) {
    public companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(interop: GPUBufferBindingLayout, native: WGPUBufferBindingLayout) {
            native.type = interop.type
            native.hasDynamicOffset = Converter.convert(interop.hasDynamicOffset)
            native.minBindingSize = interop.minBindingSize
        }
    }
}
