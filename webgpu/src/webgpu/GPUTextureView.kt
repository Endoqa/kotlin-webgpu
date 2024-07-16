package webgpu

import webgpu.c.WGPUTextureView

class GPUTextureView(
    internal val view_: WGPUTextureView,
    internal val desc_: GPUTextureViewDescriptor? = null,
) : GPUBindingResource