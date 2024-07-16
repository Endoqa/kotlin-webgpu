package webgpu

import webgpu.c.WGPUBlendComponent
import java.lang.foreign.Arena

data class GPUBlendComponent(
    val operation: GPUBlendOperation = GPUBlendOperation.Add,
    val srcFactor: GPUBlendFactor = GPUBlendFactor.One,
    val dstFactor: GPUBlendFactor = GPUBlendFactor.Zero,
) {
    companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(interop: GPUBlendComponent, native: WGPUBlendComponent) {
            native.operation = interop.operation
            native.srcFactor = interop.srcFactor
            native.dstFactor = interop.dstFactor
        }
    }
}
