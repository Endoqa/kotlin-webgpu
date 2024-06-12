package webgpu.callback

import webgpu.`$RuntimeHelper`
import webgpu.WGPUBuffer
import webgpu.WGPURenderPassEncoder
import webgpu.uint64_t
import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles

public fun interface WGPUProcRenderPassEncoderDrawIndirect {
    public fun invoke(
        renderPassEncoder: WGPURenderPassEncoder,
        indirectBuffer: WGPUBuffer,
        indirectOffset: uint64_t,
    )

    public fun allocate(arena: Arena): MemorySegment =
        Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

    public companion object {
        @JvmStatic
        public val invokeHandle: MethodHandle =
            MethodHandles.lookup().unreflect(WGPUProcRenderPassEncoderDrawIndirect::class.java.methods.find {
                it.name == "invoke"
            }
            )

        @JvmStatic
        public val fd: FunctionDescriptor = FunctionDescriptor.ofVoid(
            `$RuntimeHelper`.POINTER,
            `$RuntimeHelper`.POINTER,
            ValueLayout.JAVA_LONG,
        )
    }
}
