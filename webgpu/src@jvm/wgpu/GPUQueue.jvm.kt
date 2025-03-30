package wgpu

import lib.wgpu.WGPUQueue

public actual class GPUQueue(
    private val queue: WGPUQueue
) : GPUObjectBase {
    actual override var label: String
        get() = TODO()
        set(value) {}

    public actual fun submit(commandBuffers: List<GPUCommandBuffer>) {
        TODO()
    }

    public actual suspend fun onSubmittedWorkDone() {
        TODO()
    }

    public actual fun writeBuffer(
        buffer: GPUBuffer,
        bufferOffset: GPUSize64,
        `data`: AllowSharedBufferSource,
        dataOffset: GPUSize64,
        size: GPUSize64,
    ) {
        TODO()
    }

    public actual fun writeTexture(
        destination: GPUTexelCopyTextureInfo,
        `data`: AllowSharedBufferSource,
        dataLayout: GPUTexelCopyBufferLayout,
        size: GPUExtent3D,
    ) {
        TODO()
    }
}
