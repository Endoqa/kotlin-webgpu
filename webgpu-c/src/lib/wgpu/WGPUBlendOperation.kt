// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu

import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType

/**
 * TODO
 */
public enum class WGPUBlendOperation(
    public val `value`: Int,
) {
    /**
     * Indicates no value is passed for this argument. See [SentinelValues](https://webgpu-native.github.io/webgpu-headers/SentinelValues.html).
     */
    Undefined(0x00000000),

    /**
     * TODO
     */
    Add(0x00000001),

    /**
     * TODO
     */
    Subtract(0x00000002),

    /**
     * TODO
     */
    ReverseSubtract(0x00000003),

    /**
     * TODO
     */
    Min(0x00000004),

    /**
     * TODO
     */
    Max(0x00000005),
    ;

    public companion object {
        @JvmStatic
        public val fromInt: MethodHandle = MethodHandles.lookup().findStatic(
            WGPUBlendOperation::class.java,
            "fromInt",
            MethodType.methodType(WGPUBlendOperation::class.java, Int::class.java)
        )

        @JvmStatic
        public val toInt: MethodHandle = MethodHandles.lookup().findGetter(
            WGPUBlendOperation::class.java,
            "value",
            Int::class.java
        )

        @JvmStatic
        public fun fromInt(`value`: Int): WGPUBlendOperation = when (value) {
            Undefined.value -> Undefined
            Add.value -> Add
            Subtract.value -> Subtract
            ReverseSubtract.value -> ReverseSubtract
            Min.value -> Min
            Max.value -> Max
            else -> error("enum not found")
        }
    }
}
