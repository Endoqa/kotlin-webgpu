package webgpu.callback

import webgpu.*
import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles

public fun interface WGPUProcDeviceGetAHardwareBufferProperties {
    public fun invoke(
        device: WGPUDevice,
        handle: Pointer<Unit>,
        properties: Pointer<WGPUAHardwareBufferProperties>,
    ): WGPUStatus

    public fun allocate(arena: Arena): MemorySegment =
        Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

    public companion object {
        @JvmStatic
        public val invokeHandle: MethodHandle =
            MethodHandles.filterReturnValue(
                MethodHandles.lookup().unreflect(WGPUProcDeviceGetAHardwareBufferProperties::class.java.methods.find {
                    it.name == "invoke"
                }
                ), WGPUStatus.toInt)

        @JvmStatic
        public val fd: FunctionDescriptor = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            `$RuntimeHelper`.POINTER,
            `$RuntimeHelper`.POINTER,
            `$RuntimeHelper`.POINTER,
        )
    }
}
