// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu

import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.VarHandle

/**
 * TODO
 */
@JvmInline
public value class WGPUQueueDescriptor(
    public val `$mem`: MemorySegment,
) {
    public var nextInChain: Pointer<WGPUChainedStruct>
        get() = nextInChainHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            nextInChainHandle.set(this.`$mem`, 0L, value)
        }

    /**
     * TODO
     */
    public var label: WGPUStringView
        get() = WGPUStringView(labelHandle.invokeExact(this.`$mem`, 0L) as MemorySegment)
        set(`value`) {
            MemorySegment.copy(value.`$mem`, 0L, this.label.`$mem`, 0L, WGPUStringView.layout.byteSize())
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("nextInChain"),
            WGPUStringView.layout.withName("label"),
        ).withName("WGPUQueueDescriptor")

        @JvmField
        public val nextInChainHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("nextInChain"))

        @JvmField
        public val labelHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("label"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUQueueDescriptor =
            WGPUQueueDescriptor(alloc.allocate(layout))
    }
}
