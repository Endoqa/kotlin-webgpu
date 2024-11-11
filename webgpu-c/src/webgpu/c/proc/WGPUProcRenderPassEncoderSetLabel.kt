// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c.proc

import java.lang.foreign.Arena
import java.lang.foreign.FunctionDescriptor
import java.lang.foreign.Linker
import java.lang.foreign.MemorySegment
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import kotlin.jvm.JvmStatic
import webgpu.c.WGPURenderPassEncoder
import webgpu.c.WGPUStringView
import webgpu.c.`$RuntimeHelper`

public fun interface WGPUProcRenderPassEncoderSetLabel {
    public fun invoke(renderPassEncoder: WGPURenderPassEncoder, label: WGPUStringView)

    public fun allocate(arena: Arena): MemorySegment =
        Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

    public companion object {
        @JvmStatic
        public val invokeHandle: MethodHandle =
            MethodHandles.lookup().unreflect(WGPUProcRenderPassEncoderSetLabel::class.java.methods.find {
                it.name == "invoke"
            }
            )

        @JvmStatic
        public val fd: FunctionDescriptor = FunctionDescriptor.ofVoid(
            `$RuntimeHelper`.POINTER,
            WGPUStringView.layout,
        )
    }
}
