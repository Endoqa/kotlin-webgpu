package webgpu

import webgpu.c.WGPUCommandBuffer

class GPUCommandBuffer(
    internal val commandBuffer_: WGPUCommandBuffer,
    internal val desc_: GPUCommandBufferDescriptor,
)