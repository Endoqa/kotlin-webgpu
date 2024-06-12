package webgpu

import Converter
import java.lang.foreign.Arena

public data class GPUTextureBindingLayout(
    public val sampleType: GPUTextureSampleType = GPUTextureSampleType.Float,
    public val viewDimension: GPUTextureViewDimension = GPUTextureViewDimension.`2D`,
    public val multisampled: Boolean = false,
) {
    public companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(interop: GPUTextureBindingLayout, native: WGPUTextureBindingLayout) {
            native.sampleType = interop.sampleType
            native.viewDimension = interop.viewDimension
            native.multisampled = Converter.convert(interop.multisampled)
        }
    }
}
