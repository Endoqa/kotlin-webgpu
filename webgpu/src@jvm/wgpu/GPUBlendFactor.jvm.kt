package wgpu

import lib.wgpu.WGPUBlendFactor

public typealias GPUBlendFactorInterop = WGPUBlendFactor

public actual enum class GPUBlendFactor(
    internal val interop: GPUBlendFactorInterop,
) {
    Zero(GPUBlendFactorInterop.Zero),
    One(GPUBlendFactorInterop.One),
    Src(GPUBlendFactorInterop.Src),
    OneMinusSrc(GPUBlendFactorInterop.OneMinusSrc),
    SrcAlpha(GPUBlendFactorInterop.SrcAlpha),
    OneMinusSrcAlpha(GPUBlendFactorInterop.OneMinusSrcAlpha),
    Dst(GPUBlendFactorInterop.Dst),
    OneMinusDst(GPUBlendFactorInterop.OneMinusDst),
    DstAlpha(GPUBlendFactorInterop.DstAlpha),
    OneMinusDstAlpha(GPUBlendFactorInterop.OneMinusDstAlpha),
    SrcAlphaSaturated(GPUBlendFactorInterop.SrcAlphaSaturated),
    Constant(GPUBlendFactorInterop.Constant),
    OneMinusConstant(GPUBlendFactorInterop.OneMinusConstant),
    Src1(GPUBlendFactorInterop.Src1),
    OneMinusSrc1(GPUBlendFactorInterop.OneMinusSrc1),
    Src1Alpha(GPUBlendFactorInterop.Src1Alpha),
    OneMinusSrc1Alpha(GPUBlendFactorInterop.OneMinusSrc1Alpha),
    ;

    public fun into(`out`: GPUBlendFactorInterop): GPUBlendFactorInterop = interop
}
