package wgpu

import lib.wgpu.WGPUBlendOperation

public enum class GPUBlendOperation(
    public val interop: WGPUBlendOperation,
) {
    Add(WGPUBlendOperation.Add),
    Subtract(WGPUBlendOperation.Subtract),
    ReverseSubtract(WGPUBlendOperation.ReverseSubtract),
    Min(WGPUBlendOperation.Min),
    Max(WGPUBlendOperation.Max),
    ;
}
