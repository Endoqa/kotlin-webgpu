// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu.proc

import lib.wgpu.`$RuntimeHelper`
import lib.wgpu.Pointer
import lib.wgpu.WGPUCompilationInfo
import lib.wgpu.WGPUCompilationInfoRequestStatus
import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles

public fun interface WGPUCompilationInfoCallback {
    public fun invoke(
        status: WGPUCompilationInfoRequestStatus,
        compilationInfo: Pointer<WGPUCompilationInfo>,
        userdata1: Pointer<Unit>,
        userdata2: Pointer<Unit>,
    )

    public fun allocate(arena: Arena): MemorySegment =
        Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

    public companion object {
        @JvmStatic
        public val invokeHandle: MethodHandle =
            MethodHandles.filterArguments(
                MethodHandles.lookup().unreflect(WGPUCompilationInfoCallback::class.java.methods.find {
                    it.name == "invoke"
                }
                ),
                1, WGPUCompilationInfoRequestStatus.fromInt, null, null, null,
            )

        @JvmStatic
        public val fd: FunctionDescriptor = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            `$RuntimeHelper`.POINTER,
            `$RuntimeHelper`.POINTER,
            `$RuntimeHelper`.POINTER,
        )
    }
}