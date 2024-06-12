package webgpu.callback

import webgpu.`$RuntimeHelper`
import webgpu.WGPUComputePassEncoder
import webgpu.WGPUQuerySet
import webgpu.uint32_t
import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles

public fun interface WGPUProcComputePassEncoderWriteTimestamp {
    public fun invoke(
        computePassEncoder: WGPUComputePassEncoder,
        querySet: WGPUQuerySet,
        queryIndex: uint32_t,
    )

    public fun allocate(arena: Arena): MemorySegment =
        Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

    public companion object {
        @JvmStatic
        public val invokeHandle: MethodHandle =
            MethodHandles.lookup().unreflect(WGPUProcComputePassEncoderWriteTimestamp::class.java.methods.find {
                it.name == "invoke"
            }
            )

        @JvmStatic
        public val fd: FunctionDescriptor = FunctionDescriptor.ofVoid(
            `$RuntimeHelper`.POINTER,
            `$RuntimeHelper`.POINTER,
            ValueLayout.JAVA_INT,
        )
    }
}
