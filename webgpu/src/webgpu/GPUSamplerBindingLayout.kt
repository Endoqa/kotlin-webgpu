package webgpu

import java.lang.foreign.Arena

public data class GPUSamplerBindingLayout(
    public val type: GPUSamplerBindingType = GPUSamplerBindingType.Filtering,
) {
    public companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(interop: GPUSamplerBindingLayout, native: WGPUSamplerBindingLayout) {
            TODO()
        }
    }
}
