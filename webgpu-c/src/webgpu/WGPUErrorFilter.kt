// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu

import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType
import kotlin.Int

public enum class WGPUErrorFilter(
    public val `value`: Int,
) {
    Validation(0x00000001),
    OutOfMemory(0x00000002),
    Internal(0x00000003),
    Force32(0x7fffffff),
    ;

    public companion object {
        @JvmStatic
        public val fromInt: MethodHandle = MethodHandles.lookup().findStatic(
            WGPUErrorFilter::class.java,
            "fromInt",
            MethodType.methodType(WGPUErrorFilter::class.java, Int::class.java)
        )

        @JvmStatic
        public val toInt: MethodHandle = MethodHandles.lookup().findGetter(
            WGPUErrorFilter::class.java,
            "value",
            Int::class.java
        )

        @JvmStatic
        public fun fromInt(`value`: Int): WGPUErrorFilter = when (value) {
            0x00000001 -> Validation
            0x00000002 -> OutOfMemory
            0x00000003 -> Internal
            0x7fffffff -> Force32
            else -> error("enum not found")
        }
    }
}