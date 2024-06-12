package webgpu.callback

import webgpu.*
import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles

public fun interface WGPUProcCommandEncoderWriteBuffer {
    public fun invoke(
        commandEncoder: WGPUCommandEncoder,
        buffer: WGPUBuffer,
        bufferOffset: uint64_t,
        `data`: Pointer<uint8_t>,
        size: uint64_t,
    )

    public fun allocate(arena: Arena): MemorySegment =
        Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

    public companion object {
        @JvmStatic
        public val invokeHandle: MethodHandle =
            MethodHandles.lookup().unreflect(WGPUProcCommandEncoderWriteBuffer::class.java.methods.find {
                it.name == "invoke"
            }
            )

        @JvmStatic
        public val fd: FunctionDescriptor = FunctionDescriptor.ofVoid(
            `$RuntimeHelper`.POINTER,
            `$RuntimeHelper`.POINTER,
            ValueLayout.JAVA_LONG,
            `$RuntimeHelper`.POINTER,
            ValueLayout.JAVA_LONG,
        )
    }
}
