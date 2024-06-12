package webgpu.callback

import webgpu.`$RuntimeHelper`
import webgpu.WGPUBuffer
import webgpu.uint64_t
import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles

public fun interface WGPUProcBufferGetSize {
    public fun invoke(buffer: WGPUBuffer): uint64_t

    public fun allocate(arena: Arena): MemorySegment =
        Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

    public companion object {
        @JvmStatic
        public val invokeHandle: MethodHandle =
            MethodHandles.lookup().unreflect(WGPUProcBufferGetSize::class.java.methods.find {
                it.name == "invoke"
            }
            )

        @JvmStatic
        public val fd: FunctionDescriptor = FunctionDescriptor.of(
            ValueLayout.JAVA_LONG,
            `$RuntimeHelper`.POINTER,
        )
    }
}
