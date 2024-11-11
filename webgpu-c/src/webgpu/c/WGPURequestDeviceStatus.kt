// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c

import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType
import kotlin.Int
import kotlin.jvm.JvmStatic
import webgpu.c.WGPURequestDeviceStatus.Error
import webgpu.c.WGPURequestDeviceStatus.InstanceDropped
import webgpu.c.WGPURequestDeviceStatus.Success
import webgpu.c.WGPURequestDeviceStatus.Unknown

public enum class WGPURequestDeviceStatus(
    public val `value`: Int,
) {
    Success(0x00000001),
    InstanceDropped(0x00000002),
    Error(0x00000003),
    Unknown(0x00000004),
    ;

    public companion object {
        @JvmStatic
        public val fromInt: MethodHandle = MethodHandles.lookup().findStatic(
            WGPURequestDeviceStatus::class.java,
            "fromInt",
            MethodType.methodType(WGPURequestDeviceStatus::class.java, Int::class.java)
        )

        @JvmStatic
        public val toInt: MethodHandle = MethodHandles.lookup().findGetter(
            WGPURequestDeviceStatus::class.java,
            "value",
            Int::class.java
        )

        @JvmStatic
        public fun fromInt(`value`: Int): WGPURequestDeviceStatus = when (value) {
            Success.value -> Success
            InstanceDropped.value -> InstanceDropped
            Error.value -> Error
            Unknown.value -> Unknown
            else -> error("enum not found")
        }
    }
}
