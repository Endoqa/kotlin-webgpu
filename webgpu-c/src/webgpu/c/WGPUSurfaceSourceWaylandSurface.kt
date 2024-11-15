// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c

import java.lang.foreign.Arena
import java.lang.foreign.MemoryLayout
import java.lang.foreign.MemorySegment
import java.lang.foreign.SegmentAllocator
import java.lang.foreign.StructLayout
import java.lang.invoke.MethodHandle
import java.lang.invoke.VarHandle
import kotlin.Boolean
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmInline
import kotlin.jvm.JvmStatic

@JvmInline
public value class WGPUSurfaceSourceWaylandSurface(
    public val `$mem`: MemorySegment,
) {
    public var chain: WGPUChainedStruct
        get() = WGPUChainedStruct(
            WGPUSurfaceSourceWaylandSurface.chainHandle.invokeExact(
                this.`$mem`,
                0L
            ) as MemorySegment
        )
        set(`value`) {
            MemorySegment.copy(
                value.`$mem`, 0L, this.chain.`$mem`, 0L,
                WGPUChainedStruct.layout.byteSize()
            )
        }

    public var display: Pointer<Unit>
        get() = WGPUSurfaceSourceWaylandSurface.displayHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUSurfaceSourceWaylandSurface.displayHandle.set(this.`$mem`, 0L, value)
        }

    public var surface: Pointer<Unit>
        get() = WGPUSurfaceSourceWaylandSurface.surfaceHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUSurfaceSourceWaylandSurface.surfaceHandle.set(this.`$mem`, 0L, value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPUSurfaceSourceWaylandSurface.layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            WGPUChainedStruct.layout.withName("chain"),
            `$RuntimeHelper`.POINTER.withName("display"),
            `$RuntimeHelper`.POINTER.withName("surface"),
        ).withName("WGPUSurfaceSourceWaylandSurface")

        @JvmField
        public val chainHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("chain"))

        @JvmField
        public val displayHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("display"))

        @JvmField
        public val surfaceHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("surface"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUSurfaceSourceWaylandSurface =
            WGPUSurfaceSourceWaylandSurface(alloc.allocate(WGPUSurfaceSourceWaylandSurface.layout))
    }
}
