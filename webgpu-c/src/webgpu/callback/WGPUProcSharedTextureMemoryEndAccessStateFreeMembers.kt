package webgpu.callback

import webgpu.WGPUSharedTextureMemoryEndAccessState
import java.lang.foreign.Arena
import java.lang.foreign.FunctionDescriptor
import java.lang.foreign.Linker
import java.lang.foreign.MemorySegment
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles

public fun interface WGPUProcSharedTextureMemoryEndAccessStateFreeMembers {
    public fun invoke(`value`: WGPUSharedTextureMemoryEndAccessState)

    public fun allocate(arena: Arena): MemorySegment =
        Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

    public companion object {
        @JvmStatic
        public val invokeHandle: MethodHandle =
            MethodHandles.lookup()
                .unreflect(WGPUProcSharedTextureMemoryEndAccessStateFreeMembers::class.java.methods.find {
                    it.name == "invoke"
                }
                )

        @JvmStatic
        public val fd: FunctionDescriptor = FunctionDescriptor.ofVoid(
            WGPUSharedTextureMemoryEndAccessState.layout,
        )
    }
}
