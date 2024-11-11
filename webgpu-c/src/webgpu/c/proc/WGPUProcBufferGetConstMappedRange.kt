// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c.proc

import java.lang.foreign.Arena
import java.lang.foreign.FunctionDescriptor
import java.lang.foreign.Linker
import java.lang.foreign.MemorySegment
import java.lang.foreign.ValueLayout
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import kotlin.ULong
import kotlin.Unit
import kotlin.jvm.JvmStatic
import webgpu.c.Pointer
import webgpu.c.WGPUBuffer
import webgpu.c.`$RuntimeHelper`

public fun interface WGPUProcBufferGetConstMappedRange {
    public fun invoke(
        buffer: WGPUBuffer,
        offset: ULong,
        size: ULong,
    ): Pointer<Unit>

    public fun allocate(arena: Arena): MemorySegment =
        Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

    public companion object {
        @JvmStatic
        public val invokeHandle: MethodHandle =
            MethodHandles.lookup().unreflect(WGPUProcBufferGetConstMappedRange::class.java.methods.find {
                it.name == "invoke"
            }
            )

        @JvmStatic
        public val fd: FunctionDescriptor = FunctionDescriptor.of(
            `$RuntimeHelper`.POINTER,
            `$RuntimeHelper`.POINTER,
            ValueLayout.JAVA_LONG,
            ValueLayout.JAVA_LONG,
        )
    }
}
