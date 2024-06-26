// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu

import java.lang.foreign.*
import java.lang.invoke.VarHandle

@JvmInline
public value class WGPUSharedTextureMemoryBeginAccessDescriptor(
    public val `$mem`: MemorySegment,
) {
    public var nextInChain: Pointer<WGPUChainedStruct>
        get() = WGPUSharedTextureMemoryBeginAccessDescriptor.nextInChainHandle.get(this.`$mem`, 0L) as
                MemorySegment
        set(`value`) {
            WGPUSharedTextureMemoryBeginAccessDescriptor.nextInChainHandle.set(this.`$mem`, 0L, value)
        }

    public var concurrentRead: WGPUBool
        get() = (WGPUSharedTextureMemoryBeginAccessDescriptor.concurrentReadHandle.get(this.`$mem`, 0L)
                as Int).toUInt()
        set(`value`) {
            WGPUSharedTextureMemoryBeginAccessDescriptor.concurrentReadHandle.set(
                this.`$mem`,
                0L, value.toInt()
            )
        }

    public var initialized: WGPUBool
        get() = (WGPUSharedTextureMemoryBeginAccessDescriptor.initializedHandle.get(this.`$mem`, 0L) as
                Int).toUInt()
        set(`value`) {
            WGPUSharedTextureMemoryBeginAccessDescriptor.initializedHandle.set(
                this.`$mem`,
                0L, value.toInt()
            )
        }

    public var fenceCount: ULong
        get() = (WGPUSharedTextureMemoryBeginAccessDescriptor.fenceCountHandle.get(this.`$mem`, 0L) as
                Long).toULong()
        set(`value`) {
            WGPUSharedTextureMemoryBeginAccessDescriptor.fenceCountHandle.set(
                this.`$mem`,
                0L, value.toLong()
            )
        }

    public var fences: Pointer<WGPUSharedFence>
        get() = WGPUSharedTextureMemoryBeginAccessDescriptor.fencesHandle.get(this.`$mem`, 0L) as
                MemorySegment
        set(`value`) {
            WGPUSharedTextureMemoryBeginAccessDescriptor.fencesHandle.set(this.`$mem`, 0L, value)
        }

    public var signaledValues: Pointer<uint64_t>
        get() = WGPUSharedTextureMemoryBeginAccessDescriptor.signaledValuesHandle.get(this.`$mem`, 0L)
                as MemorySegment
        set(`value`) {
            WGPUSharedTextureMemoryBeginAccessDescriptor.signaledValuesHandle.set(this.`$mem`, 0L, value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPUSharedTextureMemoryBeginAccessDescriptor.layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("nextInChain"),
            ValueLayout.JAVA_INT.withName("concurrentRead"),
            ValueLayout.JAVA_INT.withName("initialized"),
            ValueLayout.JAVA_LONG.withName("fenceCount"),
            `$RuntimeHelper`.POINTER.withName("fences"),
            `$RuntimeHelper`.POINTER.withName("signaledValues"),
        ).withName("WGPUSharedTextureMemoryBeginAccessDescriptor")

        @JvmField
        public val nextInChainHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("nextInChain"))

        @JvmField
        public val concurrentReadHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("concurrentRead"))

        @JvmField
        public val initializedHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("initialized"))

        @JvmField
        public val fenceCountHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("fenceCount"))

        @JvmField
        public val fencesHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("fences"))

        @JvmField
        public val signaledValuesHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("signaledValues"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUSharedTextureMemoryBeginAccessDescriptor =
            WGPUSharedTextureMemoryBeginAccessDescriptor(alloc.allocate(WGPUSharedTextureMemoryBeginAccessDescriptor.layout))
    }
}
