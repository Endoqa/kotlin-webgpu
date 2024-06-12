package webgpu.callback

import webgpu.*
import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles

public fun interface WGPUProcInstanceWaitAny {
    public fun invoke(
        instance: WGPUInstance,
        futureCount: ULong,
        futures: Pointer<WGPUFutureWaitInfo>,
        timeoutNS: uint64_t,
    ): WGPUWaitStatus

    public fun allocate(arena: Arena): MemorySegment =
        Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

    public companion object {
        @JvmStatic
        public val invokeHandle: MethodHandle =
            MethodHandles.filterReturnValue(
                MethodHandles.lookup().unreflect(WGPUProcInstanceWaitAny::class.java.methods.find {
                    it.name == "invoke"
                }
                ), WGPUWaitStatus.toInt)

        @JvmStatic
        public val fd: FunctionDescriptor = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            `$RuntimeHelper`.POINTER,
            ValueLayout.JAVA_LONG,
            `$RuntimeHelper`.POINTER,
            ValueLayout.JAVA_LONG,
        )
    }
}
