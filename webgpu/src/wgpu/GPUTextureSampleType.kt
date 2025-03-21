package wgpu

import lib.wgpu.WGPUTextureSampleType

public enum class GPUTextureSampleType(
    public val interop: WGPUTextureSampleType,
) {
    BindingNotUsed(WGPUTextureSampleType.BindingNotUsed),
    Float(WGPUTextureSampleType.Float),
    UnfilterableFloat(WGPUTextureSampleType.UnfilterableFloat),
    Depth(WGPUTextureSampleType.Depth),
    Sint(WGPUTextureSampleType.Sint),
    Uint(WGPUTextureSampleType.Uint),
    ;
}
