package wgpu

public data class GPUBlendComponent(
    public var operation: GPUBlendOperation = GPUBlendOperation.Add,
    public var srcFactor: GPUBlendFactor = GPUBlendFactor.One,
    public var dstFactor: GPUBlendFactor = GPUBlendFactor.Zero,
)
