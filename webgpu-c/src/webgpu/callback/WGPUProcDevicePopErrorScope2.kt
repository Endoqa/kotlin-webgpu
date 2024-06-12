package webgpu.callback

import webgpu.`$RuntimeHelper`
import webgpu.WGPUDevice
import webgpu.WGPUFuture
import webgpu.WGPUPopErrorScopeCallbackInfo2
import java.lang.foreign.Arena
import java.lang.foreign.FunctionDescriptor
import java.lang.foreign.Linker
import java.lang.foreign.MemorySegment
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles

public fun interface WGPUProcDevicePopErrorScope2 {
    public fun invoke(device: WGPUDevice, callbackInfo: WGPUPopErrorScopeCallbackInfo2): WGPUFuture

    public fun allocate(arena: Arena): MemorySegment =
        Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

    public companion object {
        @JvmStatic
        public val invokeHandle: MethodHandle =
            MethodHandles.lookup().unreflect(WGPUProcDevicePopErrorScope2::class.java.methods.find {
                it.name == "invoke"
            }
            )

        @JvmStatic
        public val fd: FunctionDescriptor = FunctionDescriptor.of(
            WGPUFuture.layout,
            `$RuntimeHelper`.POINTER,
            WGPUPopErrorScopeCallbackInfo2.layout,
        )
    }
}
