package webgpu.callback

import webgpu.`$RuntimeHelper`
import webgpu.Pointer
import webgpu.WGPUDevice
import webgpu.WGPUDeviceLostReason
import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles

public fun interface WGPUProcDeviceForceLoss {
    public fun invoke(
        device: WGPUDevice,
        type: WGPUDeviceLostReason,
        message: Pointer<Byte>,
    )

    public fun allocate(arena: Arena): MemorySegment =
        Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

    public companion object {
        @JvmStatic
        public val invokeHandle: MethodHandle =
            MethodHandles.filterArguments(
                MethodHandles.lookup().unreflect(WGPUProcDeviceForceLoss::class.java.methods.find {
                    it.name == "invoke"
                }
                ),
                1, null, WGPUDeviceLostReason.fromInt, null,
            )

        @JvmStatic
        public val fd: FunctionDescriptor = FunctionDescriptor.ofVoid(
            `$RuntimeHelper`.POINTER,
            ValueLayout.JAVA_INT,
            `$RuntimeHelper`.POINTER,
        )
    }
}
