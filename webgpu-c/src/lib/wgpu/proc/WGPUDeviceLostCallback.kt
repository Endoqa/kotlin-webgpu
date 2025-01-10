// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu.proc

import lib.wgpu.*
import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles

/**
 * TODO
 */
public fun interface WGPUDeviceLostCallback {
    /**
     * @param device Reference to the device which was lost. If, and only if, the [reason] is [WGPUDeviceLostReason.FailedCreation], this is a non-null pointer to a null [WGPUDevice].
     * @param reason TODO
     * @param message TODO
     */
    @CFunctionInvoke
    public fun invoke(
        device: Pointer<WGPUDevice>,
        reason: WGPUDeviceLostReason,
        message: WGPUStringView,
        userdata1: Pointer<Unit>,
        userdata2: Pointer<Unit>,
    )

    public fun allocate(arena: Arena): MemorySegment =
        Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

    public companion object {
        @JvmStatic
        public val invokeHandle: MethodHandle =
            MethodHandles.filterArguments(
                MethodHandles.lookup().unreflect(WGPUDeviceLostCallback::class.java.methods.find {
                    it.getAnnotation(CFunctionInvoke::class.java) != null
                }
                ),
                1, null, WGPUDeviceLostReason.fromInt, null, null, null,
            )

        @JvmStatic
        public val fd: FunctionDescriptor = FunctionDescriptor.ofVoid(
            `$RuntimeHelper`.POINTER,
            ValueLayout.JAVA_INT,
            WGPUStringView.layout,
            `$RuntimeHelper`.POINTER,
            `$RuntimeHelper`.POINTER,
        )
    }
}
