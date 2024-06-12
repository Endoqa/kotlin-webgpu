package webgpu.callback

import webgpu.`$RuntimeHelper`
import webgpu.WGPUBindGroupLayout
import webgpu.WGPURenderPipeline
import webgpu.uint32_t
import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles

public fun interface WGPUProcRenderPipelineGetBindGroupLayout {
    public fun invoke(renderPipeline: WGPURenderPipeline, groupIndex: uint32_t): WGPUBindGroupLayout

    public fun allocate(arena: Arena): MemorySegment =
        Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

    public companion object {
        @JvmStatic
        public val invokeHandle: MethodHandle =
            MethodHandles.lookup().unreflect(WGPUProcRenderPipelineGetBindGroupLayout::class.java.methods.find {
                it.name == "invoke"
            }
            )

        @JvmStatic
        public val fd: FunctionDescriptor = FunctionDescriptor.of(
            `$RuntimeHelper`.POINTER,
            `$RuntimeHelper`.POINTER,
            ValueLayout.JAVA_INT,
        )
    }
}
