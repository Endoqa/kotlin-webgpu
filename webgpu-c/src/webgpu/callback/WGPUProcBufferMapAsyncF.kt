package webgpu.callback

import webgpu.*
import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles

public fun interface WGPUProcBufferMapAsyncF {
    public fun invoke(
        buffer: WGPUBuffer,
        mode: WGPUMapModeFlags,
        offset: ULong,
        size: ULong,
        callbackInfo: WGPUBufferMapCallbackInfo,
    ): WGPUFuture

    public fun allocate(arena: Arena): MemorySegment =
        Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

    public companion object {
        @JvmStatic
        public val invokeHandle: MethodHandle =
            MethodHandles.lookup().unreflect(WGPUProcBufferMapAsyncF::class.java.methods.find {
                it.name == "invoke"
            }
            )

        @JvmStatic
        public val fd: FunctionDescriptor = FunctionDescriptor.of(
            WGPUFuture.layout,
            `$RuntimeHelper`.POINTER,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_LONG,
            ValueLayout.JAVA_LONG,
            WGPUBufferMapCallbackInfo.layout,
        )
    }
}
