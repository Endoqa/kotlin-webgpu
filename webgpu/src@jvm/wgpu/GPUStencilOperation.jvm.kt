package wgpu

import lib.wgpu.WGPUStencilOperation

public typealias GPUStencilOperationInterop = WGPUStencilOperation

public actual enum class GPUStencilOperation(
    internal val interop: GPUStencilOperationInterop,
) {
    Keep(GPUStencilOperationInterop.Keep),
    Zero(GPUStencilOperationInterop.Zero),
    Replace(GPUStencilOperationInterop.Replace),
    Invert(GPUStencilOperationInterop.Invert),
    IncrementClamp(GPUStencilOperationInterop.IncrementClamp),
    DecrementClamp(GPUStencilOperationInterop.DecrementClamp),
    IncrementWrap(GPUStencilOperationInterop.IncrementWrap),
    DecrementWrap(GPUStencilOperationInterop.DecrementWrap),
    ;

    public fun into(): GPUStencilOperationInterop = interop

    public companion object {
        public fun from(v: GPUStencilOperationInterop): GPUStencilOperation = when (v) {
            GPUStencilOperationInterop.Keep -> Keep
            GPUStencilOperationInterop.Zero -> Zero
            GPUStencilOperationInterop.Replace -> Replace
            GPUStencilOperationInterop.Invert -> Invert
            GPUStencilOperationInterop.IncrementClamp -> IncrementClamp
            GPUStencilOperationInterop.DecrementClamp -> DecrementClamp
            GPUStencilOperationInterop.IncrementWrap -> IncrementWrap
            GPUStencilOperationInterop.DecrementWrap -> DecrementWrap
            else -> error("Invalid GPUStencilOperation: ${'$'}v")
        }
    }
}
