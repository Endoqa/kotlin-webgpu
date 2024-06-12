// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu

import java.lang.foreign.*
import java.lang.invoke.VarHandle

@JvmInline
public value class WGPUOrigin3D(
    public val `$mem`: MemorySegment,
) {
    public var x: uint32_t
        get() = (WGPUOrigin3D.xHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            WGPUOrigin3D.xHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var y: uint32_t
        get() = (WGPUOrigin3D.yHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            WGPUOrigin3D.yHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var z: uint32_t
        get() = (WGPUOrigin3D.zHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            WGPUOrigin3D.zHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPUOrigin3D.layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            ValueLayout.JAVA_INT.withName("x"),
            ValueLayout.JAVA_INT.withName("y"),
            ValueLayout.JAVA_INT.withName("z"),
        ).withName("WGPUOrigin3D")

        @JvmField
        public val xHandle: VarHandle = layout.varHandle(MemoryLayout.PathElement.groupElement("x"))

        @JvmField
        public val yHandle: VarHandle = layout.varHandle(MemoryLayout.PathElement.groupElement("y"))

        @JvmField
        public val zHandle: VarHandle = layout.varHandle(MemoryLayout.PathElement.groupElement("z"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUOrigin3D =
            WGPUOrigin3D(alloc.allocate(WGPUOrigin3D.layout))
    }
}
