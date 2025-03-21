package wgpu

public expect class GPURenderBundleEncoder : GPUObjectBase, GPUCommandsMixin, GPUDebugCommandsMixin,
    GPUBindingCommandsMixin, GPURenderCommandsMixin {
    override var label: String

    override fun pushDebugGroup(groupLabel: String)

    override fun popDebugGroup()

    override fun insertDebugMarker(markerLabel: String)

    override fun setBindGroup(
        index: GPUIndex32,
        bindGroup: GPUBindGroup?,
        dynamicOffsets: List<GPUBufferDynamicOffset>,
    )

    override fun setBindGroup(
        index: GPUIndex32,
        bindGroup: GPUBindGroup?,
        dynamicOffsetsData: NativeBuffer,
        dynamicOffsetsDataStart: GPUSize64,
        dynamicOffsetsDataLength: GPUSize32,
    )

    override fun setPipeline(pipeline: GPURenderPipeline)

    override fun setIndexBuffer(
        buffer: GPUBuffer,
        indexFormat: GPUIndexFormat,
        offset: GPUSize64,
        size: GPUSize64,
    )

    override fun setVertexBuffer(
        slot: GPUIndex32,
        buffer: GPUBuffer?,
        offset: GPUSize64,
        size: GPUSize64,
    )

    override fun draw(
        vertexCount: GPUSize32,
        instanceCount: GPUSize32,
        firstVertex: GPUSize32,
        firstInstance: GPUSize32,
    )

    override fun drawIndexed(
        indexCount: GPUSize32,
        instanceCount: GPUSize32,
        firstIndex: GPUSize32,
        baseVertex: GPUSignedOffset32,
        firstInstance: GPUSize32,
    )

    override fun drawIndirect(indirectBuffer: GPUBuffer, indirectOffset: GPUSize64)

    override fun drawIndexedIndirect(indirectBuffer: GPUBuffer, indirectOffset: GPUSize64)

    public fun finish(descriptor: GPURenderBundleDescriptor = GPURenderBundleDescriptor()): GPURenderBundle
}
