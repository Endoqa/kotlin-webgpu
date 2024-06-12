// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu

import java.lang.foreign.*
import java.lang.invoke.VarHandle

@JvmInline
public value class WGPUSharedBufferMemoryDescriptor(
    public val `$mem`: MemorySegment,
) {
    public var nextInChain: Pointer<WGPUChainedStruct>
        get() = WGPUSharedBufferMemoryDescriptor.nextInChainHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUSharedBufferMemoryDescriptor.nextInChainHandle.set(this.`$mem`, 0L, value)
        }

    public var label: Pointer<Byte>
        get() = WGPUSharedBufferMemoryDescriptor.labelHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUSharedBufferMemoryDescriptor.labelHandle.set(this.`$mem`, 0L, value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPUSharedBufferMemoryDescriptor.layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("nextInChain"),
            `$RuntimeHelper`.POINTER.withName("label"),
        ).withName("WGPUSharedBufferMemoryDescriptor")

        @JvmField
        public val nextInChainHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("nextInChain"))

        @JvmField
        public val labelHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("label"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUSharedBufferMemoryDescriptor =
            WGPUSharedBufferMemoryDescriptor(alloc.allocate(WGPUSharedBufferMemoryDescriptor.layout))
    }
}
