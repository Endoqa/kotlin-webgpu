// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu

import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType
import kotlin.Int

/**
 * TODO
 */
public enum class WGPUCreatePipelineAsyncStatus(
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
     * TODO
     */
    ValidationError(0x00000003),

    /**
     * TODO
     */
    InternalError(0x00000004),
    ;

    public companion object {
        @JvmStatic
        public val fromInt: MethodHandle = MethodHandles.lookup().findStatic(
            WGPUCreatePipelineAsyncStatus::class.java,
            "fromInt",
            MethodType.methodType(WGPUCreatePipelineAsyncStatus::class.java, Int::class.java)
        )

        @JvmStatic
        public val toInt: MethodHandle = MethodHandles.lookup().findGetter(
            WGPUCreatePipelineAsyncStatus::class.java,
            "value",
            Int::class.java
        )

        @JvmStatic
        public fun fromInt(`value`: Int): WGPUCreatePipelineAsyncStatus = when (value) {
            Null.value -> Null
            Success.value -> Success
            InstanceDropped.value -> InstanceDropped
            ValidationError.value -> ValidationError
            InternalError.value -> InternalError
            else -> error("enum not found")
        }
    }
}
