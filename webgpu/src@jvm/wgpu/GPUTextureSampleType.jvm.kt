package wgpu

import lib.wgpu.WGPUTextureSampleType

public typealias GPUTextureSampleTypeInterop = WGPUTextureSampleType

public actual enum class GPUTextureSampleType(
    internal val interop: GPUTextureSampleTypeInterop,
) {
    BindingNotUsed(GPUTextureSampleTypeInterop.BindingNotUsed),
    Float(GPUTextureSampleTypeInterop.Float),
    UnfilterableFloat(GPUTextureSampleTypeInterop.UnfilterableFloat),
    Depth(GPUTextureSampleTypeInterop.Depth),
    Sint(GPUTextureSampleTypeInterop.Sint),
    Uint(GPUTextureSampleTypeInterop.Uint),
    ;

    public fun into(`out`: GPUTextureSampleTypeInterop): GPUTextureSampleTypeInterop = interop
}
