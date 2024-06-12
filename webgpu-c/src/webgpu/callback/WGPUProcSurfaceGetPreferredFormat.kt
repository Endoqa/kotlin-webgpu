package webgpu.callback

import webgpu.`$RuntimeHelper`
import webgpu.WGPUAdapter
import webgpu.WGPUSurface
import webgpu.WGPUTextureFormat
import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles

public fun interface WGPUProcSurfaceGetPreferredFormat {
    public fun invoke(surface: WGPUSurface, adapter: WGPUAdapter): WGPUTextureFormat

    public fun allocate(arena: Arena): MemorySegment =
        Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

    public companion object {
        @JvmStatic
        public val invokeHandle: MethodHandle =
            MethodHandles.filterReturnValue(
                MethodHandles.lookup().unreflect(WGPUProcSurfaceGetPreferredFormat::class.java.methods.find {
                    it.name == "invoke"
                }
                ), WGPUTextureFormat.toInt)

        @JvmStatic
        public val fd: FunctionDescriptor = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            `$RuntimeHelper`.POINTER,
            `$RuntimeHelper`.POINTER,
        )
    }
}
