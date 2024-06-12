package webgpu.callback

import webgpu.`$RuntimeHelper`
import webgpu.Pointer
import webgpu.WGPUBuffer
import webgpu.WGPUBufferMapCallback
import webgpu.WGPUMapModeFlags
import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles

public fun interface WGPUProcBufferMapAsync {
    public fun invoke(
        buffer: WGPUBuffer,
        mode: WGPUMapModeFlags,
        offset: ULong,
        size: ULong,
        callback: WGPUBufferMapCallback,
        userdata: Pointer<Unit>,
    )

    public fun allocate(arena: Arena): MemorySegment =
        Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

    public companion object {
        @JvmStatic
        public val invokeHandle: MethodHandle =
            MethodHandles.lookup().unreflect(WGPUProcBufferMapAsync::class.java.methods.find {
                it.name == "invoke"
            }
            )

        @JvmStatic
        public val fd: FunctionDescriptor = FunctionDescriptor.ofVoid(
            `$RuntimeHelper`.POINTER,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_LONG,
            ValueLayout.JAVA_LONG,
            `$RuntimeHelper`.POINTER,
            `$RuntimeHelper`.POINTER,
        )
    }
}
