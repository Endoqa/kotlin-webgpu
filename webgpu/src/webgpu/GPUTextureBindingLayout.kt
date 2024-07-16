package webgpu

import Converter
import webgpu.c.WGPUTextureBindingLayout
import java.lang.foreign.Arena

data class GPUTextureBindingLayout(
    val sampleType: GPUTextureSampleType = GPUTextureSampleType.Float,
    val viewDimension: GPUTextureViewDimension = GPUTextureViewDimension.`2D`,
    val multisampled: Boolean = false,
) {
    companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(interop: GPUTextureBindingLayout, native: WGPUTextureBindingLayout) {
            native.sampleType = interop.sampleType
            native.viewDimension = interop.viewDimension
            native.multisampled = Converter.convert(interop.multisampled)
        }
    }
}
