// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c

import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType
import kotlin.Int

public enum class WGPUSurfaceGetCurrentTextureStatus(
    public val `value`: Int,
) {
    Success(0x00000001),
    Timeout(0x00000002),
    Outdated(0x00000003),
    Lost(0x00000004),
    OutOfMemory(0x00000005),
    DeviceLost(0x00000006),
    Error(0x00000007),
    ;

    public companion object {
        @JvmStatic
        public val fromInt: MethodHandle = MethodHandles.lookup().findStatic(
            WGPUSurfaceGetCurrentTextureStatus::class.java,
            "fromInt",
            MethodType.methodType(WGPUSurfaceGetCurrentTextureStatus::class.java, Int::class.java)
        )

        @JvmStatic
        public val toInt: MethodHandle = MethodHandles.lookup().findGetter(
            WGPUSurfaceGetCurrentTextureStatus::class.java,
            "value",
            Int::class.java
        )

        @JvmStatic
        public fun fromInt(`value`: Int): WGPUSurfaceGetCurrentTextureStatus = when (value) {
            Success.value -> Success
            Timeout.value -> Timeout
            Outdated.value -> Outdated
            Lost.value -> Lost
            OutOfMemory.value -> OutOfMemory
            DeviceLost.value -> DeviceLost
            Error.value -> Error
            else -> error("enum not found")
        }
    }
}