package wgpu

/**
 * @param operation - Defines the [wgpu.GPUBlendOperation] used to calculate the values written to the target
 * attachment components.
 * @param srcFactor - Defines the [wgpu.GPUBlendFactor] operation to be performed on values from the fragment shader.
 * @param dstFactor - Defines the [wgpu.GPUBlendFactor] operation to be performed on values from the target attachment.
 */
public data class GPUBlendComponent(
    public var operation: GPUBlendOperation = GPUBlendOperation.Add,
    public var srcFactor: GPUBlendFactor = GPUBlendFactor.One,
    public var dstFactor: GPUBlendFactor = GPUBlendFactor.Zero,
)
