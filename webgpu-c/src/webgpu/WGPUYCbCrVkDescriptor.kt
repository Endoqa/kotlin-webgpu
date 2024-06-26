// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu

import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.VarHandle

@JvmInline
public value class WGPUYCbCrVkDescriptor(
    public val `$mem`: MemorySegment,
) {
    public var chain: WGPUChainedStruct
        get() = WGPUChainedStruct(
            WGPUYCbCrVkDescriptor.chainHandle.invokeExact(this.`$mem`, 0L) as
                    MemorySegment
        )
        set(`value`) {
            MemorySegment.copy(
                value.`$mem`, 0L, this.chain.`$mem`, 0L,
                WGPUChainedStruct.layout.byteSize()
            )
        }

    public var vkFormat: uint32_t
        get() = (WGPUYCbCrVkDescriptor.vkFormatHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            WGPUYCbCrVkDescriptor.vkFormatHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var vkYCbCrModel: uint32_t
        get() = (WGPUYCbCrVkDescriptor.vkYCbCrModelHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            WGPUYCbCrVkDescriptor.vkYCbCrModelHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var vkYCbCrRange: uint32_t
        get() = (WGPUYCbCrVkDescriptor.vkYCbCrRangeHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            WGPUYCbCrVkDescriptor.vkYCbCrRangeHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var vkComponentSwizzleRed: uint32_t
        get() = (WGPUYCbCrVkDescriptor.vkComponentSwizzleRedHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            WGPUYCbCrVkDescriptor.vkComponentSwizzleRedHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var vkComponentSwizzleGreen: uint32_t
        get() = (WGPUYCbCrVkDescriptor.vkComponentSwizzleGreenHandle.get(this.`$mem`, 0L) as
                Int).toUInt()
        set(`value`) {
            WGPUYCbCrVkDescriptor.vkComponentSwizzleGreenHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var vkComponentSwizzleBlue: uint32_t
        get() = (WGPUYCbCrVkDescriptor.vkComponentSwizzleBlueHandle.get(this.`$mem`, 0L) as
                Int).toUInt()
        set(`value`) {
            WGPUYCbCrVkDescriptor.vkComponentSwizzleBlueHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var vkComponentSwizzleAlpha: uint32_t
        get() = (WGPUYCbCrVkDescriptor.vkComponentSwizzleAlphaHandle.get(this.`$mem`, 0L) as
                Int).toUInt()
        set(`value`) {
            WGPUYCbCrVkDescriptor.vkComponentSwizzleAlphaHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var vkXChromaOffset: uint32_t
        get() = (WGPUYCbCrVkDescriptor.vkXChromaOffsetHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            WGPUYCbCrVkDescriptor.vkXChromaOffsetHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var vkYChromaOffset: uint32_t
        get() = (WGPUYCbCrVkDescriptor.vkYChromaOffsetHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            WGPUYCbCrVkDescriptor.vkYChromaOffsetHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var vkChromaFilter: WGPUFilterMode
        get() = WGPUFilterMode.fromInt(
            WGPUYCbCrVkDescriptor.vkChromaFilterHandle.get(this.`$mem`, 0L)
                    as Int
        )
        set(`value`) {
            WGPUYCbCrVkDescriptor.vkChromaFilterHandle.set(this.`$mem`, 0L, value.value)
        }

    public var forceExplicitReconstruction: WGPUBool
        get() = (WGPUYCbCrVkDescriptor.forceExplicitReconstructionHandle.get(this.`$mem`, 0L) as
                Int).toUInt()
        set(`value`) {
            WGPUYCbCrVkDescriptor.forceExplicitReconstructionHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var externalFormat: uint64_t
        get() = (WGPUYCbCrVkDescriptor.externalFormatHandle.get(this.`$mem`, 0L) as Long).toULong()
        set(`value`) {
            WGPUYCbCrVkDescriptor.externalFormatHandle.set(this.`$mem`, 0L, value.toLong())
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPUYCbCrVkDescriptor.layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            WGPUChainedStruct.layout.withName("chain"),
            ValueLayout.JAVA_INT.withName("vkFormat"),
            ValueLayout.JAVA_INT.withName("vkYCbCrModel"),
            ValueLayout.JAVA_INT.withName("vkYCbCrRange"),
            ValueLayout.JAVA_INT.withName("vkComponentSwizzleRed"),
            ValueLayout.JAVA_INT.withName("vkComponentSwizzleGreen"),
            ValueLayout.JAVA_INT.withName("vkComponentSwizzleBlue"),
            ValueLayout.JAVA_INT.withName("vkComponentSwizzleAlpha"),
            ValueLayout.JAVA_INT.withName("vkXChromaOffset"),
            ValueLayout.JAVA_INT.withName("vkYChromaOffset"),
            ValueLayout.JAVA_INT.withName("vkChromaFilter"),
            ValueLayout.JAVA_INT.withName("forceExplicitReconstruction"),
            java.lang.foreign.MemoryLayout.paddingLayout(4),
            ValueLayout.JAVA_LONG.withName("externalFormat"),
        ).withName("WGPUYCbCrVkDescriptor")

        @JvmField
        public val chainHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("chain"))

        @JvmField
        public val vkFormatHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("vkFormat"))

        @JvmField
        public val vkYCbCrModelHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("vkYCbCrModel"))

        @JvmField
        public val vkYCbCrRangeHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("vkYCbCrRange"))

        @JvmField
        public val vkComponentSwizzleRedHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("vkComponentSwizzleRed"))

        @JvmField
        public val vkComponentSwizzleGreenHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("vkComponentSwizzleGreen"))

        @JvmField
        public val vkComponentSwizzleBlueHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("vkComponentSwizzleBlue"))

        @JvmField
        public val vkComponentSwizzleAlphaHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("vkComponentSwizzleAlpha"))

        @JvmField
        public val vkXChromaOffsetHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("vkXChromaOffset"))

        @JvmField
        public val vkYChromaOffsetHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("vkYChromaOffset"))

        @JvmField
        public val vkChromaFilterHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("vkChromaFilter"))

        @JvmField
        public val forceExplicitReconstructionHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("forceExplicitReconstruction"))

        @JvmField
        public val externalFormatHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("externalFormat"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUYCbCrVkDescriptor =
            WGPUYCbCrVkDescriptor(alloc.allocate(WGPUYCbCrVkDescriptor.layout))
    }
}
