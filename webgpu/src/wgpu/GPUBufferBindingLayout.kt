package wgpu

public data class GPUBufferBindingLayout(
    public var type: GPUBufferBindingType = GPUBufferBindingType.Uniform,
    public var hasDynamicOffset: Boolean = false,
    public var minBindingSize: GPUSize64 = 0UL,
)
