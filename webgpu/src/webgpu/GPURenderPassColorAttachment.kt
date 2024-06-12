package webgpu

import java.lang.foreign.Arena
import java.lang.foreign.MemorySegment

public data class GPURenderPassColorAttachment(
    public var view: GPUTextureView,
    public val depthSlice: GPUIntegerCoordinate = 0xffffffffU, // WGPU_DEPTH_SLICE_UNDEFINED
    public val resolveTarget: GPUTextureView? = null,
    public val clearValue: GPUColor? = null,
    public val loadOp: GPULoadOp,
    public val storeOp: GPUStoreOp,
) {
    public companion object {
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
