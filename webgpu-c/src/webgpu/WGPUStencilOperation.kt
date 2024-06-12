// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu

import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType
import kotlin.Int

public enum class WGPUStencilOperation(
    public val `value`: Int,
) {
    Undefined(0x00000000),
    Keep(0x00000001),
    Zero(0x00000002),
    Replace(0x00000003),
    Invert(0x00000004),
    IncrementClamp(0x00000005),
    DecrementClamp(0x00000006),
    IncrementWrap(0x00000007),
    DecrementWrap(0x00000008),
    Force32(0x7fffffff),
    ;

    public companion object {
        @JvmStatic
        public val fromInt: MethodHandle = MethodHandles.lookup().findStatic(
            WGPUStencilOperation::class.java,
            "fromInt",
            MethodType.methodType(WGPUStencilOperation::class.java, Int::class.java)
        )

        @JvmStatic
        public val toInt: MethodHandle = MethodHandles.lookup().findGetter(
            WGPUStencilOperation::class.java,
            "value",
            Int::class.java
        )

        @JvmStatic
        public fun fromInt(`value`: Int): WGPUStencilOperation = when (value) {
            0x00000000 -> Undefined
            0x00000001 -> Keep
            0x00000002 -> Zero
            0x00000003 -> Replace
            0x00000004 -> Invert
            0x00000005 -> IncrementClamp
            0x00000006 -> DecrementClamp
            0x00000007 -> IncrementWrap
            0x00000008 -> DecrementWrap
            0x7fffffff -> Force32
            else -> error("enum not found")
        }
    }
}