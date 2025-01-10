// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu

import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.VarHandle

/**
 * Chained in [WGPUSurfaceDescriptor] to make an [WGPUSurface] wrapping an [Xlib](https://www.x.org/releases/current/doc/libX11/libX11/libX11.html) [Window].
 */
@JvmInline
public value class WGPUSurfaceSourceXlibWindow(
    public val `$mem`: MemorySegment,
) {
    public var chain: WGPUChainedStruct
        get() = WGPUChainedStruct(chainHandle.invokeExact(this.`$mem`, 0L) as MemorySegment)
        set(`value`) {
            MemorySegment.copy(value.`$mem`, 0L, this.chain.`$mem`, 0L, WGPUChainedStruct.layout.byteSize())
        }

    /**
     * A pointer to the [[Display]](https://www.x.org/releases/current/doc/libX11/libX11/libX11.html#Opening_the_Display) connected to the X server.
     */
    public var display: Pointer<Unit>
        get() = displayHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            displayHandle.set(this.`$mem`, 0L, value)
        }

    /**
     * The [[Window]](https://www.x.org/releases/current/doc/libX11/libX11/libX11.html#Creating_Windows) that will be wrapped by the [WGPUSurface].
     */
    public var window: ULong
        get() = (windowHandle.get(this.`$mem`, 0L) as Long).toULong()
        set(`value`) {
            windowHandle.set(this.`$mem`, 0L, value.toLong())
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(layout)
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
            WGPUSurfaceSourceXlibWindow(alloc.allocate(layout))
    }
}
