// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu.proc

import lib.wgpu.`$RuntimeHelper`
import lib.wgpu.CFunctionInvoke
import lib.wgpu.Pointer
import lib.wgpu.WGPUQueueWorkDoneStatus
import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles

/**
 * TODO
 */
public fun interface WGPUQueueWorkDoneCallback {
    /**
     * @param status TODO
     */
    @CFunctionInvoke
    public fun invoke(
        status: WGPUQueueWorkDoneStatus,
        userdata1: Pointer<Unit>,
        userdata2: Pointer<Unit>,
    )

    public fun allocate(arena: Arena): MemorySegment =
        Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

    public companion object {
        @JvmStatic
        public val invokeHandle: MethodHandle =
            MethodHandles.filterArguments(
                MethodHandles.lookup().unreflect(WGPUQueueWorkDoneCallback::class.java.methods.find {
                    it.getAnnotation(CFunctionInvoke::class.java) != null
                }
                ),
                1, WGPUQueueWorkDoneStatus.fromInt, null, null,
            )

        @JvmStatic
        public val fd: FunctionDescriptor = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            `$RuntimeHelper`.POINTER,
            `$RuntimeHelper`.POINTER,
        )
    }
}
