package webgpu

import java.lang.foreign.Arena
import java.lang.foreign.MemorySegment

class GPURenderPassEncoder(
    internal val encoder_: WGPURenderPassEncoder,
    internal val desc_: GPURenderPassDescriptor,
    internal val arena: Arena,
) : GPUCommandsMixin, GPUDebugCommandsMixin, GPUBindingCommandsMixin, GPURenderCommandsMixin {


    fun setViewport(x: Float, y: Float, width: Float, height: Float, minDepth: Float, maxDepth: Float) {
        wgpuRenderPassEncoderSetViewport(encoder_, x, y, width, height, minDepth, maxDepth)
    }

    fun setScissorRect(
        x: GPUIntegerCoordinate,
        y: GPUIntegerCoordinate,
        width: GPUIntegerCoordinate,
        height: GPUIntegerCoordinate
    ) {
        wgpuRenderPassEncoderSetScissorRect(encoder_, x, y, width, height)
    }

    fun setBlendConstant(color: GPUColor) {
        // todo: is this onstack allocation correct?
        Arena.ofConfined().use { temp ->
            val c = WGPUColor.allocate(temp)
            with(temp) {
                GPUColor.convert(color, c)
            }
            wgpuRenderPassEncoderSetBlendConstant(encoder_, c.`$mem`)
        }

    }

    fun setStencilReference(reference: GPUStencilValue) {
        wgpuRenderPassEncoderSetStencilReference(encoder_, reference)
    }

    fun beginOcclusionQuery(queryIndex: GPUSize32) {
        wgpuRenderPassEncoderBeginOcclusionQuery(encoder_, queryIndex)
    }

    fun endOcclusionQuery() {
        wgpuRenderPassEncoderEndOcclusionQuery(encoder_)
    }

//    fun executeBundles(bundles: List<GPURenderBundle>) {
//        wgpuRenderPassEncoderExecuteBundles(encoder_, bundles.map { it.bundle_ }.toTypedArray())
//    }

    fun end() {
        wgpuRenderPassEncoderEnd(encoder_)
    }


    // impl
    override fun pushDebugGroup(c_str: MemorySegment) {
        wgpuRenderPassEncoderPushDebugGroup(encoder_, c_str)
    }

    override fun popDebugGroup() {
        wgpuRenderPassEncoderPopDebugGroup(encoder_)
    }

    override fun insertDebugMarker(c_str: MemorySegment) {
        wgpuRenderPassEncoderInsertDebugMarker(encoder_, c_str)
    }

    override fun setBindGroup(index: GPUIndex32, bindGroup: GPUBindGroup?, dynamicOffsets: UIntArray?) {
        if (dynamicOffsets.isNullOrEmpty()) {
            wgpuRenderPassEncoderSetBindGroup(
                encoder_, index, bindGroup?.group_ ?: MemorySegment.NULL, 0uL, MemorySegment.NULL
            )
        } else {
            wgpuRenderPassEncoderSetBindGroup(
                encoder_, index, bindGroup?.group_ ?: MemorySegment.NULL, dynamicOffsets.size.toULong(),
                MemorySegment.ofArray(dynamicOffsets.asIntArray()) //todo: jvm object pinning? (or is it a copy?)
            )
        }
    }

    override fun setPipeline(pipeline: GPURenderPipeline) {
        wgpuRenderPassEncoderSetPipeline(encoder_, pipeline.pipeline_)
    }

    override fun setIndexBuffer(buffer: GPUBuffer, indexFormat: GPUIndexFormat, offset: GPUSize64, size: GPUSize64) {
        wgpuRenderPassEncoderSetIndexBuffer(encoder_, buffer.buffer_, indexFormat, offset, size)
    }

    override fun setVertexBuffer(slot: GPUIndex32, buffer: GPUBuffer?, offset: GPUSize64, size: GPUSize64) {
        wgpuRenderPassEncoderSetVertexBuffer(encoder_, slot, buffer?.buffer_ ?: MemorySegment.NULL, offset, size)
    }

    override fun draw(
        vertexCount: GPUSize32, instanceCount: GPUSize32, firstVertex: GPUSize32, firstInstance: GPUSize32
    ) {
        wgpuRenderPassEncoderDraw(encoder_, vertexCount, instanceCount, firstVertex, firstInstance)
    }

    override fun drawIndexed(
        indexCount: GPUSize32,
        instanceCount: GPUSize32,
        firstIndex: GPUSize32,
        baseVertex: GPUSignedOffset32,
        firstInstance: GPUSize32
    ) {
        wgpuRenderPassEncoderDrawIndexed(
            encoder_, indexCount, instanceCount, firstIndex, baseVertex, firstInstance
        )
    }

    override fun drawIndirect(indirectBuffer: GPUBuffer, indirectOffset: GPUSize64) {
        wgpuRenderPassEncoderDrawIndirect(encoder_, indirectBuffer.buffer_, indirectOffset)
    }

    override fun drawIndexedIndirect(indirectBuffer: GPUBuffer, indirectOffset: GPUSize64) {
        wgpuRenderPassEncoderDrawIndexedIndirect(encoder_, indirectBuffer.buffer_, indirectOffset)
    }
}