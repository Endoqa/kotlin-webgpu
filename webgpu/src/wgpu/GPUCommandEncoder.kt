package wgpu

public expect class GPUCommandEncoder : GPUObjectBase, GPUCommandsMixin, GPUDebugCommandsMixin {
    override var label: String

    override fun pushDebugGroup(groupLabel: String)

    override fun popDebugGroup()

    override fun insertDebugMarker(markerLabel: String)

    public fun beginRenderPass(descriptor: GPURenderPassDescriptor): GPURenderPassEncoder

    public fun beginComputePass(descriptor: GPUComputePassDescriptor = GPUComputePassDescriptor()): GPUComputePassEncoder

    public fun copyBufferToBuffer(
        source: GPUBuffer,
        sourceOffset: GPUSize64,
        destination: GPUBuffer,
        destinationOffset: GPUSize64,
        size: GPUSize64,
    )

    public fun copyBufferToTexture(
        source: GPUTexelCopyBufferInfo,
        destination: GPUTexelCopyTextureInfo,
        copySize: GPUExtent3D,
    )

    public fun copyTextureToBuffer(
        source: GPUTexelCopyTextureInfo,
        destination: GPUTexelCopyBufferInfo,
        copySize: GPUExtent3D,
    )

    public fun copyTextureToTexture(
        source: GPUTexelCopyTextureInfo,
        destination: GPUTexelCopyTextureInfo,
        copySize: GPUExtent3D,
    )

    public fun clearBuffer(
        buffer: GPUBuffer,
        offset: GPUSize64 = 0UL,
        size: GPUSize64,
    )

    public fun resolveQuerySet(
        querySet: GPUQuerySet,
        firstQuery: GPUSize32,
        queryCount: GPUSize32,
        destination: GPUBuffer,
        destinationOffset: GPUSize64,
    )

    public fun finish(descriptor: GPUCommandBufferDescriptor = GPUCommandBufferDescriptor()): GPUCommandBuffer
}
