// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c

import java.lang.foreign.Arena
import java.lang.foreign.MemoryLayout
import java.lang.foreign.MemorySegment
import java.lang.foreign.SegmentAllocator
import java.lang.foreign.StructLayout
import java.lang.foreign.ValueLayout
import java.lang.invoke.VarHandle
import kotlin.Boolean
import kotlin.Int
import kotlin.UInt
import kotlin.jvm.JvmField
import kotlin.jvm.JvmInline
import kotlin.jvm.JvmStatic

@JvmInline
public value class WGPUExtent3D(
    public val `$mem`: MemorySegment,
) {
    public var width: UInt
        get() = (WGPUExtent3D.widthHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            WGPUExtent3D.widthHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var height: UInt
        get() = (WGPUExtent3D.heightHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            WGPUExtent3D.heightHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var depthOrArrayLayers: UInt
        get() = (WGPUExtent3D.depthOrArrayLayersHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            WGPUExtent3D.depthOrArrayLayersHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPUExtent3D.layout)
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
            WGPUExtent3D(alloc.allocate(WGPUExtent3D.layout))
    }
}
