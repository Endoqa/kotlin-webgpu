package wgpu

import lib.wgpu.*
import java.lang.foreign.MemorySegment
import java.lang.foreign.ValueLayout

public actual class GPURenderBundleEncoder(
    private val encoder: WGPURenderBundleEncoder,
) : GPUObjectBase, GPUCommandsMixin, GPUDebugCommandsMixin,
    GPUBindingCommandsMixin, GPURenderCommandsMixin {
    actual override var label: String
        get() = TODO()
        set(value) {

        }

    actual override fun pushDebugGroup(groupLabel: String) {
        return unsafeScope { wgpuRenderBundleEncoderPushDebugGroup(encoder, groupLabel.into()) }
    }

    actual override fun popDebugGroup() {
        wgpuRenderBundleEncoderPopDebugGroup(encoder)
    }

    actual override fun insertDebugMarker(markerLabel: String) {
        return unsafeScope { wgpuRenderBundleEncoderInsertDebugMarker(encoder, markerLabel.into()) }
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
            wgpuRenderBundleEncoderSetBindGroup(
                encoder,
                index, bindGroup?.into() ?: MemorySegment.NULL,
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
        wgpuRenderBundleEncoderSetPipeline(encoder, pipeline.into())
    }

    actual override fun setIndexBuffer(
        buffer: GPUBuffer,
        indexFormat: GPUIndexFormat,
        offset: GPUSize64,
        size: GPUSize64,
    ) {
        wgpuRenderBundleEncoderSetIndexBuffer(
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
        wgpuRenderBundleEncoderSetVertexBuffer(
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
        wgpuRenderBundleEncoderDraw(
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
        wgpuRenderBundleEncoderDrawIndexed(
            encoder,
            indexCount,
            instanceCount,
            firstIndex,
            baseVertex,
            firstInstance,
        )
    }

    actual override fun drawIndirect(indirectBuffer: GPUBuffer, indirectOffset: GPUSize64) {
        wgpuRenderBundleEncoderDrawIndirect(
            encoder,
            indirectBuffer.into(),
            indirectOffset,
        )
    }

    actual override fun drawIndexedIndirect(indirectBuffer: GPUBuffer, indirectOffset: GPUSize64) {
        wgpuRenderBundleEncoderDrawIndexedIndirect(
            encoder,
            indirectBuffer.into(),
            indirectOffset,
        )
    }

    public actual fun finish(descriptor: GPURenderBundleDescriptor): GPURenderBundle {
        return unsafeScope {
            GPURenderBundle(wgpuRenderBundleEncoderFinish(encoder, descriptor.into().`$mem`))
        }
    }

    public fun into(): WGPURenderBundleEncoder = encoder
}
