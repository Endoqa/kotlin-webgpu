package webgpu

public data class GPUBufferBinding(
    public val buffer: GPUBuffer,
    public val offset: GPUSize64 = 0u,
    public val size: GPUSize64 = 0u,
) : GPUBindingResource