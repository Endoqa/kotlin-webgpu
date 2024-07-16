package webgpu

import webgpu.c.WGPUSampler

class GPUSampler(
    internal val sampler_: WGPUSampler,
    internal val desc_: GPUSamplerDescriptor,
) : GPUBindingResource