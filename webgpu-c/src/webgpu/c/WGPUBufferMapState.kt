// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c

import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType
import kotlin.Int
import kotlin.jvm.JvmStatic
import webgpu.c.WGPUBufferMapState.Mapped
import webgpu.c.WGPUBufferMapState.Pending
import webgpu.c.WGPUBufferMapState.Unmapped

public enum class WGPUBufferMapState(
    public val `value`: Int,
) {
    Unmapped(0x00000001),
    Pending(0x00000002),
    Mapped(0x00000003),
    ;

    public companion object {
        @JvmStatic
        public val fromInt: MethodHandle = MethodHandles.lookup().findStatic(
            WGPUBufferMapState::class.java,
            "fromInt",
            MethodType.methodType(WGPUBufferMapState::class.java, Int::class.java)
        )

        @JvmStatic
        public val toInt: MethodHandle = MethodHandles.lookup().findGetter(
            WGPUBufferMapState::class.java,
            "value",
            Int::class.java
        )

        @JvmStatic
        public fun fromInt(`value`: Int): WGPUBufferMapState = when (value) {
            Unmapped.value -> Unmapped
            Pending.value -> Pending
            Mapped.value -> Mapped
            else -> error("enum not found")
        }
    }
}
