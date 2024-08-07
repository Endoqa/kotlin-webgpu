// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c

import java.lang.foreign.*
import java.lang.invoke.VarHandle

@JvmInline
public value class WGPUTextureViewDescriptor(
    public val `$mem`: MemorySegment,
) {
    public var nextInChain: Pointer<WGPUChainedStruct>
        get() = nextInChainHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            nextInChainHandle.set(this.`$mem`, 0L, value)
        }

    public var label: Pointer<Byte>
        get() = labelHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            labelHandle.set(this.`$mem`, 0L, value)
        }

    public var format: WGPUTextureFormat
        get() = WGPUTextureFormat.fromInt(
            formatHandle.get(this.`$mem`, 0L) as
                    Int
        )
        set(`value`) {
            formatHandle.set(this.`$mem`, 0L, value.value)
        }

    public var dimension: WGPUTextureViewDimension
        get() =
            WGPUTextureViewDimension.fromInt(
                dimensionHandle.get(
                    this.`$mem`,
                    0L
                ) as Int
            )
        set(`value`) {
            dimensionHandle.set(this.`$mem`, 0L, value.value)
        }

    public var baseMipLevel: uint32_t
        get() = (baseMipLevelHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            baseMipLevelHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var mipLevelCount: uint32_t
        get() = (mipLevelCountHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            mipLevelCountHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var baseArrayLayer: uint32_t
        get() = (baseArrayLayerHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            baseArrayLayerHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var arrayLayerCount: uint32_t
        get() = (arrayLayerCountHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            arrayLayerCountHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var aspect: WGPUTextureAspect
        get() = WGPUTextureAspect.fromInt(
            aspectHandle.get(this.`$mem`, 0L) as
                    Int
        )
        set(`value`) {
            aspectHandle.set(this.`$mem`, 0L, value.value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("nextInChain"),
            `$RuntimeHelper`.POINTER.withName("label"),
            ValueLayout.JAVA_INT.withName("format"),
            ValueLayout.JAVA_INT.withName("dimension"),
            ValueLayout.JAVA_INT.withName("baseMipLevel"),
            ValueLayout.JAVA_INT.withName("mipLevelCount"),
            ValueLayout.JAVA_INT.withName("baseArrayLayer"),
            ValueLayout.JAVA_INT.withName("arrayLayerCount"),
            ValueLayout.JAVA_INT.withName("aspect"),
            MemoryLayout.paddingLayout(4),
        ).withName("WGPUTextureViewDescriptor")

        @JvmField
        public val nextInChainHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("nextInChain"))

        @JvmField
        public val labelHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("label"))

        @JvmField
        public val formatHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("format"))

        @JvmField
        public val dimensionHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("dimension"))

        @JvmField
        public val baseMipLevelHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("baseMipLevel"))

        @JvmField
        public val mipLevelCountHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("mipLevelCount"))

        @JvmField
        public val baseArrayLayerHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("baseArrayLayer"))

        @JvmField
        public val arrayLayerCountHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("arrayLayerCount"))

        @JvmField
        public val aspectHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("aspect"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUTextureViewDescriptor =
            WGPUTextureViewDescriptor(alloc.allocate(layout))
    }
}
