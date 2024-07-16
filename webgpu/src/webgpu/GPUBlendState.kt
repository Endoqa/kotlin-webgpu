package webgpu


import webgpu.c.WGPUBlendState
import java.lang.foreign.Arena

data class GPUBlendState(
    val color: GPUBlendComponent,
    val alpha: GPUBlendComponent,
) {
    companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(interop: GPUBlendState, native: WGPUBlendState) {
            GPUBlendComponent.convert(interop.color, native.color)
            GPUBlendComponent.convert(interop.alpha, native.alpha)
        }
    }
}
