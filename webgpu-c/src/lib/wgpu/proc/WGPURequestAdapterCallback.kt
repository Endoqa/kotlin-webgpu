// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu.proc

import lib.wgpu.*
import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles

/**
 * TODO
 */
public fun interface WGPURequestAdapterCallback {
    /**
     * @param status TODO
     * @param adapter TODO
     * @param message TODO
     */
    public fun invoke(
        status: WGPURequestAdapterStatus,
        adapter: WGPUAdapter,
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
                MethodHandles.lookup().unreflect(WGPURequestAdapterCallback::class.java.methods.find {
                    it.name == "invoke"
                }
                ),
                1, WGPURequestAdapterStatus.fromInt, null, null, null, null,
            )

        @JvmStatic
        public val fd: FunctionDescriptor = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            `$RuntimeHelper`.POINTER,
            WGPUStringView.layout,
            `$RuntimeHelper`.POINTER,
            `$RuntimeHelper`.POINTER,
        )
    }
}
