package wgpu

import lib.wgpu.WGPUBlendFactor

public enum class GPUBlendFactor(
    public val interop: WGPUBlendFactor,
) {
    Zero(WGPUBlendFactor.Zero),
    One(WGPUBlendFactor.One),
    Src(WGPUBlendFactor.Src),
    OneMinusSrc(WGPUBlendFactor.OneMinusSrc),
    SrcAlpha(WGPUBlendFactor.SrcAlpha),
    OneMinusSrcAlpha(WGPUBlendFactor.OneMinusSrcAlpha),
    Dst(WGPUBlendFactor.Dst),
    OneMinusDst(WGPUBlendFactor.OneMinusDst),
    DstAlpha(WGPUBlendFactor.DstAlpha),
    OneMinusDstAlpha(WGPUBlendFactor.OneMinusDstAlpha),
    SrcAlphaSaturated(WGPUBlendFactor.SrcAlphaSaturated),
    Constant(WGPUBlendFactor.Constant),
    OneMinusConstant(WGPUBlendFactor.OneMinusConstant),
    Src1(WGPUBlendFactor.Src1),
    OneMinusSrc1(WGPUBlendFactor.OneMinusSrc1),
    Src1Alpha(WGPUBlendFactor.Src1Alpha),
    OneMinusSrc1Alpha(WGPUBlendFactor.OneMinusSrc1Alpha),
    ;
}
