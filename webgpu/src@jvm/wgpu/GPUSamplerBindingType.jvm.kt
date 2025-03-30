package wgpu

import lib.wgpu.WGPUSamplerBindingType

public typealias GPUSamplerBindingTypeInterop = WGPUSamplerBindingType

public actual enum class GPUSamplerBindingType(
    internal val interop: GPUSamplerBindingTypeInterop,
) {
    BindingNotUsed(GPUSamplerBindingTypeInterop.BindingNotUsed),
    Filtering(GPUSamplerBindingTypeInterop.Filtering),
    NonFiltering(GPUSamplerBindingTypeInterop.NonFiltering),
    Comparison(GPUSamplerBindingTypeInterop.Comparison),
    ;

    public fun into(`out`: GPUSamplerBindingTypeInterop): GPUSamplerBindingTypeInterop = interop
}
