package webgpu

interface GPURenderCommandsMixin {

    fun setPipeline(pipeline: GPURenderPipeline)

    fun setIndexBuffer(buffer: GPUBuffer, indexFormat: GPUIndexFormat, offset: GPUSize64 = 0uL, size: GPUSize64)
    fun setVertexBuffer(slot: GPUIndex32, buffer: GPUBuffer?, offset: GPUSize64 = 0uL, size: GPUSize64)

    fun draw(
        vertexCount: GPUSize32,
        instanceCount: GPUSize32 = 1u,
        firstVertex: GPUSize32 = 0u,
        firstInstance: GPUSize32 = 0u
    )

    fun drawIndexed(
        indexCount: GPUSize32,
        instanceCount: GPUSize32 = 1u,
        firstIndex: GPUSize32 = 0u,
        baseVertex: GPUSignedOffset32 = 0,
        firstInstance: GPUSize32 = 0u
    )

    fun drawIndirect(indirectBuffer: GPUBuffer, indirectOffset: GPUSize64)
    fun drawIndexedIndirect(indirectBuffer: GPUBuffer, indirectOffset: GPUSize64)


}