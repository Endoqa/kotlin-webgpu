package wgpu

public data class GPUVertexBufferLayout(
    public var arrayStride: GPUSize64,
    public var stepMode: GPUVertexStepMode = GPUVertexStepMode.Vertex,
    public var attributes: List<GPUVertexAttribute>,
)
