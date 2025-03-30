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

    public fun into(`out`: GPUStencilOperationInterop): GPUStencilOperationInterop = interop
}
