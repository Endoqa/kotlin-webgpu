package webgpu.callback

import webgpu.`$RuntimeHelper`
import webgpu.WGPUBuffer
import webgpu.WGPUCommandEncoder
import webgpu.uint64_t
import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles

public fun interface WGPUProcCommandEncoderCopyBufferToBuffer {
    public fun invoke(
        commandEncoder: WGPUCommandEncoder,
        source: WGPUBuffer,
        sourceOffset: uint64_t,
        destination: WGPUBuffer,
        destinationOffset: uint64_t,
        size: uint64_t,
    )

    public fun allocate(arena: Arena): MemorySegment =
        Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

    public companion object {
        @JvmStatic
        public val invokeHandle: MethodHandle =
            MethodHandles.lookup().unreflect(WGPUProcCommandEncoderCopyBufferToBuffer::class.java.methods.find {
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
            ValueLayout.JAVA_LONG,
        )
    }
}
