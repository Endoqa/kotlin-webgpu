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

    public fun into(): GPUTextureSampleTypeInterop = interop

    public companion object {
        public fun from(v: GPUTextureSampleTypeInterop): GPUTextureSampleType = when (v) {
            GPUTextureSampleTypeInterop.BindingNotUsed -> BindingNotUsed
            GPUTextureSampleTypeInterop.Float -> Float
            GPUTextureSampleTypeInterop.UnfilterableFloat -> UnfilterableFloat
            GPUTextureSampleTypeInterop.Depth -> Depth
            GPUTextureSampleTypeInterop.Sint -> Sint
            GPUTextureSampleTypeInterop.Uint -> Uint
            else -> error("Invalid GPUTextureSampleType: ${'$'}v")
        }
    }
}
