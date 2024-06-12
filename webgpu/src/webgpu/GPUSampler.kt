package webgpu

class GPUSampler(
    internal val sampler_: WGPUSampler,
    internal val desc_: GPUSamplerDescriptor,
) : GPUBindingResource {
}