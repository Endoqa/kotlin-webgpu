package webgpu.callback

import webgpu.`$RuntimeHelper`
import webgpu.Pointer
import webgpu.WGPUBuffer
import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles

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
