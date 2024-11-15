// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c.proc

import java.lang.foreign.Arena
import java.lang.foreign.FunctionDescriptor
import java.lang.foreign.Linker
import java.lang.foreign.MemorySegment
import java.lang.foreign.ValueLayout
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import kotlin.UInt
import kotlin.ULong
import kotlin.jvm.JvmStatic
import webgpu.c.WGPUBuffer
import webgpu.c.WGPURenderBundleEncoder
import webgpu.c.`$RuntimeHelper`

public fun interface WGPUProcRenderBundleEncoderSetVertexBuffer {
    public fun invoke(
        renderBundleEncoder: WGPURenderBundleEncoder,
        slot: UInt,
        buffer: WGPUBuffer,
        offset: ULong,
        size: ULong,
    )

    public fun allocate(arena: Arena): MemorySegment =
        Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

    public companion object {
        @JvmStatic
        public val invokeHandle: MethodHandle =
            MethodHandles.lookup().unreflect(WGPUProcRenderBundleEncoderSetVertexBuffer::class.java.methods.find {
                it.name == "invoke"
            }
            )

        @JvmStatic
        public val fd: FunctionDescriptor = FunctionDescriptor.ofVoid(
            `$RuntimeHelper`.POINTER,
            ValueLayout.JAVA_INT,
            `$RuntimeHelper`.POINTER,
            ValueLayout.JAVA_LONG,
            ValueLayout.JAVA_LONG,
        )
    }
}
