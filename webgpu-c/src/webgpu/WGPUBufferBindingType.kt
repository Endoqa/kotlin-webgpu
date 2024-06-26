// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu

import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType
import kotlin.Int

public enum class WGPUBufferBindingType(
    public val `value`: Int,
) {
    Undefined(0x00000000),
    Uniform(0x00000001),
    Storage(0x00000002),
    ReadOnlyStorage(0x00000003),
    Force32(0x7fffffff),
    ;

    public companion object {
        @JvmStatic
        public val fromInt: MethodHandle = MethodHandles.lookup().findStatic(
            WGPUBufferBindingType::class.java,
            "fromInt",
            MethodType.methodType(WGPUBufferBindingType::class.java, Int::class.java)
        )

        @JvmStatic
        public val toInt: MethodHandle = MethodHandles.lookup().findGetter(
            WGPUBufferBindingType::class.java,
            "value",
            Int::class.java
        )

        @JvmStatic
        public fun fromInt(`value`: Int): WGPUBufferBindingType = when (value) {
            0x00000000 -> Undefined
            0x00000001 -> Uniform
            0x00000002 -> Storage
            0x00000003 -> ReadOnlyStorage
            0x7fffffff -> Force32
            else -> error("enum not found")
        }
    }
}
