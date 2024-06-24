package webgpu

import Converter
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
            native.view = interop.view.view_
            native.depthClearValue = interop.depthClearValue
            native.depthLoadOp = interop.depthLoadOp
            native.depthStoreOp = interop.depthStoreOp
            native.depthReadOnly = Converter.convert(interop.depthReadOnly)
            native.stencilClearValue = interop.stencilClearValue
            native.stencilLoadOp = interop.stencilLoadOp
            native.stencilStoreOp = interop.stencilStoreOp
            native.stencilReadOnly = Converter.convert(interop.stencilReadOnly)
        }
    }
}
