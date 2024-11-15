// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c

import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType
import kotlin.Int
import kotlin.jvm.JvmStatic
import webgpu.c.WGPUPowerPreference.HighPerformance
import webgpu.c.WGPUPowerPreference.LowPower
import webgpu.c.WGPUPowerPreference.Undefined

public enum class WGPUPowerPreference(
    public val `value`: Int,
) {
    Undefined(0x00000000),
    LowPower(0x00000001),
    HighPerformance(0x00000002),
    ;

    public companion object {
        @JvmStatic
        public val fromInt: MethodHandle = MethodHandles.lookup().findStatic(
            WGPUPowerPreference::class.java,
            "fromInt",
            MethodType.methodType(WGPUPowerPreference::class.java, Int::class.java)
        )

        @JvmStatic
        public val toInt: MethodHandle = MethodHandles.lookup().findGetter(
            WGPUPowerPreference::class.java,
            "value",
            Int::class.java
        )

        @JvmStatic
        public fun fromInt(`value`: Int): WGPUPowerPreference = when (value) {
            Undefined.value -> Undefined
            LowPower.value -> LowPower
            HighPerformance.value -> HighPerformance
            else -> error("enum not found")
        }
    }
}
