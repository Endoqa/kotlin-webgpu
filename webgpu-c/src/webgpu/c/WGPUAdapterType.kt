// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c

import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType
import kotlin.Int
import kotlin.jvm.JvmStatic
import webgpu.c.WGPUAdapterType.CPU
import webgpu.c.WGPUAdapterType.DiscreteGPU
import webgpu.c.WGPUAdapterType.IntegratedGPU
import webgpu.c.WGPUAdapterType.Unknown

public enum class WGPUAdapterType(
    public val `value`: Int,
) {
    DiscreteGPU(0x00000001),
    IntegratedGPU(0x00000002),
    CPU(0x00000003),
    Unknown(0x00000004),
    ;

    public companion object {
        @JvmStatic
        public val fromInt: MethodHandle = MethodHandles.lookup().findStatic(
            WGPUAdapterType::class.java,
            "fromInt",
            MethodType.methodType(WGPUAdapterType::class.java, Int::class.java)
        )

        @JvmStatic
        public val toInt: MethodHandle = MethodHandles.lookup().findGetter(
            WGPUAdapterType::class.java,
            "value",
            Int::class.java
        )

        @JvmStatic
        public fun fromInt(`value`: Int): WGPUAdapterType = when (value) {
            DiscreteGPU.value -> DiscreteGPU
            IntegratedGPU.value -> IntegratedGPU
            CPU.value -> CPU
            Unknown.value -> Unknown
            else -> error("enum not found")
        }
    }
}
