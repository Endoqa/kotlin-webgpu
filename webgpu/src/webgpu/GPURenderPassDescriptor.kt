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
    public companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(interop: GPURenderPassDescriptor, native: WGPURenderPassDescriptor) {
            Converter.convert(this@Arena, interop.label) { native.label = it }
            native.colorAttachmentCount = Converter.convert(
                this@Arena,
                { native.colorAttachments = it },
                interop.colorAttachments,
                WGPURenderPassColorAttachment.layout,
                { attachment, mem ->
                    GPURenderPassColorAttachment.convert(attachment, WGPURenderPassColorAttachment(mem))
                }
            )

            if (interop.depthStencilAttachment != null) {
                val depthStencilAttachment = WGPURenderPassDepthStencilAttachment.allocate(this@Arena)
                GPURenderPassDepthStencilAttachment.convert(interop.depthStencilAttachment, depthStencilAttachment)
                native.depthStencilAttachment = depthStencilAttachment.`$mem`
            }

            if (interop.occlusionQuerySet != null) {
                native.occlusionQuerySet = interop.occlusionQuerySet.set_
            }

            if (interop.timestampWrites != null) {
                val timestampWrites = WGPURenderPassTimestampWrites.allocate(this@Arena)
                GPURenderPassTimestampWrites.convert(interop.timestampWrites, timestampWrites)
                native.timestampWrites = timestampWrites.`$mem`
            }

//            native.maxDrawCount = interop.maxDrawCount //todo
        }
    }
}
