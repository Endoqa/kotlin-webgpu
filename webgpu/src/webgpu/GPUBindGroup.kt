package webgpu

import webgpu.c.WGPUBindGroup

class GPUBindGroup(
    internal val group_: WGPUBindGroup,
    internal val desc_: GPUBindGroupDescriptor,
)