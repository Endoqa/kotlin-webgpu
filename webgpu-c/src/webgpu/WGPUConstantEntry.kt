// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu

import java.lang.foreign.*
import java.lang.invoke.VarHandle

@JvmInline
public value class WGPUConstantEntry(
    public val `$mem`: MemorySegment,
) {
    public var nextInChain: Pointer<WGPUChainedStruct>
        get() = WGPUConstantEntry.nextInChainHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUConstantEntry.nextInChainHandle.set(this.`$mem`, 0L, value)
        }

    public var key: Pointer<Byte>
        get() = WGPUConstantEntry.keyHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUConstantEntry.keyHandle.set(this.`$mem`, 0L, value)
        }

    public var `value`: Double
        get() = WGPUConstantEntry.valueHandle.get(this.`$mem`, 0L) as Double
        set(`value`) {
            WGPUConstantEntry.valueHandle.set(this.`$mem`, 0L, value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPUConstantEntry.layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("nextInChain"),
            `$RuntimeHelper`.POINTER.withName("key"),
            ValueLayout.JAVA_DOUBLE.withName("value"),
        ).withName("WGPUConstantEntry")

        @JvmField
        public val nextInChainHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("nextInChain"))

        @JvmField
        public val keyHandle: VarHandle = layout.varHandle(MemoryLayout.PathElement.groupElement("key"))

        @JvmField
        public val valueHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("value"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUConstantEntry =
            WGPUConstantEntry(alloc.allocate(WGPUConstantEntry.layout))
    }
}
