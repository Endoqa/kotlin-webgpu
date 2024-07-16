// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c

import java.lang.foreign.*
import java.lang.invoke.VarHandle

@JvmInline
public value class WGPUBindGroupDescriptor(
    public val `$mem`: MemorySegment,
) {
    public var nextInChain: Pointer<WGPUChainedStruct>
        get() = nextInChainHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            nextInChainHandle.set(this.`$mem`, 0L, value)
        }

    public var label: Pointer<Byte>
        get() = labelHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            labelHandle.set(this.`$mem`, 0L, value)
        }

    public var layout: WGPUBindGroupLayout
        get() = layoutHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            layoutHandle.set(this.`$mem`, 0L, value)
        }

    public var entryCount: ULong
        get() = (entryCountHandle.get(this.`$mem`, 0L) as Long).toULong()
        set(`value`) {
            entryCountHandle.set(this.`$mem`, 0L, value.toLong())
        }

    public var entries: Pointer<WGPUBindGroupEntry>
        get() = entriesHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            entriesHandle.set(this.`$mem`, 0L, value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPUBindGroupDescriptor.layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("nextInChain"),
            `$RuntimeHelper`.POINTER.withName("label"),
            `$RuntimeHelper`.POINTER.withName("layout"),
            ValueLayout.JAVA_LONG.withName("entryCount"),
            `$RuntimeHelper`.POINTER.withName("entries"),
        ).withName("WGPUBindGroupDescriptor")

        @JvmField
        public val nextInChainHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("nextInChain"))

        @JvmField
        public val labelHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("label"))

        @JvmField
        public val layoutHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("layout"))

        @JvmField
        public val entryCountHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("entryCount"))

        @JvmField
        public val entriesHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("entries"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUBindGroupDescriptor =
            WGPUBindGroupDescriptor(alloc.allocate(layout))
    }
}