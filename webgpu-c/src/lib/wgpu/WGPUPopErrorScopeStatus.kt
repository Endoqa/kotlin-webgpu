// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu

import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType
import kotlin.Int

public enum class WGPUPopErrorScopeStatus(
    public val `value`: Int,
) {
    Success(0x00000001),
    InstanceDropped(0x00000002),
    Error(0x00000003),
    ;

    public companion object {
        @JvmStatic
        public val fromInt: MethodHandle = MethodHandles.lookup().findStatic(
            WGPUPopErrorScopeStatus::class.java,
            "fromInt",
            MethodType.methodType(WGPUPopErrorScopeStatus::class.java, Int::class.java)
        )

        @JvmStatic
        public val toInt: MethodHandle = MethodHandles.lookup().findGetter(
            WGPUPopErrorScopeStatus::class.java,
            "value",
            Int::class.java
        )

        @JvmStatic
        public fun fromInt(`value`: Int): WGPUPopErrorScopeStatus = when (value) {
            Success.value -> Success
            InstanceDropped.value -> InstanceDropped
            Error.value -> Error
            else -> error("enum not found")
        }
    }
}