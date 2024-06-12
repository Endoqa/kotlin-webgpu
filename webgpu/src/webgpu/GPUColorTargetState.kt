package webgpu

import java.lang.foreign.Arena

public data class GPUColorTargetState(
    public val format: GPUTextureFormat,
    public val blend: GPUBlendState? = null,
    public val writeMask: GPUColorWriteFlags = 0xFu,
) {
    public companion object {
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
