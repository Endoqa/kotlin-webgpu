// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu

import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType
import kotlin.Int
import kotlin.jvm.JvmStatic
import webgpu.WGPUAlphaMode.Force32
import webgpu.WGPUAlphaMode.Opaque
import webgpu.WGPUAlphaMode.Premultiplied
import webgpu.WGPUAlphaMode.Unpremultiplied

public enum class WGPUAlphaMode(
    public val `value`: Int,
) {
    Opaque(0x00000001),
    Premultiplied(0x00000002),
    Unpremultiplied(0x00000003),
    Force32(0x7fffffff),
    ;

    public companion object {
        @JvmStatic
        public val fromInt: MethodHandle = MethodHandles.lookup().findStatic(
            WGPUAlphaMode::class.java,
            "fromInt",
            MethodType.methodType(WGPUAlphaMode::class.java, Int::class.java)
        )

        @JvmStatic
        public val toInt: MethodHandle = MethodHandles.lookup().findGetter(
            WGPUAlphaMode::class.java,
            "value",
            Int::class.java
        )

        @JvmStatic
        public fun fromInt(`value`: Int): WGPUAlphaMode = when (value) {
            0x00000001 -> Opaque
            0x00000002 -> Premultiplied
            0x00000003 -> Unpremultiplied
            0x7fffffff -> Force32
            else -> error("enum not found")
        }
    }
}
