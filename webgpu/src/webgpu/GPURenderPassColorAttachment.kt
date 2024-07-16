package webgpu

import webgpu.c.WGPURenderPassColorAttachment
import java.lang.foreign.Arena
import java.lang.foreign.MemorySegment

data class GPURenderPassColorAttachment(
    var view: GPUTextureView,
    val depthSlice: GPUIntegerCoordinate = 0xffffffffU, // WGPU_DEPTH_SLICE_UNDEFINED
    val resolveTarget: GPUTextureView? = null,
    val clearValue: GPUColor? = null,
    val loadOp: GPULoadOp,
    val storeOp: GPUStoreOp,
) {
    companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(
            interop: GPURenderPassColorAttachment,
            native: WGPURenderPassColorAttachment
        ) {
            native.view = interop.view.view_
            native.depthSlice = interop.depthSlice
            native.resolveTarget = interop.resolveTarget?.view_ ?: MemorySegment.NULL
            interop.clearValue?.let { GPUColor.convert(it, native.clearValue) }
            native.loadOp = interop.loadOp
            native.storeOp = interop.storeOp
        }
    }
}
