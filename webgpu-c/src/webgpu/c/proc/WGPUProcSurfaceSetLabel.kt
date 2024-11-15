// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c.proc

import webgpu.c.`$RuntimeHelper`
import webgpu.c.WGPUStringView
import webgpu.c.WGPUSurface
import java.lang.foreign.Arena
import java.lang.foreign.FunctionDescriptor
import java.lang.foreign.Linker
import java.lang.foreign.MemorySegment
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles

public fun interface WGPUProcSurfaceSetLabel {
    public fun invoke(surface: WGPUSurface, label: WGPUStringView)

    public fun allocate(arena: Arena): MemorySegment =
        Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

    public companion object {
        @JvmStatic
        public val invokeHandle: MethodHandle =
            MethodHandles.lookup().unreflect(WGPUProcSurfaceSetLabel::class.java.methods.find {
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
