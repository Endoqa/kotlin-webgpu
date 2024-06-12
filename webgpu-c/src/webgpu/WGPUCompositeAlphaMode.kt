// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu

import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType
import kotlin.Int

public enum class WGPUCompositeAlphaMode(
    public val `value`: Int,
) {
    Auto(0x00000000),
    Opaque(0x00000001),
    Premultiplied(0x00000002),
    Unpremultiplied(0x00000003),
    Inherit(0x00000004),
    Force32(0x7fffffff),
    ;

    public companion object {
        @JvmStatic
        public val fromInt: MethodHandle = MethodHandles.lookup().findStatic(
            WGPUCompositeAlphaMode::class.java,
            "fromInt",
            MethodType.methodType(WGPUCompositeAlphaMode::class.java, Int::class.java)
        )

        @JvmStatic
        public val toInt: MethodHandle = MethodHandles.lookup().findGetter(
            WGPUCompositeAlphaMode::class.java,
            "value",
            Int::class.java
        )

        @JvmStatic
        public fun fromInt(`value`: Int): WGPUCompositeAlphaMode = when (value) {
            0x00000000 -> Auto
            0x00000001 -> Opaque
            0x00000002 -> Premultiplied
            0x00000003 -> Unpremultiplied
            0x00000004 -> Inherit
            0x7fffffff -> Force32
            else -> error("enum not found")
        }
    }
}