package wgpu

import lib.wgpu.WGPUBlendOperation

public typealias GPUBlendOperationInterop = WGPUBlendOperation

public actual enum class GPUBlendOperation(
    internal val interop: GPUBlendOperationInterop,
) {
    Add(GPUBlendOperationInterop.Add),
    Subtract(GPUBlendOperationInterop.Subtract),
    ReverseSubtract(GPUBlendOperationInterop.ReverseSubtract),
    Min(GPUBlendOperationInterop.Min),
    Max(GPUBlendOperationInterop.Max),
    ;

    public fun into(`out`: GPUBlendOperationInterop): GPUBlendOperationInterop = interop
}
