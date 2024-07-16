package webgpu

import webgpu.c.WGPUSamplerBindingLayout
import java.lang.foreign.Arena

data class GPUSamplerBindingLayout(
    val type: GPUSamplerBindingType = GPUSamplerBindingType.Filtering,
) {
    companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(interop: GPUSamplerBindingLayout, native: WGPUSamplerBindingLayout) {
            native.type = interop.type
        }
    }
}
