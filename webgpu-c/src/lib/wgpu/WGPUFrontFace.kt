// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu

import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType
import kotlin.Int

/**
 * TODO
 */
public enum class WGPUFrontFace(
    public val `value`: Int,
) {
    /**
     * Indicates no value is passed for this argument. See [SentinelValues](https://webgpu-native.github.io/webgpu-headers/articles.html).
     */
    Undefined(0x00000000),

    /**
     * TODO
     */
    CCW(0x00000001),

    /**
     * TODO
     */
    CW(0x00000002),
    ;

    public companion object {
        @JvmStatic
        public val fromInt: MethodHandle = MethodHandles.lookup().findStatic(
            WGPUFrontFace::class.java,
            "fromInt",
            MethodType.methodType(WGPUFrontFace::class.java, Int::class.java)
        )

        @JvmStatic
        public val toInt: MethodHandle = MethodHandles.lookup().findGetter(
            WGPUFrontFace::class.java,
            "value",
            Int::class.java
        )

        @JvmStatic
        public fun fromInt(`value`: Int): WGPUFrontFace = when (value) {
            Undefined.value -> Undefined
            CCW.value -> CCW
            CW.value -> CW
            else -> error("enum not found")
        }
    }
}
