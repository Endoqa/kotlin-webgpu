// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c.callback

import webgpu.c.`$RuntimeHelper`
import webgpu.c.Pointer
import webgpu.c.WGPUErrorType
import webgpu.c.WGPUPopErrorScopeStatus
import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles

public fun interface WGPUPopErrorScopeCallback2 {
    public fun invoke(
        status: WGPUPopErrorScopeStatus,
        type: WGPUErrorType,
        message: Pointer<Byte>,
        userdata1: Pointer<Unit>,
        userdata2: Pointer<Unit>,
    )

    public fun allocate(arena: Arena): MemorySegment =
        Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

    public companion object {
        @JvmStatic
        public val invokeHandle: MethodHandle =
            MethodHandles.filterArguments(
                MethodHandles.lookup().unreflect(WGPUPopErrorScopeCallback2::class.java.methods.find {
                    it.name == "invoke"
                }
                ),
                1, WGPUPopErrorScopeStatus.fromInt, WGPUErrorType.fromInt, null, null, null,
            )

        @JvmStatic
        public val fd: FunctionDescriptor = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            `$RuntimeHelper`.POINTER,
            `$RuntimeHelper`.POINTER,
            `$RuntimeHelper`.POINTER,
        )
    }
}
