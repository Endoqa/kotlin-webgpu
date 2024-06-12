package webgpu.callback

import webgpu.`$RuntimeHelper`
import webgpu.WGPURenderPassEncoder
import webgpu.uint32_t
import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles

public fun interface WGPUProcRenderPassEncoderDraw {
    public fun invoke(
        renderPassEncoder: WGPURenderPassEncoder,
        vertexCount: uint32_t,
        instanceCount: uint32_t,
        firstVertex: uint32_t,
        firstInstance: uint32_t,
    )

    public fun allocate(arena: Arena): MemorySegment =
        Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

    public companion object {
        @JvmStatic
        public val invokeHandle: MethodHandle =
            MethodHandles.lookup().unreflect(WGPUProcRenderPassEncoderDraw::class.java.methods.find {
                it.name == "invoke"
            }
            )

        @JvmStatic
        public val fd: FunctionDescriptor = FunctionDescriptor.ofVoid(
            `$RuntimeHelper`.POINTER,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
        )
    }
}
