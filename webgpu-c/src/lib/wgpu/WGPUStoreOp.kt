// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu

import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType
import kotlin.Int

public enum class WGPUStoreOp(
    public val `value`: Int,
) {
    Undefined(0x00000000),
    Store(0x00000001),
    Discard(0x00000002),
    ;

    public companion object {
        @JvmStatic
        public val fromInt: MethodHandle = MethodHandles.lookup().findStatic(
            WGPUStoreOp::class.java,
            "fromInt",
            MethodType.methodType(WGPUStoreOp::class.java, Int::class.java)
        )

        @JvmStatic
        public val toInt: MethodHandle = MethodHandles.lookup().findGetter(
            WGPUStoreOp::class.java,
            "value",
            Int::class.java
        )

        @JvmStatic
        public fun fromInt(`value`: Int): WGPUStoreOp = when (value) {
            Undefined.value -> Undefined
            Store.value -> Store
            Discard.value -> Discard
            else -> error("enum not found")
        }
    }
}