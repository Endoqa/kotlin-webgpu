package webgpu

import java.lang.foreign.Arena

public data class GPUStencilFaceState(
    public val compare: GPUCompareFunction = GPUCompareFunction.Always,
    public val failOp: GPUStencilOperation = GPUStencilOperation.Keep,
    public val depthFailOp: GPUStencilOperation = GPUStencilOperation.Keep,
    public val passOp: GPUStencilOperation = GPUStencilOperation.Keep,
) {
    public companion object {
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
