// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c

import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType
import kotlin.Int
import kotlin.jvm.JvmStatic
import webgpu.c.WGPUFrontFace.CCW
import webgpu.c.WGPUFrontFace.CW
import webgpu.c.WGPUFrontFace.Undefined

public enum class WGPUFrontFace(
    public val `value`: Int,
) {
    Undefined(0x00000000),
    CCW(0x00000001),
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
