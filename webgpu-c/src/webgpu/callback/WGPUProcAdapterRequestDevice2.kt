package webgpu.callback

import webgpu.*
import java.lang.foreign.Arena
import java.lang.foreign.FunctionDescriptor
import java.lang.foreign.Linker
import java.lang.foreign.MemorySegment
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles

public fun interface WGPUProcAdapterRequestDevice2 {
    public fun invoke(
        adapter: WGPUAdapter,
        options: Pointer<WGPUDeviceDescriptor>,
        callbackInfo: WGPURequestDeviceCallbackInfo2,
    ): WGPUFuture

    public fun allocate(arena: Arena): MemorySegment =
        Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

    public companion object {
        @JvmStatic
        public val invokeHandle: MethodHandle =
            MethodHandles.lookup().unreflect(WGPUProcAdapterRequestDevice2::class.java.methods.find {
                it.name == "invoke"
            }
            )

        @JvmStatic
        public val fd: FunctionDescriptor = FunctionDescriptor.of(
            WGPUFuture.layout,
            `$RuntimeHelper`.POINTER,
            `$RuntimeHelper`.POINTER,
            WGPURequestDeviceCallbackInfo2.layout,
        )
    }
}
