// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu

import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType
import kotlin.Int

/**
 * The status enum for [wgpuSurfaceGetCurrentTexture].
 */
public enum class WGPUSurfaceGetCurrentTextureStatus(
    public val `value`: Int,
) {
    Null(0x00000000),

    /**
     * Yay! Everything is good and we can render this frame.
     */
    SuccessOptimal(0x00000001),

    /**
     * Still OK - the surface can present the frame, but in a suboptimal way. The surface may need reconfiguration.
     */
    SuccessSuboptimal(0x00000002),

    /**
     * Some operation timed out while trying to acquire the frame.
     */
    Timeout(0x00000003),

    /**
     * The surface is too different to be used, compared to when it was originally created.
     */
    Outdated(0x00000004),

    /**
     * The connection to whatever owns the surface was lost, or generally needs to be fully reinitialized.
     */
    Lost(0x00000005),

    /**
     * There was some deterministic error (for example, the surface is not configured, or there was an [OutStructChainError](https://webgpu-native.github.io/webgpu-headers/StructChaining.html#OutStructChainError)). Should produce [ImplementationDefinedLogging](https://webgpu-native.github.io/webgpu-headers/Errors.html#ImplementationDefinedLogging) containing details.
     */
    Error(0x00000006),
    ;

    public companion object {
        @JvmStatic
        public val fromInt: MethodHandle = MethodHandles.lookup().findStatic(
            WGPUSurfaceGetCurrentTextureStatus::class.java,
            "fromInt",
            MethodType.methodType(WGPUSurfaceGetCurrentTextureStatus::class.java, Int::class.java)
        )

        @JvmStatic
        public val toInt: MethodHandle = MethodHandles.lookup().findGetter(
            WGPUSurfaceGetCurrentTextureStatus::class.java,
            "value",
            Int::class.java
        )

        @JvmStatic
        public fun fromInt(`value`: Int): WGPUSurfaceGetCurrentTextureStatus = when (value) {
            Null.value -> Null
            SuccessOptimal.value -> SuccessOptimal
            SuccessSuboptimal.value -> SuccessSuboptimal
            Timeout.value -> Timeout
            Outdated.value -> Outdated
            Lost.value -> Lost
            Error.value -> Error
            else -> error("enum not found")
        }
    }
}
