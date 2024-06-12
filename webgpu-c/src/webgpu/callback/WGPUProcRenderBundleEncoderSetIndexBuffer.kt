package webgpu.callback

import webgpu.*
import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles

public fun interface WGPUProcRenderBundleEncoderSetIndexBuffer {
    public fun invoke(
        renderBundleEncoder: WGPURenderBundleEncoder,
        buffer: WGPUBuffer,
        format: WGPUIndexFormat,
        offset: uint64_t,
        size: uint64_t,
    )

    public fun allocate(arena: Arena): MemorySegment =
        Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

    public companion object {
        @JvmStatic
        public val invokeHandle: MethodHandle =
            MethodHandles.filterArguments(
                MethodHandles.lookup().unreflect(WGPUProcRenderBundleEncoderSetIndexBuffer::class.java.methods.find {
                    it.name == "invoke"
                }
                ),
                1, null, null, WGPUIndexFormat.fromInt, null, null,
            )

        @JvmStatic
        public val fd: FunctionDescriptor = FunctionDescriptor.ofVoid(
            `$RuntimeHelper`.POINTER,
            `$RuntimeHelper`.POINTER,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_LONG,
            ValueLayout.JAVA_LONG,
        )
    }
}
