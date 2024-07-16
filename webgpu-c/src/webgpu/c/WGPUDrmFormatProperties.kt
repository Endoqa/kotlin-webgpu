// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c

import java.lang.foreign.*
import java.lang.invoke.VarHandle

@JvmInline
public value class WGPUDrmFormatProperties(
    public val `$mem`: MemorySegment,
) {
    public var modifier: uint64_t
        get() = (modifierHandle.get(this.`$mem`, 0L) as Long).toULong()
        set(`value`) {
            modifierHandle.set(this.`$mem`, 0L, value.toLong())
        }

    public var modifierPlaneCount: uint32_t
        get() = (modifierPlaneCountHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            modifierPlaneCountHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            ValueLayout.JAVA_LONG.withName("modifier"),
            ValueLayout.JAVA_INT.withName("modifierPlaneCount"),
            MemoryLayout.paddingLayout(4),
        ).withName("WGPUDrmFormatProperties")

        @JvmField
        public val modifierHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("modifier"))

        @JvmField
        public val modifierPlaneCountHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("modifierPlaneCount"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUDrmFormatProperties =
            WGPUDrmFormatProperties(alloc.allocate(layout))
    }
}