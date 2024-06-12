// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu

import java.lang.foreign.*
import java.lang.invoke.VarHandle

@JvmInline
public value class WGPUBufferDescriptor(
    public val `$mem`: MemorySegment,
) {
    public var nextInChain: Pointer<WGPUChainedStruct>
        get() = WGPUBufferDescriptor.nextInChainHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUBufferDescriptor.nextInChainHandle.set(this.`$mem`, 0L, value)
        }

    public var label: Pointer<Byte>
        get() = WGPUBufferDescriptor.labelHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUBufferDescriptor.labelHandle.set(this.`$mem`, 0L, value)
        }

    public var usage: WGPUBufferUsageFlags
        get() = (WGPUBufferDescriptor.usageHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            WGPUBufferDescriptor.usageHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var size: uint64_t
        get() = (WGPUBufferDescriptor.sizeHandle.get(this.`$mem`, 0L) as Long).toULong()
        set(`value`) {
            WGPUBufferDescriptor.sizeHandle.set(this.`$mem`, 0L, value.toLong())
        }

    public var mappedAtCreation: WGPUBool
        get() = (WGPUBufferDescriptor.mappedAtCreationHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            WGPUBufferDescriptor.mappedAtCreationHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPUBufferDescriptor.layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("nextInChain"),
            `$RuntimeHelper`.POINTER.withName("label"),
            ValueLayout.JAVA_INT.withName("usage"),
            java.lang.foreign.MemoryLayout.paddingLayout(4),
            ValueLayout.JAVA_LONG.withName("size"),
            ValueLayout.JAVA_INT.withName("mappedAtCreation"),
            java.lang.foreign.MemoryLayout.paddingLayout(4),
        ).withName("WGPUBufferDescriptor")

        @JvmField
        public val nextInChainHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("nextInChain"))

        @JvmField
        public val labelHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("label"))

        @JvmField
        public val usageHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("usage"))

        @JvmField
        public val sizeHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("size"))

        @JvmField
        public val mappedAtCreationHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("mappedAtCreation"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUBufferDescriptor =
            WGPUBufferDescriptor(alloc.allocate(WGPUBufferDescriptor.layout))
    }
}