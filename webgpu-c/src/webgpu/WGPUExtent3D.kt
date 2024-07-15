// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu

import java.lang.foreign.*
import java.lang.invoke.VarHandle

@JvmInline
public value class WGPUExtent3D(
    public val `$mem`: MemorySegment,
) {
    public var width: uint32_t
        get() = (widthHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            widthHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var height: uint32_t
        get() = (heightHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            heightHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var depthOrArrayLayers: uint32_t
        get() = (depthOrArrayLayersHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            depthOrArrayLayersHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            ValueLayout.JAVA_INT.withName("width"),
            ValueLayout.JAVA_INT.withName("height"),
            ValueLayout.JAVA_INT.withName("depthOrArrayLayers"),
        ).withName("WGPUExtent3D")

        @JvmField
        public val widthHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("width"))

        @JvmField
        public val heightHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("height"))

        @JvmField
        public val depthOrArrayLayersHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("depthOrArrayLayers"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUExtent3D =
            WGPUExtent3D(alloc.allocate(layout))
    }
}
