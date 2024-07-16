package webgpu

import Converter
import webgpu.c.WGPURenderPassDepthStencilAttachment
import java.lang.foreign.Arena

data class GPURenderPassDepthStencilAttachment(
    val view: GPUTextureView,
    val depthClearValue: Float = 0f,
    val depthLoadOp: GPULoadOp = GPULoadOp.Undefined,
    val depthStoreOp: GPUStoreOp = GPUStoreOp.Undefined,
    val depthReadOnly: Boolean = false,
    val stencilClearValue: GPUStencilValue = 0u,
    val stencilLoadOp: GPULoadOp = GPULoadOp.Undefined,
    val stencilStoreOp: GPUStoreOp = GPUStoreOp.Undefined,
    val stencilReadOnly: Boolean = false,
) {
    companion object {
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
