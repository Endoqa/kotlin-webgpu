// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c

import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType
import kotlin.Int

public enum class WGPUErrorType(
    public val `value`: Int,
) {
    NoError(0x00000001),
    Validation(0x00000002),
    OutOfMemory(0x00000003),
    Internal(0x00000004),
    Unknown(0x00000005),
    DeviceLost(0x00000006),
    ;

    public companion object {
        @JvmStatic
        public val fromInt: MethodHandle = MethodHandles.lookup().findStatic(
            WGPUErrorType::class.java,
            "fromInt",
            MethodType.methodType(WGPUErrorType::class.java, Int::class.java)
        )

        @JvmStatic
        public val toInt: MethodHandle = MethodHandles.lookup().findGetter(
            WGPUErrorType::class.java,
            "value",
            Int::class.java
        )

        @JvmStatic
        public fun fromInt(`value`: Int): WGPUErrorType = when (value) {
            NoError.value -> NoError
            Validation.value -> Validation
            OutOfMemory.value -> OutOfMemory
            Internal.value -> Internal
            Unknown.value -> Unknown
            DeviceLost.value -> DeviceLost
            else -> error("enum not found")
        }
    }
}
