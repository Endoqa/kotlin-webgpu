// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c.callback

import webgpu.c.`$RuntimeHelper`
import webgpu.c.Pointer
import webgpu.c.WGPUComputePipeline
import webgpu.c.WGPUCreatePipelineAsyncStatus
import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles

public fun interface WGPUCreateComputePipelineAsyncCallback {
    public fun invoke(
        status: WGPUCreatePipelineAsyncStatus,
        pipeline: WGPUComputePipeline,
        message: Pointer<Byte>,
        userdata: Pointer<Unit>,
    )

    public fun allocate(arena: Arena): MemorySegment =
        Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

    public companion object {
        @JvmStatic
        public val invokeHandle: MethodHandle =
            MethodHandles.filterArguments(
                MethodHandles.lookup().unreflect(WGPUCreateComputePipelineAsyncCallback::class.java.methods.find {
                    it.name == "invoke"
                }
                ),
                1, WGPUCreatePipelineAsyncStatus.fromInt, null, null, null,
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
