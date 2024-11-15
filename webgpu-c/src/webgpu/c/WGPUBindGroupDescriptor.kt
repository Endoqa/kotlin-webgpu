// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c

import java.lang.foreign.Arena
import java.lang.foreign.MemoryLayout
import java.lang.foreign.MemorySegment
import java.lang.foreign.SegmentAllocator
import java.lang.foreign.StructLayout
import java.lang.foreign.ValueLayout
import java.lang.invoke.MethodHandle
import java.lang.invoke.VarHandle
import kotlin.Boolean
import kotlin.Long
import kotlin.ULong
import kotlin.jvm.JvmField
import kotlin.jvm.JvmInline
import kotlin.jvm.JvmStatic

@JvmInline
public value class WGPUBindGroupDescriptor(
    public val `$mem`: MemorySegment,
) {
    public var nextInChain: Pointer<WGPUChainedStruct>
        get() = WGPUBindGroupDescriptor.nextInChainHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUBindGroupDescriptor.nextInChainHandle.set(this.`$mem`, 0L, value)
        }

    public var label: WGPUStringView
        get() = WGPUStringView(
            WGPUBindGroupDescriptor.labelHandle.invokeExact(this.`$mem`, 0L) as
                    MemorySegment
        )
        set(`value`) {
            MemorySegment.copy(value.`$mem`, 0L, this.label.`$mem`, 0L, WGPUStringView.layout.byteSize())
        }

    public var layout: WGPUBindGroupLayout
        get() = WGPUBindGroupDescriptor.layoutHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUBindGroupDescriptor.layoutHandle.set(this.`$mem`, 0L, value)
        }

    public var entryCount: ULong
        get() = (WGPUBindGroupDescriptor.entryCountHandle.get(this.`$mem`, 0L) as Long).toULong()
        set(`value`) {
            WGPUBindGroupDescriptor.entryCountHandle.set(this.`$mem`, 0L, value.toLong())
        }

    public var entries: Pointer<WGPUBindGroupEntry>
        get() = WGPUBindGroupDescriptor.entriesHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUBindGroupDescriptor.entriesHandle.set(this.`$mem`, 0L, value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPUBindGroupDescriptor.layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("nextInChain"),
            WGPUStringView.layout.withName("label"),
            `$RuntimeHelper`.POINTER.withName("layout"),
            ValueLayout.JAVA_LONG.withName("entryCount"),
            `$RuntimeHelper`.POINTER.withName("entries"),
        ).withName("WGPUBindGroupDescriptor")

        @JvmField
        public val nextInChainHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("nextInChain"))

        @JvmField
        public val labelHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("label"))

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
            WGPUBindGroupDescriptor(alloc.allocate(WGPUBindGroupDescriptor.layout))
    }
}
