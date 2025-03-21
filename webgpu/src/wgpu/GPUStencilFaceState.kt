package wgpu

public data class GPUStencilFaceState(
    public var compare: GPUCompareFunction = GPUCompareFunction.Always,
    public var failOp: GPUStencilOperation = GPUStencilOperation.Keep,
    public var depthFailOp: GPUStencilOperation = GPUStencilOperation.Keep,
    public var passOp: GPUStencilOperation = GPUStencilOperation.Keep,
)
