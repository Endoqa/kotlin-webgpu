// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu

import java.lang.foreign.*
import java.lang.invoke.VarHandle

@JvmInline
public value class WGPUOrigin2D(
    public val `$mem`: MemorySegment,
) {
    public var x: uint32_t
        get() = (WGPUOrigin2D.xHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            WGPUOrigin2D.xHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var y: uint32_t
        get() = (WGPUOrigin2D.yHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            WGPUOrigin2D.yHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPUOrigin2D.layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            ValueLayout.JAVA_INT.withName("x"),
            ValueLayout.JAVA_INT.withName("y"),
        ).withName("WGPUOrigin2D")

        @JvmField
        public val xHandle: VarHandle = layout.varHandle(MemoryLayout.PathElement.groupElement("x"))

        @JvmField
        public val yHandle: VarHandle = layout.varHandle(MemoryLayout.PathElement.groupElement("y"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUOrigin2D =
            WGPUOrigin2D(alloc.allocate(WGPUOrigin2D.layout))
    }
}
