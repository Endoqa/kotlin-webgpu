package webgpu

import Converter
import webgpu.c.WGPUMultisampleState
import java.lang.foreign.Arena

data class GPUMultisampleState(
    val count: GPUSize32 = 1u,
    val mask: GPUSampleMask = 0xFFFFFFFFu,
    val alphaToCoverageEnabled: Boolean = false,
) {
    companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(interop: GPUMultisampleState, native: WGPUMultisampleState) {
            native.count = interop.count
            native.mask = interop.mask
            native.alphaToCoverageEnabled = Converter.convert(interop.alphaToCoverageEnabled)
        }
    }
}
