package webgpu

import webgpu.c.WGPUPipelineLayout

class GPUPipelineLayout(
    internal val layout_: WGPUPipelineLayout,
    internal val desc_: GPUPipelineLayoutDescriptor,
)