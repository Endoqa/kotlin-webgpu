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
public value class WGPUSurfaceSourceWindowsHWND(
    public val `$mem`: MemorySegment,
) {
    public var chain: WGPUChainedStruct
        get() = WGPUChainedStruct(
            WGPUSurfaceSourceWindowsHWND.chainHandle.invokeExact(this.`$mem`, 0L)
                    as MemorySegment
        )
        set(`value`) {
            MemorySegment.copy(
                value.`$mem`, 0L, this.chain.`$mem`, 0L,
                WGPUChainedStruct.layout.byteSize()
            )
        }

    public var hinstance: Pointer<Unit>
        get() = WGPUSurfaceSourceWindowsHWND.hinstanceHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUSurfaceSourceWindowsHWND.hinstanceHandle.set(this.`$mem`, 0L, value)
        }

    public var hwnd: Pointer<Unit>
        get() = WGPUSurfaceSourceWindowsHWND.hwndHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUSurfaceSourceWindowsHWND.hwndHandle.set(this.`$mem`, 0L, value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPUSurfaceSourceWindowsHWND.layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            WGPUChainedStruct.layout.withName("chain"),
            `$RuntimeHelper`.POINTER.withName("hinstance"),
            `$RuntimeHelper`.POINTER.withName("hwnd"),
        ).withName("WGPUSurfaceSourceWindowsHWND")

        @JvmField
        public val chainHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("chain"))

        @JvmField
        public val hinstanceHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("hinstance"))

        @JvmField
        public val hwndHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("hwnd"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUSurfaceSourceWindowsHWND =
            WGPUSurfaceSourceWindowsHWND(alloc.allocate(WGPUSurfaceSourceWindowsHWND.layout))
    }
}
