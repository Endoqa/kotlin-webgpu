package wgpu

import lib.wgpu.WGPUSamplerBindingType

public enum class GPUSamplerBindingType(
    public val interop: WGPUSamplerBindingType,
) {
    BindingNotUsed(WGPUSamplerBindingType.BindingNotUsed),
    Filtering(WGPUSamplerBindingType.Filtering),
    NonFiltering(WGPUSamplerBindingType.NonFiltering),
    Comparison(WGPUSamplerBindingType.Comparison),
    ;
}
