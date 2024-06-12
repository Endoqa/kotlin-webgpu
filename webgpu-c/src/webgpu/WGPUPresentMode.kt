// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu

import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType
import kotlin.Int

public enum class WGPUPresentMode(
    public val `value`: Int,
) {
    Fifo(0x00000000),
    FifoRelaxed(0x00000001),
    Immediate(0x00000002),
    Mailbox(0x00000003),
    Force32(0x7fffffff),
    ;

    public companion object {
        @JvmStatic
        public val fromInt: MethodHandle = MethodHandles.lookup().findStatic(
            WGPUPresentMode::class.java,
            "fromInt",
            MethodType.methodType(WGPUPresentMode::class.java, Int::class.java)
        )

        @JvmStatic
        public val toInt: MethodHandle = MethodHandles.lookup().findGetter(
            WGPUPresentMode::class.java,
            "value",
            Int::class.java
        )

        @JvmStatic
        public fun fromInt(`value`: Int): WGPUPresentMode = when (value) {
            0x00000000 -> Fifo
            0x00000001 -> FifoRelaxed
            0x00000002 -> Immediate
            0x00000003 -> Mailbox
            0x7fffffff -> Force32
            else -> error("enum not found")
        }
    }
}
