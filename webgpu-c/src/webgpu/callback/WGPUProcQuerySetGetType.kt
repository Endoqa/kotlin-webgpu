package webgpu.callback

import webgpu.`$RuntimeHelper`
import webgpu.WGPUQuerySet
import webgpu.WGPUQueryType
import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles

public fun interface WGPUProcQuerySetGetType {
    public fun invoke(querySet: WGPUQuerySet): WGPUQueryType

    public fun allocate(arena: Arena): MemorySegment =
        Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

    public companion object {
        @JvmStatic
        public val invokeHandle: MethodHandle =
            MethodHandles.filterReturnValue(
                MethodHandles.lookup().unreflect(WGPUProcQuerySetGetType::class.java.methods.find {
                    it.name == "invoke"
                }
                ), WGPUQueryType.toInt)

        @JvmStatic
        public val fd: FunctionDescriptor = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            `$RuntimeHelper`.POINTER,
        )
    }
}
