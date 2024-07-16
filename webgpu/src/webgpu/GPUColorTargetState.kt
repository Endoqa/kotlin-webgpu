package webgpu

import webgpu.c.WGPUBlendState
import webgpu.c.WGPUColorTargetState
import java.lang.foreign.Arena

data class GPUColorTargetState(
    val format: GPUTextureFormat,
    val blend: GPUBlendState? = null,
    val writeMask: GPUColorWriteFlags = 0xFu,
) {
    companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(interop: GPUColorTargetState, native: WGPUColorTargetState) {
            native.format = interop.format
            if (interop.blend != null) {
                val blend = WGPUBlendState.allocate(this@Arena)
                GPUBlendState.convert(interop.blend, blend)
                native.blend = blend.`$mem`
            }

            native.writeMask = interop.writeMask
        }
    }
}
