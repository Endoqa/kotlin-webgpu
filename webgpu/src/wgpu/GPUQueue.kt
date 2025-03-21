package wgpu

public expect class GPUQueue : GPUObjectBase {
    override var label: String

    public fun submit(commandBuffers: List<GPUCommandBuffer>)

    public suspend fun onSubmittedWorkDone()

    public fun writeBuffer(
        buffer: GPUBuffer,
        bufferOffset: GPUSize64,
        `data`: AllowSharedBufferSource,
        dataOffset: GPUSize64 = 0UL,
        size: GPUSize64,
    )

    public fun writeTexture(
        destination: GPUTexelCopyTextureInfo,
        `data`: AllowSharedBufferSource,
        dataLayout: GPUTexelCopyBufferLayout,
        size: GPUExtent3D,
    )
}
