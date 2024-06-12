package webgpu

class GPUTextureView(
    internal val view_: WGPUTextureView,
    internal val desc_: GPUTextureViewDescriptor? = null,
) : GPUBindingResource {
}