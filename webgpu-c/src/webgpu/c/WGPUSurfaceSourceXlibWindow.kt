// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c

import java.lang.foreign.Arena
import java.lang.foreign.MemoryLayout
import java.lang.foreign.MemorySegment
import java.lang.foreign.SegmentAllocator
import java.lang.foreign.StructLayout
import java.lang.foreign.ValueLayout
import java.lang.invoke.MethodHandle
import java.lang.invoke.VarHandle
import kotlin.Boolean
import kotlin.Long
import kotlin.ULong
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmInline
import kotlin.jvm.JvmStatic

@JvmInline
public value class WGPUSurfaceSourceXlibWindow(
    public val `$mem`: MemorySegment,
) {
    public var chain: WGPUChainedStruct
        get() = WGPUChainedStruct(
            WGPUSurfaceSourceXlibWindow.chainHandle.invokeExact(this.`$mem`, 0L)
                    as MemorySegment
        )
        set(`value`) {
            MemorySegment.copy(
                value.`$mem`, 0L, this.chain.`$mem`, 0L,
                WGPUChainedStruct.layout.byteSize()
            )
        }

    public var display: Pointer<Unit>
        get() = WGPUSurfaceSourceXlibWindow.displayHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUSurfaceSourceXlibWindow.displayHandle.set(this.`$mem`, 0L, value)
        }

    public var window: ULong
        get() = (WGPUSurfaceSourceXlibWindow.windowHandle.get(this.`$mem`, 0L) as Long).toULong()
        set(`value`) {
            WGPUSurfaceSourceXlibWindow.windowHandle.set(this.`$mem`, 0L, value.toLong())
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPUSurfaceSourceXlibWindow.layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            WGPUChainedStruct.layout.withName("chain"),
            `$RuntimeHelper`.POINTER.withName("display"),
            ValueLayout.JAVA_LONG.withName("window"),
        ).withName("WGPUSurfaceSourceXlibWindow")

        @JvmField
        public val chainHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("chain"))

        @JvmField
        public val displayHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("display"))

        @JvmField
        public val windowHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("window"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUSurfaceSourceXlibWindow =
            WGPUSurfaceSourceXlibWindow(alloc.allocate(WGPUSurfaceSourceXlibWindow.layout))
    }
}
