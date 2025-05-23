package wgpu

/**
 * @param arrayStride - The stride, in bytes, between elements of this array.
 * @param stepMode - Whether each element of this array represents per-vertex data or per-instance data
 * @param attributes - An array defining the layout of the vertex attributes within each element.
 */
public data class GPUVertexBufferLayout(
    public var arrayStride: GPUSize64,
    public var stepMode: GPUVertexStepMode = GPUVertexStepMode.Vertex,
    public var attributes: List<GPUVertexAttribute>,
)
