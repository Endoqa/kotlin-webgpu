package webgpu.callback

import webgpu.`$RuntimeHelper`
import webgpu.WGPUBool
import webgpu.WGPUInstance
import webgpu.WGPUWGSLFeatureName
import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles

public fun interface WGPUProcInstanceHasWGSLLanguageFeature {
    public fun invoke(instance: WGPUInstance, feature: WGPUWGSLFeatureName): WGPUBool

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
                1, null, WGPUWGSLFeatureName.fromInt,
            )

        @JvmStatic
        public val fd: FunctionDescriptor = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            `$RuntimeHelper`.POINTER,
            ValueLayout.JAVA_INT,
        )
    }
}
