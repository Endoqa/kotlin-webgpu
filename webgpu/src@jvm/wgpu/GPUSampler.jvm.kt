package wgpu

import lib.wgpu.WGPUSampler

public actual class GPUSampler(
    private val sampler: WGPUSampler
) : GPUBindingResource, GPUObjectBase {
    actual override var label: String
        get() = TODO("Not yet implemented")
        set(value) {}

    public fun into(): WGPUSampler = sampler
}