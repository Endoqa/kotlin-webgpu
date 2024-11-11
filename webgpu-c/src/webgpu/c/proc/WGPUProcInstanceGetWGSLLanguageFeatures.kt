// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c.proc

import java.lang.foreign.Arena
import java.lang.foreign.FunctionDescriptor
import java.lang.foreign.Linker
import java.lang.foreign.MemorySegment
import java.lang.foreign.ValueLayout
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import kotlin.jvm.JvmStatic
import webgpu.c.Pointer
import webgpu.c.WGPUInstance
import webgpu.c.WGPUStatus
import webgpu.c.WGPUSupportedWGSLLanguageFeatures
import webgpu.c.`$RuntimeHelper`

public fun interface WGPUProcInstanceGetWGSLLanguageFeatures {
    public fun invoke(instance: WGPUInstance, features: Pointer<WGPUSupportedWGSLLanguageFeatures>):
            WGPUStatus

    public fun allocate(arena: Arena): MemorySegment =
        Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

    public companion object {
        @JvmStatic
        public val invokeHandle: MethodHandle =
            MethodHandles.filterReturnValue(
                MethodHandles.lookup().unreflect(WGPUProcInstanceGetWGSLLanguageFeatures::class.java.methods.find {
                    it.name == "invoke"
                }
                ), WGPUStatus.toInt)

        @JvmStatic
        public val fd: FunctionDescriptor = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            `$RuntimeHelper`.POINTER,
            `$RuntimeHelper`.POINTER,
        )
    }
}
