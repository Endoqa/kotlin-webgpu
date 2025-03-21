package wgpu

public data class GPUPrimitiveState(
    public var topology: GPUPrimitiveTopology = GPUPrimitiveTopology.TriangleList,
    public var stripIndexFormat: GPUIndexFormat? = null,
    public var frontFace: GPUFrontFace = GPUFrontFace.CCW,
    public var cullMode: GPUCullMode = GPUCullMode.None,
    public var unclippedDepth: Boolean = false,
)
