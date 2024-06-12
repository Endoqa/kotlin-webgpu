// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu

import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.VarHandle

@JvmInline
public value class WGPUSharedTextureMemoryDmaBufDescriptor(
    public val `$mem`: MemorySegment,
) {
    public var chain: WGPUChainedStruct
        get() =
            WGPUChainedStruct(
                WGPUSharedTextureMemoryDmaBufDescriptor.chainHandle.invokeExact(
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
            WGPUSharedTextureMemoryDmaBufDescriptor.sizeHandle.invokeExact(
                this.`$mem`,
                0L
            ) as MemorySegment
        )
        set(`value`) {
            MemorySegment.copy(value.`$mem`, 0L, this.size.`$mem`, 0L, WGPUExtent3D.layout.byteSize())
        }

    public var drmFormat: uint32_t
        get() = (WGPUSharedTextureMemoryDmaBufDescriptor.drmFormatHandle.get(this.`$mem`, 0L) as
                Int).toUInt()
        set(`value`) {
            WGPUSharedTextureMemoryDmaBufDescriptor.drmFormatHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var drmModifier: uint64_t
        get() = (WGPUSharedTextureMemoryDmaBufDescriptor.drmModifierHandle.get(this.`$mem`, 0L) as
                Long).toULong()
        set(`value`) {
            WGPUSharedTextureMemoryDmaBufDescriptor.drmModifierHandle.set(this.`$mem`, 0L, value.toLong())
        }

    public var planeCount: ULong
        get() = (WGPUSharedTextureMemoryDmaBufDescriptor.planeCountHandle.get(this.`$mem`, 0L) as
                Long).toULong()
        set(`value`) {
            WGPUSharedTextureMemoryDmaBufDescriptor.planeCountHandle.set(this.`$mem`, 0L, value.toLong())
        }

    public var planes: Pointer<WGPUSharedTextureMemoryDmaBufPlane>
        get() = WGPUSharedTextureMemoryDmaBufDescriptor.planesHandle.get(this.`$mem`, 0L) as
                MemorySegment
        set(`value`) {
            WGPUSharedTextureMemoryDmaBufDescriptor.planesHandle.set(this.`$mem`, 0L, value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPUSharedTextureMemoryDmaBufDescriptor.layout)
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
            WGPUSharedTextureMemoryDmaBufDescriptor(alloc.allocate(WGPUSharedTextureMemoryDmaBufDescriptor.layout))
    }
}