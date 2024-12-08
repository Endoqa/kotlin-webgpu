// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu

import java.lang.foreign.*
import java.lang.invoke.VarHandle

/**
 * TODO
 */
@JvmInline
public value class WGPUColor(
    public val `$mem`: MemorySegment,
) {
    /**
     * TODO
     */
    public var r: Double
        get() = rHandle.get(this.`$mem`, 0L) as Double
        set(`value`) {
            rHandle.set(this.`$mem`, 0L, value)
        }

    /**
     * TODO
     */
    public var g: Double
        get() = gHandle.get(this.`$mem`, 0L) as Double
        set(`value`) {
            gHandle.set(this.`$mem`, 0L, value)
        }

    /**
     * TODO
     */
    public var b: Double
        get() = bHandle.get(this.`$mem`, 0L) as Double
        set(`value`) {
            bHandle.set(this.`$mem`, 0L, value)
        }

    /**
     * TODO
     */
    public var a: Double
        get() = aHandle.get(this.`$mem`, 0L) as Double
        set(`value`) {
            aHandle.set(this.`$mem`, 0L, value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            ValueLayout.JAVA_DOUBLE.withName("r"),
            ValueLayout.JAVA_DOUBLE.withName("g"),
            ValueLayout.JAVA_DOUBLE.withName("b"),
            ValueLayout.JAVA_DOUBLE.withName("a"),
        ).withName("WGPUColor")

        @JvmField
        public val rHandle: VarHandle = layout.varHandle(MemoryLayout.PathElement.groupElement("r"))

        @JvmField
        public val gHandle: VarHandle = layout.varHandle(MemoryLayout.PathElement.groupElement("g"))

        @JvmField
        public val bHandle: VarHandle = layout.varHandle(MemoryLayout.PathElement.groupElement("b"))

        @JvmField
        public val aHandle: VarHandle = layout.varHandle(MemoryLayout.PathElement.groupElement("a"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUColor = WGPUColor(alloc.allocate(layout))
    }
}
