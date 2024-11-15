// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c

import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType
import kotlin.Int
import kotlin.jvm.JvmStatic
import webgpu.c.WGPUIndexFormat.Uint16
import webgpu.c.WGPUIndexFormat.Uint32
import webgpu.c.WGPUIndexFormat.Undefined

public enum class WGPUIndexFormat(
    public val `value`: Int,
) {
    Undefined(0x00000000),
    Uint16(0x00000001),
    Uint32(0x00000002),
    ;

    public companion object {
        @JvmStatic
        public val fromInt: MethodHandle = MethodHandles.lookup().findStatic(
            WGPUIndexFormat::class.java,
            "fromInt",
            MethodType.methodType(WGPUIndexFormat::class.java, Int::class.java)
        )

        @JvmStatic
        public val toInt: MethodHandle = MethodHandles.lookup().findGetter(
            WGPUIndexFormat::class.java,
            "value",
            Int::class.java
        )

        @JvmStatic
        public fun fromInt(`value`: Int): WGPUIndexFormat = when (value) {
            Undefined.value -> Undefined
            Uint16.value -> Uint16
            Uint32.value -> Uint32
            else -> error("enum not found")
        }
    }
}
