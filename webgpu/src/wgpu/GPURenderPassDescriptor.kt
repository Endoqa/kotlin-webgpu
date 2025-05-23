package wgpu

/**
 * @param colorAttachments - The set of [wgpu.GPURenderPassColorAttachment] values in this sequence defines which
 * color attachments will be output to when executing this render pass.
 *
 * Due to compatible usage list|usage compatibility, no color attachment
 * may alias another attachment or any resource used inside the render pass.
 * @param depthStencilAttachment - The [wgpu.GPURenderPassDepthStencilAttachment] value that defines the depth/stencil
 * attachment that will be output to and tested against when executing this render pass.
 *
 * Due to compatible usage list|usage compatibility, no writable depth/stencil attachment
 * may alias another attachment or any resource used inside the render pass.
 * @param occlusionQuerySet - The [wgpu.GPUQuerySet] value defines where the occlusion query results will be stored for this pass.
 * @param timestampWrites - Defines which timestamp values will be written for this pass, and where to write them to.
 * @param maxDrawCount - The maximum number of draw calls that will be done in the render pass. Used by some
 * implementations to size work injected before the render pass. Keeping the default value
 * is a good default, unless it is known that more draw calls will be done.
 */
public data class GPURenderPassDescriptor(
    override var label: String = "",
    public var colorAttachments: List<GPURenderPassColorAttachment?>,
    public var depthStencilAttachment: GPURenderPassDepthStencilAttachment? = null,
    public var occlusionQuerySet: GPUQuerySet? = null,
    public var timestampWrites: GPURenderPassTimestampWrites? = null,
    public var maxDrawCount: GPUSize64 = 50000000UL,
) : GPUObjectDescriptorBase(label = label)
