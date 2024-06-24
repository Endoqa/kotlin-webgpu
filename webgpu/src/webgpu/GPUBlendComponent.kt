package webgpu

import java.lang.foreign.Arena

public data class GPUBlendComponent(
    public val operation: GPUBlendOperation = GPUBlendOperation.Add,
    public val srcFactor: GPUBlendFactor = GPUBlendFactor.One,
    public val dstFactor: GPUBlendFactor = GPUBlendFactor.Zero,
) {
    public companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(interop: GPUBlendComponent, native: WGPUBlendComponent) {
            native.operation = interop.operation
            native.srcFactor = interop.srcFactor
            native.dstFactor = interop.dstFactor
        }
    }
}
