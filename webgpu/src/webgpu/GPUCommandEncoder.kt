package webgpu

import Converter
import java.lang.foreign.Arena
import java.lang.foreign.MemorySegment

class GPUCommandEncoder(
    internal val encoder_: WGPUCommandEncoder,
    internal val device_: GPUDevice,
    internal val desc_: GPUCommandEncoderDescriptor,
    internal val arena: Arena,
) : GPUCommandsMixin, GPUDebugCommandsMixin {


    fun beginRenderPass(descriptor: GPURenderPassDescriptor): GPURenderPassEncoder {
        val desc = WGPURenderPassDescriptor.allocate(arena)

        val maxDrawCountDesc = WGPURenderPassDescriptorMaxDrawCount.allocate(arena)
        maxDrawCountDesc.chain.sType = WGPUSType.RenderPassDescriptorMaxDrawCount

        
        desc.nextInChain = maxDrawCountDesc.`$mem`

        with(arena) {
            Converter.convert(this, descriptor.label) { desc.label = it }
            desc.colorAttachmentCount = Converter.convert(
                this,
                { desc.colorAttachments = it },
                descriptor.colorAttachments,
                WGPURenderPassColorAttachment.layout,
                { attachment, mem ->
                    GPURenderPassColorAttachment.convert(attachment, WGPURenderPassColorAttachment(mem))
                }
            )

            if (descriptor.depthStencilAttachment != null) {
                val depthStencilAttachment = WGPURenderPassDepthStencilAttachment.allocate(this)
                GPURenderPassDepthStencilAttachment.convert(descriptor.depthStencilAttachment, depthStencilAttachment)
                desc.depthStencilAttachment = depthStencilAttachment.`$mem`
            }

            if (descriptor.occlusionQuerySet != null) {
                desc.occlusionQuerySet = descriptor.occlusionQuerySet.set_
            }

            if (descriptor.timestampWrites != null) {
                val timestampWrites = WGPURenderPassTimestampWrites.allocate(this)
                GPURenderPassTimestampWrites.convert(descriptor.timestampWrites, timestampWrites)
                desc.timestampWrites = timestampWrites.`$mem`
            }
            maxDrawCountDesc.maxDrawCount = descriptor.maxDrawCount

        }

        val encoder = wgpuCommandEncoderBeginRenderPass(encoder_, desc.`$mem`)
        return GPURenderPassEncoder(encoder, descriptor, arena)
    }

    fun beginComputePass(descriptor: GPUComputePassDescriptor = GPUComputePassDescriptor()): GPUComputePassEncoder {
        val desc = WGPUComputePassDescriptor.allocate(arena)
        with(arena) {
            GPUComputePassDescriptor.convert(descriptor, desc)
        }

        val encoder = wgpuCommandEncoderBeginComputePass(encoder_, desc.`$mem`)
        return GPUComputePassEncoder(encoder, descriptor, arena)
    }


    fun copyBufferToBuffer(
        source: GPUBuffer,
        sourceOffset: GPUSize64,
        destination: GPUBuffer,
        destinationOffset: GPUSize64,
        size: GPUSize64
    ) {
        wgpuCommandEncoderCopyBufferToBuffer(
            encoder_, source.buffer_, sourceOffset, destination.buffer_, destinationOffset, size
        )
    }


    fun finish(descriptor: GPUCommandBufferDescriptor = GPUCommandBufferDescriptor()): GPUCommandBuffer {
        val desc = WGPUCommandBufferDescriptor.allocate(arena)
        with(arena) {
            Converter.convert(this, descriptor.label) { desc.label = it }
        }

        val buffer = wgpuCommandEncoderFinish(encoder_, desc.`$mem`)
        return GPUCommandBuffer(buffer, descriptor)
    }

    // impl
    override fun pushDebugGroup(c_str: MemorySegment) {
        wgpuCommandEncoderPushDebugGroup(encoder_, c_str)
    }

    override fun popDebugGroup() {
        wgpuCommandEncoderPopDebugGroup(encoder_)
    }


    override fun insertDebugMarker(c_str: MemorySegment) {
        wgpuCommandEncoderInsertDebugMarker(encoder_, c_str)
    }
}