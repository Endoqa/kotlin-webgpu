package webgpu

import Converter
import java.lang.foreign.Arena

public data class GPURenderPassDescriptor(
    override val label: String = "",
    public val colorAttachments: List<GPURenderPassColorAttachment>,
    public val depthStencilAttachment: GPURenderPassDepthStencilAttachment? = null,
    public val occlusionQuerySet: GPUQuerySet? = null,
    public val timestampWrites: GPURenderPassTimestampWrites? = null,
    public val maxDrawCount: GPUSize64 = 50000000u,
) : GPUObjectDescriptorBase {

    
}
