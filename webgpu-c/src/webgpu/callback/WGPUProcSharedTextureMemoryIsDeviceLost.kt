package webgpu.callback

import webgpu.`$RuntimeHelper`
import webgpu.WGPUBool
import webgpu.WGPUSharedTextureMemory
import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles

public fun interface WGPUProcSharedTextureMemoryIsDeviceLost {
    public fun invoke(sharedTextureMemory: WGPUSharedTextureMemory): WGPUBool

    public fun allocate(arena: Arena): MemorySegment =
        Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

    public companion object {
        @JvmStatic
        public val invokeHandle: MethodHandle =
            MethodHandles.lookup().unreflect(WGPUProcSharedTextureMemoryIsDeviceLost::class.java.methods.find {
                it.name == "invoke"
            }
            )

        @JvmStatic
        public val fd: FunctionDescriptor = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            `$RuntimeHelper`.POINTER,
        )
    }
}
