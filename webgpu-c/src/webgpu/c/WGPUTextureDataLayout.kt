// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c

import java.lang.foreign.*
import java.lang.invoke.VarHandle

@JvmInline
public value class WGPUTextureDataLayout(
    public val `$mem`: MemorySegment,
) {
    public var nextInChain: Pointer<WGPUChainedStruct>
        get() = nextInChainHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            nextInChainHandle.set(this.`$mem`, 0L, value)
        }

    public var offset: uint64_t
        get() = (offsetHandle.get(this.`$mem`, 0L) as Long).toULong()
        set(`value`) {
            offsetHandle.set(this.`$mem`, 0L, value.toLong())
        }

    public var bytesPerRow: uint32_t
        get() = (bytesPerRowHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            bytesPerRowHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var rowsPerImage: uint32_t
        get() = (rowsPerImageHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            rowsPerImageHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("nextInChain"),
            ValueLayout.JAVA_LONG.withName("offset"),
            ValueLayout.JAVA_INT.withName("bytesPerRow"),
            ValueLayout.JAVA_INT.withName("rowsPerImage"),
        ).withName("WGPUTextureDataLayout")

        @JvmField
        public val nextInChainHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("nextInChain"))

        @JvmField
        public val offsetHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("offset"))

        @JvmField
        public val bytesPerRowHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("bytesPerRow"))

        @JvmField
        public val rowsPerImageHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("rowsPerImage"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUTextureDataLayout =
            WGPUTextureDataLayout(alloc.allocate(layout))
    }
}
