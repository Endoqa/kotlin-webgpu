package wgpu

public data class GPURenderPassDescriptor(
    override var label: String = "",
    public var colorAttachments: List<GPURenderPassColorAttachment?>,
    public var depthStencilAttachment: GPURenderPassDepthStencilAttachment? = null,
    public var occlusionQuerySet: GPUQuerySet? = null,
    public var timestampWrites: GPURenderPassTimestampWrites? = null,
    public var maxDrawCount: GPUSize64 = 50000000UL,
) : GPUObjectDescriptorBase(label = label)
