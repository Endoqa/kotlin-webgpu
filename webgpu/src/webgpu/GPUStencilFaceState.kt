package webgpu

import webgpu.c.WGPUStencilFaceState
import java.lang.foreign.Arena

data class GPUStencilFaceState(
    val compare: GPUCompareFunction = GPUCompareFunction.Always,
    val failOp: GPUStencilOperation = GPUStencilOperation.Keep,
    val depthFailOp: GPUStencilOperation = GPUStencilOperation.Keep,
    val passOp: GPUStencilOperation = GPUStencilOperation.Keep,
) {
    companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(interop: GPUStencilFaceState, native: WGPUStencilFaceState) {
            native.compare = interop.compare
            native.failOp = interop.failOp
            native.depthFailOp = interop.depthFailOp
            native.passOp = interop.passOp
        }
    }
}
