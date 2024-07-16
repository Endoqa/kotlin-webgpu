// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c

import java.lang.foreign.*
import java.lang.invoke.VarHandle

@JvmInline
public value class WGPUSharedTextureMemoryDmaBufPlane(
    public val `$mem`: MemorySegment,
) {
    public var fd: Int
        get() = fdHandle.get(this.`$mem`, 0L) as Int
        set(`value`) {
            fdHandle.set(this.`$mem`, 0L, value)
        }

    public var offset: uint64_t
        get() = (offsetHandle.get(this.`$mem`, 0L) as Long).toULong()
        set(`value`) {
            offsetHandle.set(this.`$mem`, 0L, value.toLong())
        }

    public var stride: uint32_t
        get() = (strideHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            strideHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            ValueLayout.JAVA_INT.withName("fd"),
            MemoryLayout.paddingLayout(4),
            ValueLayout.JAVA_LONG.withName("offset"),
            ValueLayout.JAVA_INT.withName("stride"),
            MemoryLayout.paddingLayout(4),
        ).withName("WGPUSharedTextureMemoryDmaBufPlane")

        @JvmField
        public val fdHandle: VarHandle = layout.varHandle(MemoryLayout.PathElement.groupElement("fd"))

        @JvmField
        public val offsetHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("offset"))

        @JvmField
        public val strideHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("stride"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUSharedTextureMemoryDmaBufPlane =
            WGPUSharedTextureMemoryDmaBufPlane(alloc.allocate(layout))
    }
}