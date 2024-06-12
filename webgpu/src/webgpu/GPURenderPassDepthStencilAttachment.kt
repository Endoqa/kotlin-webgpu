package webgpu

import java.lang.foreign.Arena

public data class GPURenderPassDepthStencilAttachment(
    public val view: GPUTextureView,
    public val depthClearValue: Float = 0f,
    public val depthLoadOp: GPULoadOp = GPULoadOp.Undefined,
    public val depthStoreOp: GPUStoreOp = GPUStoreOp.Undefined,
    public val depthReadOnly: Boolean = false,
    public val stencilClearValue: GPUStencilValue = 0u,
    public val stencilLoadOp: GPULoadOp = GPULoadOp.Undefined,
    public val stencilStoreOp: GPUStoreOp = GPUStoreOp.Undefined,
    public val stencilReadOnly: Boolean = false,
) {
    public companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(
            interop: GPURenderPassDepthStencilAttachment,
            native: WGPURenderPassDepthStencilAttachment
        ) {
            TODO()
        }
    }
}
