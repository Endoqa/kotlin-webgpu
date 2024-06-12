package webgpu.callback

import webgpu.`$RuntimeHelper`
import webgpu.Pointer
import webgpu.WGPUCreatePipelineAsyncStatus
import webgpu.WGPURenderPipeline
import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles

public fun interface WGPUCreateRenderPipelineAsyncCallback2 {
    public fun invoke(
        status: WGPUCreatePipelineAsyncStatus,
        pipeline: WGPURenderPipeline,
        message: Pointer<Byte>,
        userdata1: Pointer<Unit>,
        userdata2: Pointer<Unit>,
    )

    public fun allocate(arena: Arena): MemorySegment =
        Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

    public companion object {
        @JvmStatic
        public val invokeHandle: MethodHandle =
            MethodHandles.filterArguments(
                MethodHandles.lookup().unreflect(WGPUCreateRenderPipelineAsyncCallback2::class.java.methods.find {
                    it.name == "invoke"
                }
                ),
                1, WGPUCreatePipelineAsyncStatus.fromInt, null, null, null, null,
            )

        @JvmStatic
        public val fd: FunctionDescriptor = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            `$RuntimeHelper`.POINTER,
            `$RuntimeHelper`.POINTER,
            `$RuntimeHelper`.POINTER,
            `$RuntimeHelper`.POINTER,
        )
    }
}
