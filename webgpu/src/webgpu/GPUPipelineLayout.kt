package webgpu

class GPUPipelineLayout(
    internal val layout_: WGPUPipelineLayout,
    internal val desc_: GPUPipelineLayoutDescriptor,
) {
}