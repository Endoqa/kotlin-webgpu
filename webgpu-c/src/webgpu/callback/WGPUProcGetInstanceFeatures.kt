package webgpu.callback

import webgpu.`$RuntimeHelper`
import webgpu.Pointer
import webgpu.WGPUInstanceFeatures
import webgpu.WGPUStatus
import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles

public fun interface WGPUProcGetInstanceFeatures {
    public fun invoke(features: Pointer<WGPUInstanceFeatures>): WGPUStatus

    public fun allocate(arena: Arena): MemorySegment =
        Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

    public companion object {
        @JvmStatic
        public val invokeHandle: MethodHandle =
            MethodHandles.filterReturnValue(
                MethodHandles.lookup().unreflect(WGPUProcGetInstanceFeatures::class.java.methods.find {
                    it.name == "invoke"
                }
                ), WGPUStatus.toInt)

        @JvmStatic
        public val fd: FunctionDescriptor = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            `$RuntimeHelper`.POINTER,
        )
    }
}
