package wgpu

/**
 * @param vertex - Describes the vertex shader entry point of the pipeline and its input buffer layouts.
 * @param primitive - Describes the primitive-related properties of the pipeline.
 * @param depthStencil - Describes the optional depth-stencil properties, including the testing, operations, and bias.
 * @param multisample - Describes the multi-sampling properties of the pipeline.
 * @param fragment - Describes the fragment shader entry point of the pipeline and its output colors. If
 * not map/exist|provided, the [[#no-color-output]] mode is enabled.
 */
public data class GPURenderPipelineDescriptor(
    override var label: String = "",
    override var layout: GPUPipelineLayout?,
    public var vertex: GPUVertexState,
    public var primitive: GPUPrimitiveState = GPUPrimitiveState(),
    public var depthStencil: GPUDepthStencilState? = null,
    public var multisample: GPUMultisampleState = GPUMultisampleState(),
    public var fragment: GPUFragmentState? = null,
) : GPUPipelineDescriptorBase(layout = layout)
