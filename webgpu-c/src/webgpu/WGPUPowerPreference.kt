// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu

import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType
import kotlin.Int

public enum class WGPUPowerPreference(
    public val `value`: Int,
) {
    Undefined(0x00000000),
    LowPower(0x00000001),
    HighPerformance(0x00000002),
    Force32(0x7fffffff),
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
            0x00000000 -> Undefined
            0x00000001 -> LowPower
            0x00000002 -> HighPerformance
            0x7fffffff -> Force32
            else -> error("enum not found")
        }
    }
}
