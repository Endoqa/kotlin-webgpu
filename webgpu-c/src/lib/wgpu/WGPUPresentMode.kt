// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu

import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType

/**
 * Describes when and in which order frames are presented on the screen when [wgpuSurfacePresent] is called.
 */
public enum class WGPUPresentMode(
    public val `value`: Int,
) {
    /**
     * Present mode is not specified. Use the default.
     */
    Undefined(0x00000000),

    /**
     * The presentation of the image to the user waits for the next vertical blanking period to update in a first-in, first-out manner.
     * Tearing cannot be observed and frame-loop will be limited to the display's refresh rate.
     * This is the only mode that's always available.
     */
    Fifo(0x00000001),

    /**
     * The presentation of the image to the user tries to wait for the next vertical blanking period but may decide to not wait if a frame is presented late.
     * Tearing can sometimes be observed but late-frame don't produce a full-frame stutter in the presentation.
     * This is still a first-in, first-out mechanism so a frame-loop will be limited to the display's refresh rate.
     */
    FifoRelaxed(0x00000002),

    /**
     * The presentation of the image to the user is updated immediately without waiting for a vertical blank.
     * Tearing can be observed but latency is minimized.
     */
    Immediate(0x00000003),

    /**
     * The presentation of the image to the user waits for the next vertical blanking period to update to the latest provided image.
     * Tearing cannot be observed and a frame-loop is not limited to the display's refresh rate.
     */
    Mailbox(0x00000004),
    ;

    public companion object {
        @JvmStatic
        public val fromInt: MethodHandle = MethodHandles.lookup().findStatic(
            WGPUPresentMode::class.java,
            "fromInt",
            MethodType.methodType(WGPUPresentMode::class.java, Int::class.java)
        )

        @JvmStatic
        public val toInt: MethodHandle = MethodHandles.lookup().findGetter(
            WGPUPresentMode::class.java,
            "value",
            Int::class.java
        )

        @JvmStatic
        public fun fromInt(`value`: Int): WGPUPresentMode = when (value) {
            Undefined.value -> Undefined
            Fifo.value -> Fifo
            FifoRelaxed.value -> FifoRelaxed
            Immediate.value -> Immediate
            Mailbox.value -> Mailbox
            else -> error("enum not found")
        }
    }
}
