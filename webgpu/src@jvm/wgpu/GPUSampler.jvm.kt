package wgpu

import lib.wgpu.WGPUSampler
import lib.wgpu.wgpuSamplerSetLabel

public actual class GPUSampler(
    private val sampler: WGPUSampler
) : GPUBindingResource, GPUObjectBase {
    actual override var label: String
        get() = TODO("Not yet implemented")
        set(value) {
            unsafeScope { wgpuSamplerSetLabel(sampler, value.into()) }
        }

    public fun into(): WGPUSampler = sampler
}
