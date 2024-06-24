package webgpu

import Converter
import java.lang.foreign.Arena
import java.lang.foreign.MemorySegment

class GPURenderBundleEncoder(
    internal val encoder_: WGPURenderBundleEncoder,
    internal val desc_: GPURenderBundleEncoderDescriptor,
    internal val arena: Arena,
) : GPUCommandsMixin, GPUDebugCommandsMixin, GPUBindingCommandsMixin, GPURenderCommandsMixin {
    //     GPURenderBundle finish(optional GPURenderBundleDescriptor descriptor = {});

    fun finish(descriptor: GPURenderBundleDescriptor = GPURenderBundleDescriptor()): GPURenderBundle {
        val desc = WGPURenderBundleDescriptor.allocate(arena)
        with(arena) {
            Converter.convert(this, descriptor.label) { desc.label = it }
        }

        val bundle = wgpuRenderBundleEncoderFinish(encoder_, desc.`$mem`)
        return GPURenderBundle(bundle, descriptor)
    }


    // impl
    override fun pushDebugGroup(c_str: MemorySegment) {
        wgpuRenderBundleEncoderPushDebugGroup(encoder_, c_str)
    }

    override fun popDebugGroup() {
        wgpuRenderBundleEncoderPopDebugGroup(encoder_)
    }

    override fun insertDebugMarker(c_str: MemorySegment) {
        wgpuRenderBundleEncoderInsertDebugMarker(encoder_, c_str)
    }

    override fun setBindGroup(index: GPUIndex32, bindGroup: GPUBindGroup?, dynamicOffsets: UIntArray?) {
        if (dynamicOffsets.isNullOrEmpty()) {
            wgpuRenderBundleEncoderSetBindGroup(
                encoder_, index, bindGroup?.group_ ?: MemorySegment.NULL, 0uL, MemorySegment.NULL
            )
        } else {
            wgpuRenderBundleEncoderSetBindGroup(
                encoder_, index, bindGroup?.group_ ?: MemorySegment.NULL, dynamicOffsets.size.toULong(),
                MemorySegment.ofArray(dynamicOffsets.asIntArray()) //todo: jvm object pinning? (or is it a copy?)
            )
        }
    }

    override fun setPipeline(pipeline: GPURenderPipeline) {
        wgpuRenderBundleEncoderSetPipeline(encoder_, pipeline.pipeline_)
    }

    override fun setIndexBuffer(buffer: GPUBuffer, indexFormat: GPUIndexFormat, offset: GPUSize64, size: GPUSize64) {
        wgpuRenderBundleEncoderSetIndexBuffer(encoder_, buffer.buffer_, indexFormat, offset, size)
    }

    override fun setVertexBuffer(slot: GPUIndex32, buffer: GPUBuffer?, offset: GPUSize64, size: GPUSize64) {
        wgpuRenderBundleEncoderSetVertexBuffer(encoder_, slot, buffer?.buffer_ ?: MemorySegment.NULL, offset, size)
    }

    override fun draw(
        vertexCount: GPUSize32, instanceCount: GPUSize32, firstVertex: GPUSize32, firstInstance: GPUSize32
    ) {
        wgpuRenderBundleEncoderDraw(encoder_, vertexCount, instanceCount, firstVertex, firstInstance)
    }

    override fun drawIndexed(
        indexCount: GPUSize32,
        instanceCount: GPUSize32,
        firstIndex: GPUSize32,
        baseVertex: GPUSignedOffset32,
        firstInstance: GPUSize32
    ) {
        wgpuRenderBundleEncoderDrawIndexed(encoder_, indexCount, instanceCount, firstIndex, baseVertex, firstInstance)
    }

    override fun drawIndirect(indirectBuffer: GPUBuffer, indirectOffset: GPUSize64) {
        wgpuRenderBundleEncoderDrawIndirect(encoder_, indirectBuffer.buffer_, indirectOffset)
    }

    override fun drawIndexedIndirect(indirectBuffer: GPUBuffer, indirectOffset: GPUSize64) {
        wgpuRenderBundleEncoderDrawIndexedIndirect(encoder_, indirectBuffer.buffer_, indirectOffset)
    }
}