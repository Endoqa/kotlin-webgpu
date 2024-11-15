// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c

import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType
import kotlin.Int
import kotlin.jvm.JvmStatic
import webgpu.c.WGPUStorageTextureAccess.BindingNotUsed
import webgpu.c.WGPUStorageTextureAccess.ReadOnly
import webgpu.c.WGPUStorageTextureAccess.ReadWrite
import webgpu.c.WGPUStorageTextureAccess.Undefined
import webgpu.c.WGPUStorageTextureAccess.WriteOnly

public enum class WGPUStorageTextureAccess(
    public val `value`: Int,
) {
    BindingNotUsed(0x00000000),
    Undefined(0x00000001),
    WriteOnly(0x00000002),
    ReadOnly(0x00000003),
    ReadWrite(0x00000004),
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
            BindingNotUsed.value -> BindingNotUsed
            Undefined.value -> Undefined
            WriteOnly.value -> WriteOnly
            ReadOnly.value -> ReadOnly
            ReadWrite.value -> ReadWrite
            else -> error("enum not found")
        }
    }
}
