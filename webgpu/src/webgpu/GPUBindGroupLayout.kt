package webgpu

import webgpu.c.WGPUBindGroupLayout

class GPUBindGroupLayout(
    internal val layout_: WGPUBindGroupLayout,
    internal val desc: GPUBindGroupLayoutDescriptor,
)