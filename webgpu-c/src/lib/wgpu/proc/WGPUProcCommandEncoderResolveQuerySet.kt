// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu.proc

import lib.wgpu.`$RuntimeHelper`
import lib.wgpu.WGPUBuffer
import lib.wgpu.WGPUCommandEncoder
import lib.wgpu.WGPUQuerySet
import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles

public fun interface WGPUProcCommandEncoderResolveQuerySet {
    public fun invoke(
        commandEncoder: WGPUCommandEncoder,
        querySet: WGPUQuerySet,
        firstQuery: UInt,
        queryCount: UInt,
        destination: WGPUBuffer,
        destinationOffset: ULong,
    )

    public fun allocate(arena: Arena): MemorySegment =
        Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

    public companion object {
        @JvmStatic
        public val invokeHandle: MethodHandle =
            MethodHandles.lookup().unreflect(WGPUProcCommandEncoderResolveQuerySet::class.java.methods.find {
                it.name == "invoke"
            }
            )

        @JvmStatic
        public val fd: FunctionDescriptor = FunctionDescriptor.ofVoid(
            `$RuntimeHelper`.POINTER,
            `$RuntimeHelper`.POINTER,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            `$RuntimeHelper`.POINTER,
            ValueLayout.JAVA_LONG,
        )
    }
}