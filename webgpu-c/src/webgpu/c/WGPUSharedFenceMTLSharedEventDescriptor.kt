// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c

import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.VarHandle

@JvmInline
public value class WGPUSharedFenceMTLSharedEventDescriptor(
    public val `$mem`: MemorySegment,
) {
    public var chain: WGPUChainedStruct
        get() =
            WGPUChainedStruct(
                chainHandle.invokeExact(
                    this.`$mem`,
                    0L
                ) as MemorySegment
            )
        set(`value`) {
            MemorySegment.copy(
                value.`$mem`, 0L, this.chain.`$mem`, 0L,
                WGPUChainedStruct.layout.byteSize()
            )
        }

    public var sharedEvent: Pointer<Unit>
        get() = sharedEventHandle.get(this.`$mem`, 0L) as
                MemorySegment
        set(`value`) {
            sharedEventHandle.set(this.`$mem`, 0L, value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            WGPUChainedStruct.layout.withName("chain"),
            `$RuntimeHelper`.POINTER.withName("sharedEvent"),
        ).withName("WGPUSharedFenceMTLSharedEventDescriptor")

        @JvmField
        public val chainHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("chain"))

        @JvmField
        public val sharedEventHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("sharedEvent"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUSharedFenceMTLSharedEventDescriptor =
            WGPUSharedFenceMTLSharedEventDescriptor(alloc.allocate(layout))
    }
}