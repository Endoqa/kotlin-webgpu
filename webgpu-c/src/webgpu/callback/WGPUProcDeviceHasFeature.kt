package webgpu.callback

import webgpu.`$RuntimeHelper`
import webgpu.WGPUBool
import webgpu.WGPUDevice
import webgpu.WGPUFeatureName
import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles

public fun interface WGPUProcDeviceHasFeature {
    public fun invoke(device: WGPUDevice, feature: WGPUFeatureName): WGPUBool

    public fun allocate(arena: Arena): MemorySegment =
        Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

    public companion object {
        @JvmStatic
        public val invokeHandle: MethodHandle =
            MethodHandles.filterArguments(
                MethodHandles.lookup().unreflect(WGPUProcDeviceHasFeature::class.java.methods.find {
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
