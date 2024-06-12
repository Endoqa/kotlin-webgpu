package webgpu.callback

import webgpu.`$RuntimeHelper`
import webgpu.Pointer
import webgpu.WGPUDevice
import webgpu.WGPURequestDeviceStatus
import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles

public fun interface WGPURequestDeviceCallback {
    public fun invoke(
        status: WGPURequestDeviceStatus,
        device: WGPUDevice,
        message: Pointer<Byte>,
        userdata: Pointer<Unit>,
    )

    public fun allocate(arena: Arena): MemorySegment =
        Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

    public companion object {
        @JvmStatic
        public val invokeHandle: MethodHandle =
            MethodHandles.filterArguments(
                MethodHandles.lookup().unreflect(WGPURequestDeviceCallback::class.java.methods.find {
                    it.name == "invoke"
                }
                ),
                1, WGPURequestDeviceStatus.fromInt, null, null, null,
            )

        @JvmStatic
        public val fd: FunctionDescriptor = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            `$RuntimeHelper`.POINTER,
            `$RuntimeHelper`.POINTER,
            `$RuntimeHelper`.POINTER,
        )
    }
}
