// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu

import java.lang.foreign.*
import java.lang.invoke.VarHandle

@JvmInline
public value class WGPUComputePassTimestampWrites(
    public val `$mem`: MemorySegment,
) {
    public var querySet: WGPUQuerySet
        get() = WGPUComputePassTimestampWrites.querySetHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUComputePassTimestampWrites.querySetHandle.set(this.`$mem`, 0L, value)
        }

    public var beginningOfPassWriteIndex: uint32_t
        get() = (WGPUComputePassTimestampWrites.beginningOfPassWriteIndexHandle.get(this.`$mem`, 0L) as
                Int).toUInt()
        set(`value`) {
            WGPUComputePassTimestampWrites.beginningOfPassWriteIndexHandle.set(
                this.`$mem`,
                0L, value.toInt()
            )
        }

    public var endOfPassWriteIndex: uint32_t
        get() = (WGPUComputePassTimestampWrites.endOfPassWriteIndexHandle.get(this.`$mem`, 0L) as
                Int).toUInt()
        set(`value`) {
            WGPUComputePassTimestampWrites.endOfPassWriteIndexHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPUComputePassTimestampWrites.layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("querySet"),
            ValueLayout.JAVA_INT.withName("beginningOfPassWriteIndex"),
            ValueLayout.JAVA_INT.withName("endOfPassWriteIndex"),
        ).withName("WGPUComputePassTimestampWrites")

        @JvmField
        public val querySetHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("querySet"))

        @JvmField
        public val beginningOfPassWriteIndexHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("beginningOfPassWriteIndex"))

        @JvmField
        public val endOfPassWriteIndexHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("endOfPassWriteIndex"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUComputePassTimestampWrites =
            WGPUComputePassTimestampWrites(alloc.allocate(WGPUComputePassTimestampWrites.layout))
    }
}
