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

    public fun into(): GPUBlendFactorInterop = interop

    public companion object {
        public fun from(v: GPUBlendFactorInterop): GPUBlendFactor = when (v) {
            GPUBlendFactorInterop.Zero -> Zero
            GPUBlendFactorInterop.One -> One
            GPUBlendFactorInterop.Src -> Src
            GPUBlendFactorInterop.OneMinusSrc -> OneMinusSrc
            GPUBlendFactorInterop.SrcAlpha -> SrcAlpha
            GPUBlendFactorInterop.OneMinusSrcAlpha -> OneMinusSrcAlpha
            GPUBlendFactorInterop.Dst -> Dst
            GPUBlendFactorInterop.OneMinusDst -> OneMinusDst
            GPUBlendFactorInterop.DstAlpha -> DstAlpha
            GPUBlendFactorInterop.OneMinusDstAlpha -> OneMinusDstAlpha
            GPUBlendFactorInterop.SrcAlphaSaturated -> SrcAlphaSaturated
            GPUBlendFactorInterop.Constant -> Constant
            GPUBlendFactorInterop.OneMinusConstant -> OneMinusConstant
            GPUBlendFactorInterop.Src1 -> Src1
            GPUBlendFactorInterop.OneMinusSrc1 -> OneMinusSrc1
            GPUBlendFactorInterop.Src1Alpha -> Src1Alpha
            GPUBlendFactorInterop.OneMinusSrc1Alpha -> OneMinusSrc1Alpha
            else -> error("Invalid GPUBlendFactor: ${'$'}v")
        }
    }
}
