// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu

import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType
import kotlin.Int

/**
 * The callback mode controls how a callback for an asynchronous operation may be fired. See @ref Asynchronous-Operations for how these are used.
 */
public enum class WGPUCallbackMode(
    public val `value`: Int,
) {
    Null(0x00000000),

    /**
     * Callbacks created with `WGPUCallbackMode_WaitAnyOnly`:
     * - fire when the asynchronous operation's future is passed to a call to @ref wgpuInstanceWaitAny
     *   AND the operation has already completed or it completes inside the call to @ref wgpuInstanceWaitAny.
     */
    WaitAnyOnly(0x00000001),

    /**
     * Callbacks created with `WGPUCallbackMode_AllowProcessEvents`:
     * - fire for the same reasons as callbacks created with `WGPUCallbackMode_WaitAnyOnly`
     * - fire inside a call to @ref wgpuInstanceProcessEvents if the asynchronous operation is complete.
     */
    AllowProcessEvents(0x00000002),

    /**
     * Callbacks created with `WGPUCallbackMode_AllowSpontaneous`:
     * - fire for the same reasons as callbacks created with `WGPUCallbackMode_AllowProcessEvents`
     * - **may** fire spontaneously on an arbitrary or application thread, when the WebGPU implementations discovers that the asynchronous operation is complete.
     *
     *   Implementations _should_ fire spontaneous callbacks as soon as possible.
     *
     * @note Because spontaneous callbacks may fire at an arbitrary time on an arbitrary thread, applications should take extra care when acquiring locks or mutating state inside the callback. It undefined behavior to re-entrantly call into the webgpu.h API if the callback fires while inside the callstack of another webgpu.h function that is not `wgpuInstanceWaitAny` or `wgpuInstanceProcessEvents`.
     */
    AllowSpontaneous(0x00000003),
    ;

    public companion object {
        @JvmStatic
        public val fromInt: MethodHandle = MethodHandles.lookup().findStatic(
            WGPUCallbackMode::class.java,
            "fromInt",
            MethodType.methodType(WGPUCallbackMode::class.java, Int::class.java)
        )

        @JvmStatic
        public val toInt: MethodHandle = MethodHandles.lookup().findGetter(
            WGPUCallbackMode::class.java,
            "value",
            Int::class.java
        )

        @JvmStatic
        public fun fromInt(`value`: Int): WGPUCallbackMode = when (value) {
            Null.value -> Null
            WaitAnyOnly.value -> WaitAnyOnly
            AllowProcessEvents.value -> AllowProcessEvents
            AllowSpontaneous.value -> AllowSpontaneous
            else -> error("enum not found")
        }
    }
}
