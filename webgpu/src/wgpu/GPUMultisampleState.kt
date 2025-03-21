package wgpu

public data class GPUMultisampleState(
    public var count: GPUSize32 = 1U,
    public var mask: GPUSampleMask = 0xFFFFFFFFU,
    public var alphaToCoverageEnabled: Boolean = false,
)
