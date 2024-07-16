package webgpu

data class GPURenderPassDescriptor(
    override val label: String = "",
    val colorAttachments: List<GPURenderPassColorAttachment>,
    val depthStencilAttachment: GPURenderPassDepthStencilAttachment? = null,
    val occlusionQuerySet: GPUQuerySet? = null,
    val timestampWrites: GPURenderPassTimestampWrites? = null,
    val maxDrawCount: GPUSize64 = 50000000u,
) : GPUObjectDescriptorBase
