package webgpu

import java.lang.foreign.Arena

public data class GPUBlendState(
    public val color: GPUBlendComponent,
    public val alpha: GPUBlendComponent,
) {
    public companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(interop: GPUBlendState, native: WGPUBlendState) {
            TODO()
        }
    }
}
