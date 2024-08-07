// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c

import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType
import kotlin.Int

public enum class WGPUStorageTextureAccess(
    public val `value`: Int,
) {
    Undefined(0x00000000),
    WriteOnly(0x00000001),
    ReadOnly(0x00000002),
    ReadWrite(0x00000003),
    ;

    public companion object {
        @JvmStatic
        public val fromInt: MethodHandle = MethodHandles.lookup().findStatic(
            WGPUStorageTextureAccess::class.java,
            "fromInt",
            MethodType.methodType(WGPUStorageTextureAccess::class.java, Int::class.java)
        )

        @JvmStatic
        public val toInt: MethodHandle = MethodHandles.lookup().findGetter(
            WGPUStorageTextureAccess::class.java,
            "value",
            Int::class.java
        )

        @JvmStatic
        public fun fromInt(`value`: Int): WGPUStorageTextureAccess = when (value) {
            Undefined.value -> Undefined
            WriteOnly.value -> WriteOnly
            ReadOnly.value -> ReadOnly
            ReadWrite.value -> ReadWrite
            else -> error("enum not found")
        }
    }
}
