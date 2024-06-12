package webgpu

class GPUBindGroup(
    internal val group_: WGPUBindGroup,
    internal val desc_: GPUBindGroupDescriptor,
) {
}