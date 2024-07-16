// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c

import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType
import kotlin.Int

public enum class WGPUBufferMapAsyncStatus(
    public val `value`: Int,
) {
    Success(0x00000001),
    InstanceDropped(0x00000002),
    ValidationError(0x00000003),
    Unknown(0x00000004),
    DeviceLost(0x00000005),
    DestroyedBeforeCallback(0x00000006),
    UnmappedBeforeCallback(0x00000007),
    MappingAlreadyPending(0x00000008),
    OffsetOutOfRange(0x00000009),
    SizeOutOfRange(0x0000000A),
    ;

    public companion object {
        @JvmStatic
        public val fromInt: MethodHandle = MethodHandles.lookup().findStatic(
            WGPUBufferMapAsyncStatus::class.java,
            "fromInt",
            MethodType.methodType(WGPUBufferMapAsyncStatus::class.java, Int::class.java)
        )

        @JvmStatic
        public val toInt: MethodHandle = MethodHandles.lookup().findGetter(
            WGPUBufferMapAsyncStatus::class.java,
            "value",
            Int::class.java
        )

        @JvmStatic
        public fun fromInt(`value`: Int): WGPUBufferMapAsyncStatus = when (value) {
            Success.value -> Success
            InstanceDropped.value -> InstanceDropped
            ValidationError.value -> ValidationError
            Unknown.value -> Unknown
            DeviceLost.value -> DeviceLost
            DestroyedBeforeCallback.value -> DestroyedBeforeCallback
            UnmappedBeforeCallback.value -> UnmappedBeforeCallback
            MappingAlreadyPending.value -> MappingAlreadyPending
            OffsetOutOfRange.value -> OffsetOutOfRange
            SizeOutOfRange.value -> SizeOutOfRange
            else -> error("enum not found")
        }
    }
}