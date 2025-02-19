// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu

import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType
import kotlin.Int

/**
 * TODO
 */
public enum class WGPUQueueWorkDoneStatus(
    public val `value`: Int,
) {
    Null(0x00000000),

    /**
     * TODO
     */
    Success(0x00000001),

    /**
     * TODO
     */
    InstanceDropped(0x00000002),

    /**
     * There was some deterministic error. (Note this is currently never used,
     * but it will be relevant when it's possible to create a queue object.)
     */
    Error(0x00000003),
    ;

    public companion object {
        @JvmStatic
        public val fromInt: MethodHandle = MethodHandles.lookup().findStatic(
            WGPUQueueWorkDoneStatus::class.java,
            "fromInt",
            MethodType.methodType(WGPUQueueWorkDoneStatus::class.java, Int::class.java)
        )

        @JvmStatic
        public val toInt: MethodHandle = MethodHandles.lookup().findGetter(
            WGPUQueueWorkDoneStatus::class.java,
            "value",
            Int::class.java
        )

        @JvmStatic
        public fun fromInt(`value`: Int): WGPUQueueWorkDoneStatus = when (value) {
            Null.value -> Null
            Success.value -> Success
            InstanceDropped.value -> InstanceDropped
            Error.value -> Error
            else -> error("enum not found")
        }
    }
}
