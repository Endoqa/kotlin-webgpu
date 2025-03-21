package wgpu

import lib.wgpu.WGPUStencilOperation

public enum class GPUStencilOperation(
    public val interop: WGPUStencilOperation,
) {
    Keep(WGPUStencilOperation.Keep),
    Zero(WGPUStencilOperation.Zero),
    Replace(WGPUStencilOperation.Replace),
    Invert(WGPUStencilOperation.Invert),
    IncrementClamp(WGPUStencilOperation.IncrementClamp),
    DecrementClamp(WGPUStencilOperation.DecrementClamp),
    IncrementWrap(WGPUStencilOperation.IncrementWrap),
    DecrementWrap(WGPUStencilOperation.DecrementWrap),
    ;
}
