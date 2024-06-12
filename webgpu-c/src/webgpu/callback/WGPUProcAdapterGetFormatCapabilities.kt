package webgpu.callback

import webgpu.*
import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles

public fun interface WGPUProcAdapterGetFormatCapabilities {
    public fun invoke(
        adapter: WGPUAdapter,
        format: WGPUTextureFormat,
        capabilities: Pointer<WGPUFormatCapabilities>,
    ): WGPUStatus

    public fun allocate(arena: Arena): MemorySegment =
        Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

    public companion object {
        @JvmStatic
        public val invokeHandle: MethodHandle =
            MethodHandles.filterArguments(
                MethodHandles.filterReturnValue(
                    MethodHandles.lookup().unreflect(WGPUProcAdapterGetFormatCapabilities::class.java.methods.find {
                        it.name == "invoke"
                    }
                    ), WGPUStatus.toInt),
                1, null, WGPUTextureFormat.fromInt, null,
            )

        @JvmStatic
        public val fd: FunctionDescriptor = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            `$RuntimeHelper`.POINTER,
            ValueLayout.JAVA_INT,
            `$RuntimeHelper`.POINTER,
        )
    }
}
