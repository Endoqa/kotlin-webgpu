package wgpu

import lib.wgpu.WGPUTextureFormat

public typealias GPUTextureFormatInterop = WGPUTextureFormat

public actual enum class GPUTextureFormat(
    internal val interop: GPUTextureFormatInterop,
) {
    R8Unorm(GPUTextureFormatInterop.R8Unorm),
    R8Snorm(GPUTextureFormatInterop.R8Snorm),
    R8Uint(GPUTextureFormatInterop.R8Uint),
    R8Sint(GPUTextureFormatInterop.R8Sint),
    R16Uint(GPUTextureFormatInterop.R16Uint),
    R16Sint(GPUTextureFormatInterop.R16Sint),
    R16Float(GPUTextureFormatInterop.R16Float),
    RG8Unorm(GPUTextureFormatInterop.RG8Unorm),
    RG8Snorm(GPUTextureFormatInterop.RG8Snorm),
    RG8Uint(GPUTextureFormatInterop.RG8Uint),
    RG8Sint(GPUTextureFormatInterop.RG8Sint),
    R32Float(GPUTextureFormatInterop.R32Float),
    R32Uint(GPUTextureFormatInterop.R32Uint),
    R32Sint(GPUTextureFormatInterop.R32Sint),
    RG16Uint(GPUTextureFormatInterop.RG16Uint),
    RG16Sint(GPUTextureFormatInterop.RG16Sint),
    RG16Float(GPUTextureFormatInterop.RG16Float),
    RGBA8Unorm(GPUTextureFormatInterop.RGBA8Unorm),
    RGBA8UnormSrgb(GPUTextureFormatInterop.RGBA8UnormSrgb),
    RGBA8Snorm(GPUTextureFormatInterop.RGBA8Snorm),
    RGBA8Uint(GPUTextureFormatInterop.RGBA8Uint),
    RGBA8Sint(GPUTextureFormatInterop.RGBA8Sint),
    BGRA8Unorm(GPUTextureFormatInterop.BGRA8Unorm),
    BGRA8UnormSrgb(GPUTextureFormatInterop.BGRA8UnormSrgb),
    RGB10A2Uint(GPUTextureFormatInterop.RGB10A2Uint),
    RGB10A2Unorm(GPUTextureFormatInterop.RGB10A2Unorm),
    RG11B10Ufloat(GPUTextureFormatInterop.RG11B10Ufloat),
    RGB9E5Ufloat(GPUTextureFormatInterop.RGB9E5Ufloat),
    RG32Float(GPUTextureFormatInterop.RG32Float),
    RG32Uint(GPUTextureFormatInterop.RG32Uint),
    RG32Sint(GPUTextureFormatInterop.RG32Sint),
    RGBA16Uint(GPUTextureFormatInterop.RGBA16Uint),
    RGBA16Sint(GPUTextureFormatInterop.RGBA16Sint),
    RGBA16Float(GPUTextureFormatInterop.RGBA16Float),
    RGBA32Float(GPUTextureFormatInterop.RGBA32Float),
    RGBA32Uint(GPUTextureFormatInterop.RGBA32Uint),
    RGBA32Sint(GPUTextureFormatInterop.RGBA32Sint),
    Stencil8(GPUTextureFormatInterop.Stencil8),
    Depth16Unorm(GPUTextureFormatInterop.Depth16Unorm),
    Depth24Plus(GPUTextureFormatInterop.Depth24Plus),
    Depth24PlusStencil8(GPUTextureFormatInterop.Depth24PlusStencil8),
    Depth32Float(GPUTextureFormatInterop.Depth32Float),
    Depth32FloatStencil8(GPUTextureFormatInterop.Depth32FloatStencil8),
    BC1RGBAUnorm(GPUTextureFormatInterop.BC1RGBAUnorm),
    BC1RGBAUnormSrgb(GPUTextureFormatInterop.BC1RGBAUnormSrgb),
    BC2RGBAUnorm(GPUTextureFormatInterop.BC2RGBAUnorm),
    BC2RGBAUnormSrgb(GPUTextureFormatInterop.BC2RGBAUnormSrgb),
    BC3RGBAUnorm(GPUTextureFormatInterop.BC3RGBAUnorm),
    BC3RGBAUnormSrgb(GPUTextureFormatInterop.BC3RGBAUnormSrgb),
    BC4RUnorm(GPUTextureFormatInterop.BC4RUnorm),
    BC4RSnorm(GPUTextureFormatInterop.BC4RSnorm),
    BC5RGUnorm(GPUTextureFormatInterop.BC5RGUnorm),
    BC5RGSnorm(GPUTextureFormatInterop.BC5RGSnorm),
    BC6HRGBUfloat(GPUTextureFormatInterop.BC6HRGBUfloat),
    BC6HRGBFloat(GPUTextureFormatInterop.BC6HRGBFloat),
    BC7RGBAUnorm(GPUTextureFormatInterop.BC7RGBAUnorm),
    BC7RGBAUnormSrgb(GPUTextureFormatInterop.BC7RGBAUnormSrgb),
    ETC2RGB8Unorm(GPUTextureFormatInterop.ETC2RGB8Unorm),
    ETC2RGB8UnormSrgb(GPUTextureFormatInterop.ETC2RGB8UnormSrgb),
    ETC2RGB8A1Unorm(GPUTextureFormatInterop.ETC2RGB8A1Unorm),
    ETC2RGB8A1UnormSrgb(GPUTextureFormatInterop.ETC2RGB8A1UnormSrgb),
    ETC2RGBA8Unorm(GPUTextureFormatInterop.ETC2RGBA8Unorm),
    ETC2RGBA8UnormSrgb(GPUTextureFormatInterop.ETC2RGBA8UnormSrgb),
    EACR11Unorm(GPUTextureFormatInterop.EACR11Unorm),
    EACR11Snorm(GPUTextureFormatInterop.EACR11Snorm),
    EACRG11Unorm(GPUTextureFormatInterop.EACRG11Unorm),
    EACRG11Snorm(GPUTextureFormatInterop.EACRG11Snorm),
    ASTC4x4Unorm(GPUTextureFormatInterop.ASTC4x4Unorm),
    ASTC4x4UnormSrgb(GPUTextureFormatInterop.ASTC4x4UnormSrgb),
    ASTC5x4Unorm(GPUTextureFormatInterop.ASTC5x4Unorm),
    ASTC5x4UnormSrgb(GPUTextureFormatInterop.ASTC5x4UnormSrgb),
    ASTC5x5Unorm(GPUTextureFormatInterop.ASTC5x5Unorm),
    ASTC5x5UnormSrgb(GPUTextureFormatInterop.ASTC5x5UnormSrgb),
    ASTC6x5Unorm(GPUTextureFormatInterop.ASTC6x5Unorm),
    ASTC6x5UnormSrgb(GPUTextureFormatInterop.ASTC6x5UnormSrgb),
    ASTC6x6Unorm(GPUTextureFormatInterop.ASTC6x6Unorm),
    ASTC6x6UnormSrgb(GPUTextureFormatInterop.ASTC6x6UnormSrgb),
    ASTC8x5Unorm(GPUTextureFormatInterop.ASTC8x5Unorm),
    ASTC8x5UnormSrgb(GPUTextureFormatInterop.ASTC8x5UnormSrgb),
    ASTC8x6Unorm(GPUTextureFormatInterop.ASTC8x6Unorm),
    ASTC8x6UnormSrgb(GPUTextureFormatInterop.ASTC8x6UnormSrgb),
    ASTC8x8Unorm(GPUTextureFormatInterop.ASTC8x8Unorm),
    ASTC8x8UnormSrgb(GPUTextureFormatInterop.ASTC8x8UnormSrgb),
    ASTC10x5Unorm(GPUTextureFormatInterop.ASTC10x5Unorm),
    ASTC10x5UnormSrgb(GPUTextureFormatInterop.ASTC10x5UnormSrgb),
    ASTC10x6Unorm(GPUTextureFormatInterop.ASTC10x6Unorm),
    ASTC10x6UnormSrgb(GPUTextureFormatInterop.ASTC10x6UnormSrgb),
    ASTC10x8Unorm(GPUTextureFormatInterop.ASTC10x8Unorm),
    ASTC10x8UnormSrgb(GPUTextureFormatInterop.ASTC10x8UnormSrgb),
    ASTC10x10Unorm(GPUTextureFormatInterop.ASTC10x10Unorm),
    ASTC10x10UnormSrgb(GPUTextureFormatInterop.ASTC10x10UnormSrgb),
    ASTC12x10Unorm(GPUTextureFormatInterop.ASTC12x10Unorm),
    ASTC12x10UnormSrgb(GPUTextureFormatInterop.ASTC12x10UnormSrgb),
    ASTC12x12Unorm(GPUTextureFormatInterop.ASTC12x12Unorm),
    ASTC12x12UnormSrgb(GPUTextureFormatInterop.ASTC12x12UnormSrgb),
    ;

    public fun into(): GPUTextureFormatInterop = interop

    public companion object {
        public fun from(v: GPUTextureFormatInterop): GPUTextureFormat = when (v) {
            GPUTextureFormatInterop.R8Unorm -> R8Unorm
            GPUTextureFormatInterop.R8Snorm -> R8Snorm
            GPUTextureFormatInterop.R8Uint -> R8Uint
            GPUTextureFormatInterop.R8Sint -> R8Sint
            GPUTextureFormatInterop.R16Uint -> R16Uint
            GPUTextureFormatInterop.R16Sint -> R16Sint
            GPUTextureFormatInterop.R16Float -> R16Float
            GPUTextureFormatInterop.RG8Unorm -> RG8Unorm
            GPUTextureFormatInterop.RG8Snorm -> RG8Snorm
            GPUTextureFormatInterop.RG8Uint -> RG8Uint
            GPUTextureFormatInterop.RG8Sint -> RG8Sint
            GPUTextureFormatInterop.R32Float -> R32Float
            GPUTextureFormatInterop.R32Uint -> R32Uint
            GPUTextureFormatInterop.R32Sint -> R32Sint
            GPUTextureFormatInterop.RG16Uint -> RG16Uint
            GPUTextureFormatInterop.RG16Sint -> RG16Sint
            GPUTextureFormatInterop.RG16Float -> RG16Float
            GPUTextureFormatInterop.RGBA8Unorm -> RGBA8Unorm
            GPUTextureFormatInterop.RGBA8UnormSrgb -> RGBA8UnormSrgb
            GPUTextureFormatInterop.RGBA8Snorm -> RGBA8Snorm
            GPUTextureFormatInterop.RGBA8Uint -> RGBA8Uint
            GPUTextureFormatInterop.RGBA8Sint -> RGBA8Sint
            GPUTextureFormatInterop.BGRA8Unorm -> BGRA8Unorm
            GPUTextureFormatInterop.BGRA8UnormSrgb -> BGRA8UnormSrgb
            GPUTextureFormatInterop.RGB10A2Uint -> RGB10A2Uint
            GPUTextureFormatInterop.RGB10A2Unorm -> RGB10A2Unorm
            GPUTextureFormatInterop.RG11B10Ufloat -> RG11B10Ufloat
            GPUTextureFormatInterop.RGB9E5Ufloat -> RGB9E5Ufloat
            GPUTextureFormatInterop.RG32Float -> RG32Float
            GPUTextureFormatInterop.RG32Uint -> RG32Uint
            GPUTextureFormatInterop.RG32Sint -> RG32Sint
            GPUTextureFormatInterop.RGBA16Uint -> RGBA16Uint
            GPUTextureFormatInterop.RGBA16Sint -> RGBA16Sint
            GPUTextureFormatInterop.RGBA16Float -> RGBA16Float
            GPUTextureFormatInterop.RGBA32Float -> RGBA32Float
            GPUTextureFormatInterop.RGBA32Uint -> RGBA32Uint
            GPUTextureFormatInterop.RGBA32Sint -> RGBA32Sint
            GPUTextureFormatInterop.Stencil8 -> Stencil8
            GPUTextureFormatInterop.Depth16Unorm -> Depth16Unorm
            GPUTextureFormatInterop.Depth24Plus -> Depth24Plus
            GPUTextureFormatInterop.Depth24PlusStencil8 -> Depth24PlusStencil8
            GPUTextureFormatInterop.Depth32Float -> Depth32Float
            GPUTextureFormatInterop.Depth32FloatStencil8 -> Depth32FloatStencil8
            GPUTextureFormatInterop.BC1RGBAUnorm -> BC1RGBAUnorm
            GPUTextureFormatInterop.BC1RGBAUnormSrgb -> BC1RGBAUnormSrgb
            GPUTextureFormatInterop.BC2RGBAUnorm -> BC2RGBAUnorm
            GPUTextureFormatInterop.BC2RGBAUnormSrgb -> BC2RGBAUnormSrgb
            GPUTextureFormatInterop.BC3RGBAUnorm -> BC3RGBAUnorm
            GPUTextureFormatInterop.BC3RGBAUnormSrgb -> BC3RGBAUnormSrgb
            GPUTextureFormatInterop.BC4RUnorm -> BC4RUnorm
            GPUTextureFormatInterop.BC4RSnorm -> BC4RSnorm
            GPUTextureFormatInterop.BC5RGUnorm -> BC5RGUnorm
            GPUTextureFormatInterop.BC5RGSnorm -> BC5RGSnorm
            GPUTextureFormatInterop.BC6HRGBUfloat -> BC6HRGBUfloat
            GPUTextureFormatInterop.BC6HRGBFloat -> BC6HRGBFloat
            GPUTextureFormatInterop.BC7RGBAUnorm -> BC7RGBAUnorm
            GPUTextureFormatInterop.BC7RGBAUnormSrgb -> BC7RGBAUnormSrgb
            GPUTextureFormatInterop.ETC2RGB8Unorm -> ETC2RGB8Unorm
            GPUTextureFormatInterop.ETC2RGB8UnormSrgb -> ETC2RGB8UnormSrgb
            GPUTextureFormatInterop.ETC2RGB8A1Unorm -> ETC2RGB8A1Unorm
            GPUTextureFormatInterop.ETC2RGB8A1UnormSrgb -> ETC2RGB8A1UnormSrgb
            GPUTextureFormatInterop.ETC2RGBA8Unorm -> ETC2RGBA8Unorm
            GPUTextureFormatInterop.ETC2RGBA8UnormSrgb -> ETC2RGBA8UnormSrgb
            GPUTextureFormatInterop.EACR11Unorm -> EACR11Unorm
            GPUTextureFormatInterop.EACR11Snorm -> EACR11Snorm
            GPUTextureFormatInterop.EACRG11Unorm -> EACRG11Unorm
            GPUTextureFormatInterop.EACRG11Snorm -> EACRG11Snorm
            GPUTextureFormatInterop.ASTC4x4Unorm -> ASTC4x4Unorm
            GPUTextureFormatInterop.ASTC4x4UnormSrgb -> ASTC4x4UnormSrgb
            GPUTextureFormatInterop.ASTC5x4Unorm -> ASTC5x4Unorm
            GPUTextureFormatInterop.ASTC5x4UnormSrgb -> ASTC5x4UnormSrgb
            GPUTextureFormatInterop.ASTC5x5Unorm -> ASTC5x5Unorm
            GPUTextureFormatInterop.ASTC5x5UnormSrgb -> ASTC5x5UnormSrgb
            GPUTextureFormatInterop.ASTC6x5Unorm -> ASTC6x5Unorm
            GPUTextureFormatInterop.ASTC6x5UnormSrgb -> ASTC6x5UnormSrgb
            GPUTextureFormatInterop.ASTC6x6Unorm -> ASTC6x6Unorm
            GPUTextureFormatInterop.ASTC6x6UnormSrgb -> ASTC6x6UnormSrgb
            GPUTextureFormatInterop.ASTC8x5Unorm -> ASTC8x5Unorm
            GPUTextureFormatInterop.ASTC8x5UnormSrgb -> ASTC8x5UnormSrgb
            GPUTextureFormatInterop.ASTC8x6Unorm -> ASTC8x6Unorm
            GPUTextureFormatInterop.ASTC8x6UnormSrgb -> ASTC8x6UnormSrgb
            GPUTextureFormatInterop.ASTC8x8Unorm -> ASTC8x8Unorm
            GPUTextureFormatInterop.ASTC8x8UnormSrgb -> ASTC8x8UnormSrgb
            GPUTextureFormatInterop.ASTC10x5Unorm -> ASTC10x5Unorm
            GPUTextureFormatInterop.ASTC10x5UnormSrgb -> ASTC10x5UnormSrgb
            GPUTextureFormatInterop.ASTC10x6Unorm -> ASTC10x6Unorm
            GPUTextureFormatInterop.ASTC10x6UnormSrgb -> ASTC10x6UnormSrgb
            GPUTextureFormatInterop.ASTC10x8Unorm -> ASTC10x8Unorm
            GPUTextureFormatInterop.ASTC10x8UnormSrgb -> ASTC10x8UnormSrgb
            GPUTextureFormatInterop.ASTC10x10Unorm -> ASTC10x10Unorm
            GPUTextureFormatInterop.ASTC10x10UnormSrgb -> ASTC10x10UnormSrgb
            GPUTextureFormatInterop.ASTC12x10Unorm -> ASTC12x10Unorm
            GPUTextureFormatInterop.ASTC12x10UnormSrgb -> ASTC12x10UnormSrgb
            GPUTextureFormatInterop.ASTC12x12Unorm -> ASTC12x12Unorm
            GPUTextureFormatInterop.ASTC12x12UnormSrgb -> ASTC12x12UnormSrgb
            else -> error("Invalid GPUTextureFormat: $v")
        }
    }
}
