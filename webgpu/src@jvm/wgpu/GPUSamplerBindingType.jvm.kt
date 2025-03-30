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

    public fun into(): GPUSamplerBindingTypeInterop = interop

    public companion object {
        public fun from(v: GPUSamplerBindingTypeInterop): GPUSamplerBindingType = when (v) {
            GPUSamplerBindingTypeInterop.BindingNotUsed -> BindingNotUsed
            GPUSamplerBindingTypeInterop.Filtering -> Filtering
            GPUSamplerBindingTypeInterop.NonFiltering -> NonFiltering
            GPUSamplerBindingTypeInterop.Comparison -> Comparison
            else -> error("Invalid GPUSamplerBindingType: ${'$'}v")
        }
    }
}
