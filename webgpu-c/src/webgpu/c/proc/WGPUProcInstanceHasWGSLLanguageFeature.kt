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
import webgpu.c.WGPUBool
import webgpu.c.WGPUInstance
import webgpu.c.WGPUWGSLLanguageFeatureName
import webgpu.c.`$RuntimeHelper`

public fun interface WGPUProcInstanceHasWGSLLanguageFeature {
    public fun invoke(instance: WGPUInstance, feature: WGPUWGSLLanguageFeatureName): WGPUBool

    public fun allocate(arena: Arena): MemorySegment =
        Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

    public companion object {
        @JvmStatic
        public val invokeHandle: MethodHandle =
            MethodHandles.filterArguments(
                MethodHandles.lookup().unreflect(WGPUProcInstanceHasWGSLLanguageFeature::class.java.methods.find {
                    it.name == "invoke"
                }
                ),
                1, null, WGPUWGSLLanguageFeatureName.fromInt,
            )

        @JvmStatic
        public val fd: FunctionDescriptor = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            `$RuntimeHelper`.POINTER,
            ValueLayout.JAVA_INT,
        )
    }
}
