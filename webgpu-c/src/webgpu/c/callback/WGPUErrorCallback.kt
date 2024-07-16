// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c.callback

import webgpu.c.`$RuntimeHelper`
import webgpu.c.Pointer
import webgpu.c.WGPUErrorType
import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles

public fun interface WGPUErrorCallback {
    public fun invoke(
        type: WGPUErrorType,
        message: Pointer<Byte>,
        userdata: Pointer<Unit>,
    )

    public fun allocate(arena: Arena): MemorySegment =
        Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

    public companion object {
        @JvmStatic
        public val invokeHandle: MethodHandle =
            MethodHandles.filterArguments(
                MethodHandles.lookup().unreflect(WGPUErrorCallback::class.java.methods.find {
                    it.name == "invoke"
                }
                ),
                1, WGPUErrorType.fromInt, null, null,
            )

        @JvmStatic
        public val fd: FunctionDescriptor = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            `$RuntimeHelper`.POINTER,
            `$RuntimeHelper`.POINTER,
        )
    }
}