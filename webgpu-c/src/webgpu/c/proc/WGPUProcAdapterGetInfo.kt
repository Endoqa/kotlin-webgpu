// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c.proc

import webgpu.c.*
import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles

public fun interface WGPUProcAdapterGetInfo {
    public fun invoke(adapter: WGPUAdapter, info: Pointer<WGPUAdapterInfo>): WGPUStatus

    public fun allocate(arena: Arena): MemorySegment =
        Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

    public companion object {
        @JvmStatic
        public val invokeHandle: MethodHandle =
            MethodHandles.filterReturnValue(
                MethodHandles.lookup().unreflect(WGPUProcAdapterGetInfo::class.java.methods.find {
                    it.name == "invoke"
                }
                ), WGPUStatus.toInt)

        @JvmStatic
        public val fd: FunctionDescriptor = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            `$RuntimeHelper`.POINTER,
            `$RuntimeHelper`.POINTER,
        )
    }
}
