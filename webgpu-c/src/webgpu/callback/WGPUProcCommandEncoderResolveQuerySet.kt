package webgpu.callback

import webgpu.*
import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles

public fun interface WGPUProcCommandEncoderResolveQuerySet {
    public fun invoke(
        commandEncoder: WGPUCommandEncoder,
        querySet: WGPUQuerySet,
        firstQuery: uint32_t,
        queryCount: uint32_t,
        destination: WGPUBuffer,
        destinationOffset: uint64_t,
    )

    public fun allocate(arena: Arena): MemorySegment =
        Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

    public companion object {
        @JvmStatic
        public val invokeHandle: MethodHandle =
            MethodHandles.lookup().unreflect(WGPUProcCommandEncoderResolveQuerySet::class.java.methods.find {
                it.name == "invoke"
            }
            )

        @JvmStatic
        public val fd: FunctionDescriptor = FunctionDescriptor.ofVoid(
            `$RuntimeHelper`.POINTER,
            `$RuntimeHelper`.POINTER,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            `$RuntimeHelper`.POINTER,
            ValueLayout.JAVA_LONG,
        )
    }
}
