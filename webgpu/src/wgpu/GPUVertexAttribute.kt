package wgpu

public data class GPUVertexAttribute(
    public var format: GPUVertexFormat,
    public var offset: GPUSize64,
    public var shaderLocation: GPUIndex32,
)
