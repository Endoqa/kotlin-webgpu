// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu

import java.lang.foreign.*
import java.lang.invoke.VarHandle

/**
 * TODO
 */
@JvmInline
public value class WGPUVertexAttribute(
    public val `$mem`: MemorySegment,
) {
    public var nextInChain: Pointer<WGPUChainedStruct>
        get() = nextInChainHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            nextInChainHandle.set(this.`$mem`, 0L, value)
        }

    /**
     * TODO
     */
    public var format: WGPUVertexFormat
        get() = WGPUVertexFormat.fromInt(formatHandle.get(this.`$mem`, 0L) as Int)
        set(`value`) {
            formatHandle.set(this.`$mem`, 0L, value.value)
        }

    /**
     * TODO
     */
    public var offset: ULong
        get() = (offsetHandle.get(this.`$mem`, 0L) as Long).toULong()
        set(`value`) {
            offsetHandle.set(this.`$mem`, 0L, value.toLong())
        }

    /**
     * TODO
     */
    public var shaderLocation: UInt
        get() = (shaderLocationHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            shaderLocationHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("nextInChain"),
            ValueLayout.JAVA_INT.withName("format"),
            MemoryLayout.paddingLayout(4),
            ValueLayout.JAVA_LONG.withName("offset"),
            ValueLayout.JAVA_INT.withName("shaderLocation"),
            MemoryLayout.paddingLayout(4),
        ).withName("WGPUVertexAttribute")

        @JvmField
        public val nextInChainHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("nextInChain"))

        @JvmField
        public val formatHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("format"))

        @JvmField
        public val offsetHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("offset"))

        @JvmField
        public val shaderLocationHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("shaderLocation"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUVertexAttribute =
            WGPUVertexAttribute(alloc.allocate(layout))
    }
}
