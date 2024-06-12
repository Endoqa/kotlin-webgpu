package webgpu

class GPUCommandBuffer(
    internal val commandBuffer_: WGPUCommandBuffer,
    internal val desc_: GPUCommandBufferDescriptor,
) {
}