// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu

import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType
import kotlin.Int

/**
 * TODO
 */
public enum class WGPUCompareFunction(
    public val `value`: Int,
) {
    /**
     * Indicates no value is passed for this argument. See @ref SentinelValues.
     */
    Undefined(0x00000000),

    /**
     * TODO
     */
    Never(0x00000001),

    /**
     * TODO
     */
    Less(0x00000002),

    /**
     * TODO
     */
    Equal(0x00000003),

    /**
     * TODO
     */
    LessEqual(0x00000004),

    /**
     * TODO
     */
    Greater(0x00000005),

    /**
     * TODO
     */
    NotEqual(0x00000006),

    /**
     * TODO
     */
    GreaterEqual(0x00000007),

    /**
     * TODO
     */
    Always(0x00000008),
    ;

    public companion object {
        @JvmStatic
        public val fromInt: MethodHandle = MethodHandles.lookup().findStatic(
            WGPUCompareFunction::class.java,
            "fromInt",
            MethodType.methodType(WGPUCompareFunction::class.java, Int::class.java)
        )

        @JvmStatic
        public val toInt: MethodHandle = MethodHandles.lookup().findGetter(
            WGPUCompareFunction::class.java,
            "value",
            Int::class.java
        )

        @JvmStatic
        public fun fromInt(`value`: Int): WGPUCompareFunction = when (value) {
            Undefined.value -> Undefined
            Never.value -> Never
            Less.value -> Less
            Equal.value -> Equal
            LessEqual.value -> LessEqual
            Greater.value -> Greater
            NotEqual.value -> NotEqual
            GreaterEqual.value -> GreaterEqual
            Always.value -> Always
            else -> error("enum not found")
        }
    }
}
