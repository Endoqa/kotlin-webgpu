// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu

import java.lang.foreign.Arena
import java.lang.foreign.MemoryLayout
import java.lang.foreign.MemorySegment
import java.lang.foreign.SegmentAllocator
import java.lang.foreign.StructLayout
import java.lang.foreign.ValueLayout
import java.lang.invoke.MethodHandle
import java.lang.invoke.VarHandle
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.ULong
import kotlin.jvm.JvmField
import kotlin.jvm.JvmInline
import kotlin.jvm.JvmStatic

@JvmInline
public value class WGPUSharedTextureMemoryDmaBufDescriptor(
    public val `$mem`: MemorySegment,
) {
    public var chain: WGPUChainedStruct
        get() =
            WGPUChainedStruct(
                chainHandle.invokeExact(
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

    public var size: WGPUExtent3D
        get() = WGPUExtent3D(
            sizeHandle.invokeExact(
                this.`$mem`,
                0L
            ) as MemorySegment
        )
        set(`value`) {
            MemorySegment.copy(value.`$mem`, 0L, this.size.`$mem`, 0L, WGPUExtent3D.layout.byteSize())
        }

    public var drmFormat: uint32_t
        get() = (drmFormatHandle.get(this.`$mem`, 0L) as
                Int).toUInt()
        set(`value`) {
            drmFormatHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var drmModifier: uint64_t
        get() = (drmModifierHandle.get(this.`$mem`, 0L) as
                Long).toULong()
        set(`value`) {
            drmModifierHandle.set(this.`$mem`, 0L, value.toLong())
        }

    public var planeCount: ULong
        get() = (planeCountHandle.get(this.`$mem`, 0L) as
                Long).toULong()
        set(`value`) {
            planeCountHandle.set(this.`$mem`, 0L, value.toLong())
        }

    public var planes: Pointer<WGPUSharedTextureMemoryDmaBufPlane>
        get() = planesHandle.get(this.`$mem`, 0L) as
                MemorySegment
        set(`value`) {
            planesHandle.set(this.`$mem`, 0L, value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            WGPUChainedStruct.layout.withName("chain"),
            WGPUExtent3D.layout.withName("size"),
            ValueLayout.JAVA_INT.withName("drmFormat"),
            ValueLayout.JAVA_LONG.withName("drmModifier"),
            ValueLayout.JAVA_LONG.withName("planeCount"),
            `$RuntimeHelper`.POINTER.withName("planes"),
        ).withName("WGPUSharedTextureMemoryDmaBufDescriptor")

        @JvmField
        public val chainHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("chain"))

        @JvmField
        public val sizeHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("size"))

        @JvmField
        public val drmFormatHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("drmFormat"))

        @JvmField
        public val drmModifierHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("drmModifier"))

        @JvmField
        public val planeCountHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("planeCount"))

        @JvmField
        public val planesHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("planes"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUSharedTextureMemoryDmaBufDescriptor =
            WGPUSharedTextureMemoryDmaBufDescriptor(alloc.allocate(layout))
    }
}
