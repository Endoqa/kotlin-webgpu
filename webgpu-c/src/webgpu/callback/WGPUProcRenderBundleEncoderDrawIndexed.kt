package webgpu.callback

import webgpu.`$RuntimeHelper`
import webgpu.WGPURenderBundleEncoder
import webgpu.int32_t
import webgpu.uint32_t
import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles

public fun interface WGPUProcRenderBundleEncoderDrawIndexed {
    public fun invoke(
        renderBundleEncoder: WGPURenderBundleEncoder,
        indexCount: uint32_t,
        instanceCount: uint32_t,
        firstIndex: uint32_t,
        baseVertex: int32_t,
        firstInstance: uint32_t,
    )

    public fun allocate(arena: Arena): MemorySegment =
        Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

    public companion object {
        @JvmStatic
        public val invokeHandle: MethodHandle =
            MethodHandles.lookup().unreflect(WGPUProcRenderBundleEncoderDrawIndexed::class.java.methods.find {
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
            ValueLayout.JAVA_INT,
        )
    }
}
