package wgpu

import lib.wgpu.*
import java.lang.foreign.MemorySegment
import java.lang.foreign.ValueLayout

public actual class GPURenderPassEncoder(
    private val encoder: WGPURenderPassEncoder,
) : GPUObjectBase, GPUCommandsMixin, GPUDebugCommandsMixin,
    GPUBindingCommandsMixin, GPURenderCommandsMixin {
    actual override var label: String
        get() = TODO()
        set(value) {

        }

    actual override fun pushDebugGroup(groupLabel: String) {
        unsafeScope { wgpuRenderPassEncoderPushDebugGroup(encoder, groupLabel.into()) }
    }

    actual override fun popDebugGroup() {
        wgpuRenderPassEncoderPopDebugGroup(encoder)
    }

    actual override fun insertDebugMarker(markerLabel: String) {
        unsafeScope { wgpuRenderPassEncoderInsertDebugMarker(encoder, markerLabel.into()) }
    }

    actual override fun setBindGroup(
        index: GPUIndex32,
        bindGroup: GPUBindGroup?,
        dynamicOffsets: List<GPUBufferDynamicOffset>,
    ) {
        return setBindGroup(index, bindGroup, dynamicOffsets.toUIntArray())
    }

    public fun setBindGroup(index: GPUIndex32, bindGroup: GPUBindGroup?, dynamicOffsets: UIntArray) {
        unsafeScope {
            wgpuRenderPassEncoderSetBindGroup(
                encoder,
                index,
                bindGroup?.into() ?: MemorySegment.NULL,
                dynamicOffsets.size.toULong(),
                allocateFrom(ValueLayout.JAVA_INT, *dynamicOffsets.asIntArray())
            )
        }
    }

    actual override fun setBindGroup(
        index: GPUIndex32,
        bindGroup: GPUBindGroup?,
        dynamicOffsetsData: NativeBuffer,
        dynamicOffsetsDataStart: GPUSize64,
        dynamicOffsetsDataLength: GPUSize32,
    ) {
        TODO()
    }

    actual override fun setPipeline(pipeline: GPURenderPipeline) {
        wgpuRenderPassEncoderSetPipeline(encoder, pipeline.into())
    }

    actual override fun setIndexBuffer(
        buffer: GPUBuffer,
        indexFormat: GPUIndexFormat,
        offset: GPUSize64,
        size: GPUSize64,
    ) {
        wgpuRenderPassEncoderSetIndexBuffer(
            encoder,
            buffer.into(),
            indexFormat.into(),
            offset,
            size,
        )
    }

    actual override fun setVertexBuffer(
        slot: GPUIndex32,
        buffer: GPUBuffer?,
        offset: GPUSize64,
        size: GPUSize64,
    ) {
        wgpuRenderPassEncoderSetVertexBuffer(
            encoder,
            slot.toUInt(),
            buffer?.into() ?: MemorySegment.NULL,
            offset,
            size,
        )
    }

    actual override fun draw(
        vertexCount: GPUSize32,
        instanceCount: GPUSize32,
        firstVertex: GPUSize32,
        firstInstance: GPUSize32,
    ) {
        wgpuRenderPassEncoderDraw(
            encoder,
            vertexCount,
            instanceCount,
            firstVertex,
            firstInstance,
        )
    }

    actual override fun drawIndexed(
        indexCount: GPUSize32,
        instanceCount: GPUSize32,
        firstIndex: GPUSize32,
        baseVertex: GPUSignedOffset32,
        firstInstance: GPUSize32,
    ) {
        wgpuRenderPassEncoderDrawIndexed(
            encoder,
            indexCount,
            instanceCount,
            firstIndex,
            baseVertex,
            firstInstance,
        )
    }

    actual override fun drawIndirect(indirectBuffer: GPUBuffer, indirectOffset: GPUSize64) {
        wgpuRenderPassEncoderDrawIndirect(
            encoder,
            indirectBuffer.into(),
            indirectOffset,
        )
    }

    actual override fun drawIndexedIndirect(indirectBuffer: GPUBuffer, indirectOffset: GPUSize64) {
        wgpuRenderPassEncoderDrawIndexedIndirect(
            encoder,
            indirectBuffer.into(),
            indirectOffset,
        )
    }

    public actual fun setViewport(
        x: Float,
        y: Float,
        width: Float,
        height: Float,
        minDepth: Float,
        maxDepth: Float,
    ) {
        wgpuRenderPassEncoderSetViewport(
            encoder,
            x,
            y,
            width,
            height,
            minDepth,
            maxDepth,
        )
    }

    public actual fun setScissorRect(
        x: GPUIntegerCoordinate,
        y: GPUIntegerCoordinate,
        width: GPUIntegerCoordinate,
        height: GPUIntegerCoordinate,
    ) {
        wgpuRenderPassEncoderSetScissorRect(encoder, x, y, width, height)
    }

    public actual fun setBlendConstant(color: GPUColor) {
        unsafeScope {
            wgpuRenderPassEncoderSetBlendConstant(encoder, color.into().`$mem`)
        }
    }

    public actual fun setStencilReference(reference: GPUStencilValue) {
        wgpuRenderPassEncoderSetStencilReference(encoder, reference)
    }

    public actual fun beginOcclusionQuery(queryIndex: GPUSize32) {
        wgpuRenderPassEncoderBeginOcclusionQuery(encoder, queryIndex)
    }

    public actual fun endOcclusionQuery() {
        wgpuRenderPassEncoderEndOcclusionQuery(encoder)
    }

    public actual fun executeBundles(bundles: List<GPURenderBundle>) {
        TODO()
    }

    public actual fun end() {
        wgpuRenderPassEncoderEnd(encoder)
    }
}
