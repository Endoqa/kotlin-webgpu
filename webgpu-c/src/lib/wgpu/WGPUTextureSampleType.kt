// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu

import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType
import kotlin.Int

/**
 * TODO
 */
public enum class WGPUTextureSampleType(
    public val `value`: Int,
) {
    /**
     * Indicates that this [WGPUTextureBindingLayout] member of
     * its parent [WGPUBindGroupLayoutEntry] is not used.
     * (See also [SentinelValues](https://webgpu-native.github.io/webgpu-headers/SentinelValues.html).)
     */
    BindingNotUsed(0x00000000),

    /**
     * [1]. Indicates no value is passed for this argument. See [SentinelValues](https://webgpu-native.github.io/webgpu-headers/SentinelValues.html).
     */
    Undefined(0x00000001),

    /**
     * TODO
     */
    Float(0x00000002),

    /**
     * TODO
     */
    UnfilterableFloat(0x00000003),

    /**
     * TODO
     */
    Depth(0x00000004),

    /**
     * TODO
     */
    Sint(0x00000005),

    /**
     * TODO
     */
    Uint(0x00000006),
    ;

    public companion object {
        @JvmStatic
        public val fromInt: MethodHandle = MethodHandles.lookup().findStatic(
            WGPUTextureSampleType::class.java,
            "fromInt",
            MethodType.methodType(WGPUTextureSampleType::class.java, Int::class.java)
        )

        @JvmStatic
        public val toInt: MethodHandle = MethodHandles.lookup().findGetter(
            WGPUTextureSampleType::class.java,
            "value",
            Int::class.java
        )

        @JvmStatic
        public fun fromInt(`value`: Int): WGPUTextureSampleType = when (value) {
            BindingNotUsed.value -> BindingNotUsed
            Undefined.value -> Undefined
            Float.value -> Float
            UnfilterableFloat.value -> UnfilterableFloat
            Depth.value -> Depth
            Sint.value -> Sint
            Uint.value -> Uint
            else -> error("enum not found")
        }
    }
}
