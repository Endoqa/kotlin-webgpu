// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu

import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType
import kotlin.Int

/**
 * TODO
 */
public enum class WGPUTextureFormat(
    public val `value`: Int,
) {
    /**
     * Indicates no value is passed for this argument. See [SentinelValues](https://webgpu-native.github.io/webgpu-headers/articles.html).
     */
    Undefined(0x00000000),

    /**
     * TODO
     */
    R8Unorm(0x00000001),

    /**
     * TODO
     */
    R8Snorm(0x00000002),

    /**
     * TODO
     */
    R8Uint(0x00000003),

    /**
     * TODO
     */
    R8Sint(0x00000004),

    /**
     * TODO
     */
    R16Uint(0x00000005),

    /**
     * TODO
     */
    R16Sint(0x00000006),

    /**
     * TODO
     */
    R16Float(0x00000007),

    /**
     * TODO
     */
    RG8Unorm(0x00000008),

    /**
     * TODO
     */
    RG8Snorm(0x00000009),

    /**
     * TODO
     */
    RG8Uint(0x0000000a),

    /**
     * TODO
     */
    RG8Sint(0x0000000b),

    /**
     * TODO
     */
    R32Float(0x0000000c),

    /**
     * TODO
     */
    R32Uint(0x0000000d),

    /**
     * TODO
     */
    R32Sint(0x0000000e),

    /**
     * TODO
     */
    RG16Uint(0x0000000f),

    /**
     * TODO
     */
    RG16Sint(0x00000010),

    /**
     * TODO
     */
    RG16Float(0x00000011),

    /**
     * TODO
     */
    RGBA8Unorm(0x00000012),

    /**
     * TODO
     */
    RGBA8UnormSrgb(0x00000013),

    /**
     * TODO
     */
    RGBA8Snorm(0x00000014),

    /**
     * TODO
     */
    RGBA8Uint(0x00000015),

    /**
     * TODO
     */
    RGBA8Sint(0x00000016),

    /**
     * TODO
     */
    BGRA8Unorm(0x00000017),

    /**
     * TODO
     */
    BGRA8UnormSrgb(0x00000018),

    /**
     * TODO
     */
    RGB10A2Uint(0x00000019),

    /**
     * TODO
     */
    RGB10A2Unorm(0x0000001a),

    /**
     * TODO
     */
    RG11B10Ufloat(0x0000001b),

    /**
     * TODO
     */
    RGB9E5Ufloat(0x0000001c),

    /**
     * TODO
     */
    RG32Float(0x0000001d),

    /**
     * TODO
     */
    RG32Uint(0x0000001e),

    /**
     * TODO
     */
    RG32Sint(0x0000001f),

    /**
     * TODO
     */
    RGBA16Uint(0x00000020),

    /**
     * TODO
     */
    RGBA16Sint(0x00000021),

    /**
     * TODO
     */
    RGBA16Float(0x00000022),

    /**
     * TODO
     */
    RGBA32Float(0x00000023),

    /**
     * TODO
     */
    RGBA32Uint(0x00000024),

    /**
     * TODO
     */
    RGBA32Sint(0x00000025),

    /**
     * TODO
     */
    Stencil8(0x00000026),

    /**
     * TODO
     */
    Depth16Unorm(0x00000027),

    /**
     * TODO
     */
    Depth24Plus(0x00000028),

    /**
     * TODO
     */
    Depth24PlusStencil8(0x00000029),

    /**
     * TODO
     */
    Depth32Float(0x0000002a),

    /**
     * TODO
     */
    Depth32FloatStencil8(0x0000002b),

    /**
     * TODO
     */
    BC1RGBAUnorm(0x0000002c),

    /**
     * TODO
     */
    BC1RGBAUnormSrgb(0x0000002d),

    /**
     * TODO
     */
    BC2RGBAUnorm(0x0000002e),

    /**
     * TODO
     */
    BC2RGBAUnormSrgb(0x0000002f),

    /**
     * TODO
     */
    BC3RGBAUnorm(0x00000030),

    /**
     * TODO
     */
    BC3RGBAUnormSrgb(0x00000031),

    /**
     * TODO
     */
    BC4RUnorm(0x00000032),

    /**
     * TODO
     */
    BC4RSnorm(0x00000033),

    /**
     * TODO
     */
    BC5RGUnorm(0x00000034),

    /**
     * TODO
     */
    BC5RGSnorm(0x00000035),

    /**
     * TODO
     */
    BC6HRGBUfloat(0x00000036),

    /**
     * TODO
     */
    BC6HRGBFloat(0x00000037),

    /**
     * TODO
     */
    BC7RGBAUnorm(0x00000038),

    /**
     * TODO
     */
    BC7RGBAUnormSrgb(0x00000039),

    /**
     * TODO
     */
    ETC2RGB8Unorm(0x0000003a),

    /**
     * TODO
     */
    ETC2RGB8UnormSrgb(0x0000003b),

    /**
     * TODO
     */
    ETC2RGB8A1Unorm(0x0000003c),

    /**
     * TODO
     */
    ETC2RGB8A1UnormSrgb(0x0000003d),

    /**
     * TODO
     */
    ETC2RGBA8Unorm(0x0000003e),

    /**
     * TODO
     */
    ETC2RGBA8UnormSrgb(0x0000003f),

    /**
     * TODO
     */
    EACR11Unorm(0x00000040),

    /**
     * TODO
     */
    EACR11Snorm(0x00000041),

    /**
     * TODO
     */
    EACRG11Unorm(0x00000042),

    /**
     * TODO
     */
    EACRG11Snorm(0x00000043),

    /**
     * TODO
     */
    ASTC4x4Unorm(0x00000044),

    /**
     * TODO
     */
    ASTC4x4UnormSrgb(0x00000045),

    /**
     * TODO
     */
    ASTC5x4Unorm(0x00000046),

    /**
     * TODO
     */
    ASTC5x4UnormSrgb(0x00000047),

    /**
     * TODO
     */
    ASTC5x5Unorm(0x00000048),

    /**
     * TODO
     */
    ASTC5x5UnormSrgb(0x00000049),

    /**
     * TODO
     */
    ASTC6x5Unorm(0x0000004a),

    /**
     * TODO
     */
    ASTC6x5UnormSrgb(0x0000004b),

    /**
     * TODO
     */
    ASTC6x6Unorm(0x0000004c),

    /**
     * TODO
     */
    ASTC6x6UnormSrgb(0x0000004d),

    /**
     * TODO
     */
    ASTC8x5Unorm(0x0000004e),

    /**
     * TODO
     */
    ASTC8x5UnormSrgb(0x0000004f),

    /**
     * TODO
     */
    ASTC8x6Unorm(0x00000050),

    /**
     * TODO
     */
    ASTC8x6UnormSrgb(0x00000051),

    /**
     * TODO
     */
    ASTC8x8Unorm(0x00000052),

    /**
     * TODO
     */
    ASTC8x8UnormSrgb(0x00000053),

    /**
     * TODO
     */
    ASTC10x5Unorm(0x00000054),

    /**
     * TODO
     */
    ASTC10x5UnormSrgb(0x00000055),

    /**
     * TODO
     */
    ASTC10x6Unorm(0x00000056),

    /**
     * TODO
     */
    ASTC10x6UnormSrgb(0x00000057),

    /**
     * TODO
     */
    ASTC10x8Unorm(0x00000058),

    /**
     * TODO
     */
    ASTC10x8UnormSrgb(0x00000059),

    /**
     * TODO
     */
    ASTC10x10Unorm(0x0000005a),

    /**
     * TODO
     */
    ASTC10x10UnormSrgb(0x0000005b),

    /**
     * TODO
     */
    ASTC12x10Unorm(0x0000005c),

    /**
     * TODO
     */
    ASTC12x10UnormSrgb(0x0000005d),

    /**
     * TODO
     */
    ASTC12x12Unorm(0x0000005e),

    /**
     * TODO
     */
    ASTC12x12UnormSrgb(0x0000005f),
    ;

    public companion object {
        @JvmStatic
        public val fromInt: MethodHandle = MethodHandles.lookup().findStatic(
            WGPUTextureFormat::class.java,
            "fromInt",
            MethodType.methodType(WGPUTextureFormat::class.java, Int::class.java)
        )

        @JvmStatic
        public val toInt: MethodHandle = MethodHandles.lookup().findGetter(
            WGPUTextureFormat::class.java,
            "value",
            Int::class.java
        )

        @JvmStatic
        public fun fromInt(`value`: Int): WGPUTextureFormat = when (value) {
            Undefined.value -> Undefined
            R8Unorm.value -> R8Unorm
            R8Snorm.value -> R8Snorm
            R8Uint.value -> R8Uint
            R8Sint.value -> R8Sint
            R16Uint.value -> R16Uint
            R16Sint.value -> R16Sint
            R16Float.value -> R16Float
            RG8Unorm.value -> RG8Unorm
            RG8Snorm.value -> RG8Snorm
            RG8Uint.value -> RG8Uint
            RG8Sint.value -> RG8Sint
            R32Float.value -> R32Float
            R32Uint.value -> R32Uint
            R32Sint.value -> R32Sint
            RG16Uint.value -> RG16Uint
            RG16Sint.value -> RG16Sint
            RG16Float.value -> RG16Float
            RGBA8Unorm.value -> RGBA8Unorm
            RGBA8UnormSrgb.value -> RGBA8UnormSrgb
            RGBA8Snorm.value -> RGBA8Snorm
            RGBA8Uint.value -> RGBA8Uint
            RGBA8Sint.value -> RGBA8Sint
            BGRA8Unorm.value -> BGRA8Unorm
            BGRA8UnormSrgb.value -> BGRA8UnormSrgb
            RGB10A2Uint.value -> RGB10A2Uint
            RGB10A2Unorm.value -> RGB10A2Unorm
            RG11B10Ufloat.value -> RG11B10Ufloat
            RGB9E5Ufloat.value -> RGB9E5Ufloat
            RG32Float.value -> RG32Float
            RG32Uint.value -> RG32Uint
            RG32Sint.value -> RG32Sint
            RGBA16Uint.value -> RGBA16Uint
            RGBA16Sint.value -> RGBA16Sint
            RGBA16Float.value -> RGBA16Float
            RGBA32Float.value -> RGBA32Float
            RGBA32Uint.value -> RGBA32Uint
            RGBA32Sint.value -> RGBA32Sint
            Stencil8.value -> Stencil8
            Depth16Unorm.value -> Depth16Unorm
            Depth24Plus.value -> Depth24Plus
            Depth24PlusStencil8.value -> Depth24PlusStencil8
            Depth32Float.value -> Depth32Float
            Depth32FloatStencil8.value -> Depth32FloatStencil8
            BC1RGBAUnorm.value -> BC1RGBAUnorm
            BC1RGBAUnormSrgb.value -> BC1RGBAUnormSrgb
            BC2RGBAUnorm.value -> BC2RGBAUnorm
            BC2RGBAUnormSrgb.value -> BC2RGBAUnormSrgb
            BC3RGBAUnorm.value -> BC3RGBAUnorm
            BC3RGBAUnormSrgb.value -> BC3RGBAUnormSrgb
            BC4RUnorm.value -> BC4RUnorm
            BC4RSnorm.value -> BC4RSnorm
            BC5RGUnorm.value -> BC5RGUnorm
            BC5RGSnorm.value -> BC5RGSnorm
            BC6HRGBUfloat.value -> BC6HRGBUfloat
            BC6HRGBFloat.value -> BC6HRGBFloat
            BC7RGBAUnorm.value -> BC7RGBAUnorm
            BC7RGBAUnormSrgb.value -> BC7RGBAUnormSrgb
            ETC2RGB8Unorm.value -> ETC2RGB8Unorm
            ETC2RGB8UnormSrgb.value -> ETC2RGB8UnormSrgb
            ETC2RGB8A1Unorm.value -> ETC2RGB8A1Unorm
            ETC2RGB8A1UnormSrgb.value -> ETC2RGB8A1UnormSrgb
            ETC2RGBA8Unorm.value -> ETC2RGBA8Unorm
            ETC2RGBA8UnormSrgb.value -> ETC2RGBA8UnormSrgb
            EACR11Unorm.value -> EACR11Unorm
            EACR11Snorm.value -> EACR11Snorm
            EACRG11Unorm.value -> EACRG11Unorm
            EACRG11Snorm.value -> EACRG11Snorm
            ASTC4x4Unorm.value -> ASTC4x4Unorm
            ASTC4x4UnormSrgb.value -> ASTC4x4UnormSrgb
            ASTC5x4Unorm.value -> ASTC5x4Unorm
            ASTC5x4UnormSrgb.value -> ASTC5x4UnormSrgb
            ASTC5x5Unorm.value -> ASTC5x5Unorm
            ASTC5x5UnormSrgb.value -> ASTC5x5UnormSrgb
            ASTC6x5Unorm.value -> ASTC6x5Unorm
            ASTC6x5UnormSrgb.value -> ASTC6x5UnormSrgb
            ASTC6x6Unorm.value -> ASTC6x6Unorm
            ASTC6x6UnormSrgb.value -> ASTC6x6UnormSrgb
            ASTC8x5Unorm.value -> ASTC8x5Unorm
            ASTC8x5UnormSrgb.value -> ASTC8x5UnormSrgb
            ASTC8x6Unorm.value -> ASTC8x6Unorm
            ASTC8x6UnormSrgb.value -> ASTC8x6UnormSrgb
            ASTC8x8Unorm.value -> ASTC8x8Unorm
            ASTC8x8UnormSrgb.value -> ASTC8x8UnormSrgb
            ASTC10x5Unorm.value -> ASTC10x5Unorm
            ASTC10x5UnormSrgb.value -> ASTC10x5UnormSrgb
            ASTC10x6Unorm.value -> ASTC10x6Unorm
            ASTC10x6UnormSrgb.value -> ASTC10x6UnormSrgb
            ASTC10x8Unorm.value -> ASTC10x8Unorm
            ASTC10x8UnormSrgb.value -> ASTC10x8UnormSrgb
            ASTC10x10Unorm.value -> ASTC10x10Unorm
            ASTC10x10UnormSrgb.value -> ASTC10x10UnormSrgb
            ASTC12x10Unorm.value -> ASTC12x10Unorm
            ASTC12x10UnormSrgb.value -> ASTC12x10UnormSrgb
            ASTC12x12Unorm.value -> ASTC12x12Unorm
            ASTC12x12UnormSrgb.value -> ASTC12x12UnormSrgb
            else -> error("enum not found")
        }
    }
}
