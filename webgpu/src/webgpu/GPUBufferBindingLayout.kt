package webgpu

import Converter
import webgpu.c.WGPUBufferBindingLayout
import java.lang.foreign.Arena

data class GPUBufferBindingLayout(
    val type: GPUBufferBindingType = GPUBufferBindingType.Uniform,
    val hasDynamicOffset: Boolean = false,
    val minBindingSize: GPUSize64 = 0u,
) {
    companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(interop: GPUBufferBindingLayout, native: WGPUBufferBindingLayout) {
            native.type = interop.type
            native.hasDynamicOffset = Converter.convert(interop.hasDynamicOffset)
            native.minBindingSize = interop.minBindingSize
        }
    }
}
