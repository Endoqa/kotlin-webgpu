package wgpu

public data class GPUBufferBinding(
    public var buffer: GPUBuffer,
    public var offset: GPUSize64 = 0UL,
    public var size: GPUSize64? = null,
) : GPUBindingResource
