package wgpu

/**
 * @param topology - The type of primitive to be constructed from the vertex inputs.
 * @param stripIndexFormat - For pipelines with strip topologies
 * ({{GPUPrimitiveTopology/"line-strip"}} or {{GPUPrimitiveTopology/"triangle-strip"}}),
 * this determines the index buffer format and primitive restart value
 * ({{GPUIndexFormat/"uint16"}}/`0xFFFF` or {{GPUIndexFormat/"uint32"}}/`0xFFFFFFFF`).
 * It is not allowed on pipelines with non-strip topologies.
 *
 * Note: Some implementations require knowledge of the primitive restart value to compile
 * pipeline state objects.
 *
 * To use a strip-topology pipeline with an indexed draw call
 * ([wgpu.GPURenderCommandsMixin.drawIndexed] or [wgpu.GPURenderCommandsMixin.drawIndexedIndirect]),
 * this must be set, and it must match the index buffer format used with the draw call
 * (set in [wgpu.GPURenderCommandsMixin.setIndexBuffer]).
 *
 * See [[#primitive-assembly]] for additional details.
 * @param frontFace - Defines which polygons are considered front-facing.
 * @param cullMode - Defines which polygon orientation will be culled, if any.
 * @param unclippedDepth - If true, indicates that depth clipping is disabled.
 *
 * Requires the {{GPUFeatureName/"depth-clip-control"}} feature to be enabled.
 */
public data class GPUPrimitiveState(
    public var topology: GPUPrimitiveTopology = GPUPrimitiveTopology.TriangleList,
    public var stripIndexFormat: GPUIndexFormat? = null,
    public var frontFace: GPUFrontFace = GPUFrontFace.CCW,
    public var cullMode: GPUCullMode = GPUCullMode.None,
    public var unclippedDepth: Boolean = false,
)
