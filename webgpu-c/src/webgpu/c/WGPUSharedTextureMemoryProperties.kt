// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c

import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.VarHandle

@JvmInline
public value class WGPUSharedTextureMemoryProperties(
    public val `$mem`: MemorySegment,
) {
    public var nextInChain: Pointer<WGPUChainedStructOut>
        get() = nextInChainHandle.get(this.`$mem`, 0L) as
                MemorySegment
        set(`value`) {
            nextInChainHandle.set(this.`$mem`, 0L, value)
        }

    public var usage: WGPUTextureUsage
        get() = (usageHandle.get(this.`$mem`, 0L) as Long).toULong()
        set(`value`) {
            usageHandle.set(this.`$mem`, 0L, value.toLong())
        }

    public var size: WGPUExtent3D
        get() = WGPUExtent3D(
            sizeHandle.invokeExact(this.`$mem`, 0L)
                    as MemorySegment
        )
        set(`value`) {
            MemorySegment.copy(value.`$mem`, 0L, this.size.`$mem`, 0L, WGPUExtent3D.layout.byteSize())
        }

    public var format: WGPUTextureFormat
        get() =
            WGPUTextureFormat.fromInt(
                formatHandle.get(
                    this.`$mem`,
                    0L
                ) as Int
            )
        set(`value`) {
            formatHandle.set(this.`$mem`, 0L, value.value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("nextInChain"),
            ValueLayout.JAVA_LONG.withName("usage"),
            WGPUExtent3D.layout.withName("size"),
            ValueLayout.JAVA_INT.withName("format"),
        ).withName("WGPUSharedTextureMemoryProperties")

        @JvmField
        public val nextInChainHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("nextInChain"))

        @JvmField
        public val usageHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("usage"))

        @JvmField
        public val sizeHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("size"))

        @JvmField
        public val formatHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("format"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUSharedTextureMemoryProperties =
            WGPUSharedTextureMemoryProperties(alloc.allocate(layout))
    }
}
