package wgpu

public data class GPURenderPipelineDescriptor(
    override var label: String = "",
    override var layout: GPUPipelineLayout?,
    public var vertex: GPUVertexState,
    public var primitive: GPUPrimitiveState = GPUPrimitiveState(),
    public var depthStencil: GPUDepthStencilState? = null,
    public var multisample: GPUMultisampleState = GPUMultisampleState(),
    public var fragment: GPUFragmentState? = null,
) : GPUPipelineDescriptorBase(layout = layout)
