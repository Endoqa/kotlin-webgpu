// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu

import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType
import kotlin.Int

public enum class WGPUAlphaMode(
    public val `value`: Int,
) {
    Opaque(0x00000001),
    Premultiplied(0x00000002),
    Unpremultiplied(0x00000003),
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
            Opaque.value -> Opaque
            Premultiplied.value -> Premultiplied
            Unpremultiplied.value -> Unpremultiplied
            else -> error("enum not found")
        }
    }
}
