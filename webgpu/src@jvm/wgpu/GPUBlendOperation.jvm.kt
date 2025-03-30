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

    public fun into(): GPUBlendOperationInterop = interop

    public companion object {
        public fun from(v: GPUBlendOperationInterop): GPUBlendOperation = when (v) {
            GPUBlendOperationInterop.Add -> Add
            GPUBlendOperationInterop.Subtract -> Subtract
            GPUBlendOperationInterop.ReverseSubtract -> ReverseSubtract
            GPUBlendOperationInterop.Min -> Min
            GPUBlendOperationInterop.Max -> Max
            else -> error("Invalid GPUBlendOperation: ${'$'}v")
        }
    }
}
