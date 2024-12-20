// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu.proc

import lib.wgpu.`$RuntimeHelper`
import lib.wgpu.Pointer
import lib.wgpu.WGPUMapAsyncStatus
import lib.wgpu.WGPUStringView
import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles

/**
 * TODO
 */
public fun interface WGPUBufferMapCallback {
    /**
     * @param status TODO
     * @param message TODO
     */
    public fun invoke(
        status: WGPUMapAsyncStatus,
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
                MethodHandles.lookup().unreflect(WGPUBufferMapCallback::class.java.methods.find {
                    it.name == "invoke"
                }
                ),
                1, WGPUMapAsyncStatus.fromInt, null, null, null,
            )

        @JvmStatic
        public val fd: FunctionDescriptor = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            WGPUStringView.layout,
            `$RuntimeHelper`.POINTER,
            `$RuntimeHelper`.POINTER,
        )
    }
}
