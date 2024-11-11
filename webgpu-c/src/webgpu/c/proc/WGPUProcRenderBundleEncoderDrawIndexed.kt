// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c.proc

import java.lang.foreign.Arena
import java.lang.foreign.FunctionDescriptor
import java.lang.foreign.Linker
import java.lang.foreign.MemorySegment
import java.lang.foreign.ValueLayout
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import kotlin.Int
import kotlin.UInt
import kotlin.jvm.JvmStatic
import webgpu.c.WGPURenderBundleEncoder
import webgpu.c.`$RuntimeHelper`

public fun interface WGPUProcRenderBundleEncoderDrawIndexed {
    public fun invoke(
        renderBundleEncoder: WGPURenderBundleEncoder,
        indexCount: UInt,
        instanceCount: UInt,
        firstIndex: UInt,
        baseVertex: Int,
        firstInstance: UInt,
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
