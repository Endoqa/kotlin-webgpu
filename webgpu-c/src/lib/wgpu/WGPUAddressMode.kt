// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu

import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType
import kotlin.Int

/**
 * TODO
 */
public enum class WGPUAddressMode(
    public val `value`: Int,
) {
    /**
     * Indicates no value is passed for this argument. See @ref SentinelValues.
     */
    Undefined(0x00000000),

    /**
     * TODO
     */
    ClampToEdge(0x00000001),

    /**
     * TODO
     */
    Repeat(0x00000002),

    /**
     * TODO
     */
    MirrorRepeat(0x00000003),
    ;

    public companion object {
        @JvmStatic
        public val fromInt: MethodHandle = MethodHandles.lookup().findStatic(
            WGPUAddressMode::class.java,
            "fromInt",
            MethodType.methodType(WGPUAddressMode::class.java, Int::class.java)
        )

        @JvmStatic
        public val toInt: MethodHandle = MethodHandles.lookup().findGetter(
            WGPUAddressMode::class.java,
            "value",
            Int::class.java
        )

        @JvmStatic
        public fun fromInt(`value`: Int): WGPUAddressMode = when (value) {
            Undefined.value -> Undefined
            ClampToEdge.value -> ClampToEdge
            Repeat.value -> Repeat
            MirrorRepeat.value -> MirrorRepeat
            else -> error("enum not found")
        }
    }
}
