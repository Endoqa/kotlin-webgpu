package wgpu

public interface GPURenderCommandsMixin {
    public fun setPipeline(pipeline: GPURenderPipeline)

    public fun setIndexBuffer(
        buffer: GPUBuffer,
        indexFormat: GPUIndexFormat,
        offset: GPUSize64 = 0UL,
        size: GPUSize64,
    )

    public fun setVertexBuffer(
        slot: GPUIndex32,
        buffer: GPUBuffer?,
        offset: GPUSize64 = 0UL,
        size: GPUSize64,
    )

    public fun draw(
        vertexCount: GPUSize32,
        instanceCount: GPUSize32 = 1U,
        firstVertex: GPUSize32 = 0U,
        firstInstance: GPUSize32 = 0U,
    )

    public fun drawIndexed(
        indexCount: GPUSize32,
        instanceCount: GPUSize32 = 1U,
        firstIndex: GPUSize32 = 0U,
        baseVertex: GPUSignedOffset32 = 0,
        firstInstance: GPUSize32 = 0U,
    )

    public fun drawIndirect(indirectBuffer: GPUBuffer, indirectOffset: GPUSize64)

    public fun drawIndexedIndirect(indirectBuffer: GPUBuffer, indirectOffset: GPUSize64)
}
