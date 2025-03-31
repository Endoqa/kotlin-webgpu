// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu

import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType

/**
 * TODO
 */
public enum class WGPUBlendFactor(
    public val `value`: Int,
) {
    /**
     * Indicates no value is passed for this argument. See [SentinelValues](https://webgpu-native.github.io/webgpu-headers/SentinelValues.html).
     */
    Undefined(0x00000000),

    /**
     * TODO
     */
    Zero(0x00000001),

    /**
     * TODO
     */
    One(0x00000002),

    /**
     * TODO
     */
    Src(0x00000003),

    /**
     * TODO
     */
    OneMinusSrc(0x00000004),

    /**
     * TODO
     */
    SrcAlpha(0x00000005),

    /**
     * TODO
     */
    OneMinusSrcAlpha(0x00000006),

    /**
     * TODO
     */
    Dst(0x00000007),

    /**
     * TODO
     */
    OneMinusDst(0x00000008),

    /**
     * TODO
     */
    DstAlpha(0x00000009),

    /**
     * TODO
     */
    OneMinusDstAlpha(0x0000000a),

    /**
     * TODO
     */
    SrcAlphaSaturated(0x0000000b),

    /**
     * TODO
     */
    Constant(0x0000000c),

    /**
     * TODO
     */
    OneMinusConstant(0x0000000d),

    /**
     * TODO
     */
    Src1(0x0000000e),

    /**
     * TODO
     */
    OneMinusSrc1(0x0000000f),

    /**
     * TODO
     */
    Src1Alpha(0x00000010),

    /**
     * TODO
     */
    OneMinusSrc1Alpha(0x00000011),
    ;

    public companion object {
        @JvmStatic
        public val fromInt: MethodHandle = MethodHandles.lookup().findStatic(
            WGPUBlendFactor::class.java,
            "fromInt",
            MethodType.methodType(WGPUBlendFactor::class.java, Int::class.java)
        )

        @JvmStatic
        public val toInt: MethodHandle = MethodHandles.lookup().findGetter(
            WGPUBlendFactor::class.java,
            "value",
            Int::class.java
        )

        @JvmStatic
        public fun fromInt(`value`: Int): WGPUBlendFactor = when (value) {
            Undefined.value -> Undefined
            Zero.value -> Zero
            One.value -> One
            Src.value -> Src
            OneMinusSrc.value -> OneMinusSrc
            SrcAlpha.value -> SrcAlpha
            OneMinusSrcAlpha.value -> OneMinusSrcAlpha
            Dst.value -> Dst
            OneMinusDst.value -> OneMinusDst
            DstAlpha.value -> DstAlpha
            OneMinusDstAlpha.value -> OneMinusDstAlpha
            SrcAlphaSaturated.value -> SrcAlphaSaturated
            Constant.value -> Constant
            OneMinusConstant.value -> OneMinusConstant
            Src1.value -> Src1
            OneMinusSrc1.value -> OneMinusSrc1
            Src1Alpha.value -> Src1Alpha
            OneMinusSrc1Alpha.value -> OneMinusSrc1Alpha
            else -> error("enum not found")
        }
    }
}
