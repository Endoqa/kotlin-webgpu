package webgpu.callback

import webgpu.`$RuntimeHelper`
import webgpu.WGPUBuffer
import webgpu.WGPUBufferMapState
import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles

public fun interface WGPUProcBufferGetMapState {
    public fun invoke(buffer: WGPUBuffer): WGPUBufferMapState

    public fun allocate(arena: Arena): MemorySegment =
        Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

    public companion object {
        @JvmStatic
        public val invokeHandle: MethodHandle =
            MethodHandles.filterReturnValue(
                MethodHandles.lookup().unreflect(WGPUProcBufferGetMapState::class.java.methods.find {
                    it.name == "invoke"
                }
                ), WGPUBufferMapState.toInt)

        @JvmStatic
        public val fd: FunctionDescriptor = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            `$RuntimeHelper`.POINTER,
        )
    }
}
