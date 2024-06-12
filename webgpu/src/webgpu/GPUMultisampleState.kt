package webgpu

import Converter
import java.lang.foreign.Arena

public data class GPUMultisampleState(
    public val count: GPUSize32 = 1u,
    public val mask: GPUSampleMask = 0xFFFFFFFFu,
    public val alphaToCoverageEnabled: Boolean = false,
) {
    public companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(interop: GPUMultisampleState, native: WGPUMultisampleState) {
            native.count = interop.count
            native.mask = interop.mask
            native.alphaToCoverageEnabled = Converter.convert(interop.alphaToCoverageEnabled)
        }
    }
}
