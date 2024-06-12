package webgpu.callback

import webgpu.`$RuntimeHelper`
import webgpu.WGPUAdapter
import webgpu.WGPUBool
import webgpu.WGPUFeatureName
import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles

public fun interface WGPUProcAdapterHasFeature {
    public fun invoke(adapter: WGPUAdapter, feature: WGPUFeatureName): WGPUBool

    public fun allocate(arena: Arena): MemorySegment =
        Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

    public companion object {
        @JvmStatic
        public val invokeHandle: MethodHandle =
            MethodHandles.filterArguments(
                MethodHandles.lookup().unreflect(WGPUProcAdapterHasFeature::class.java.methods.find {
                    it.name == "invoke"
                }
                ),
                1, null, WGPUFeatureName.fromInt,
            )

        @JvmStatic
        public val fd: FunctionDescriptor = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            `$RuntimeHelper`.POINTER,
            ValueLayout.JAVA_INT,
        )
    }
}
