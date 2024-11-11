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
import kotlin.Int
import kotlin.Long
import kotlin.UInt
import kotlin.jvm.JvmField
import kotlin.jvm.JvmInline
import kotlin.jvm.JvmStatic

@JvmInline
public value class WGPUTextureViewDescriptor(
    public val `$mem`: MemorySegment,
) {
    public var nextInChain: Pointer<WGPUChainedStruct>
        get() = WGPUTextureViewDescriptor.nextInChainHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUTextureViewDescriptor.nextInChainHandle.set(this.`$mem`, 0L, value)
        }

    public var label: WGPUStringView
        get() = WGPUStringView(
            WGPUTextureViewDescriptor.labelHandle.invokeExact(this.`$mem`, 0L) as
                    MemorySegment
        )
        set(`value`) {
            MemorySegment.copy(value.`$mem`, 0L, this.label.`$mem`, 0L, WGPUStringView.layout.byteSize())
        }

    public var format: WGPUTextureFormat
        get() = WGPUTextureFormat.fromInt(
            WGPUTextureViewDescriptor.formatHandle.get(this.`$mem`, 0L) as
                    Int
        )
        set(`value`) {
            WGPUTextureViewDescriptor.formatHandle.set(this.`$mem`, 0L, value.value)
        }

    public var dimension: WGPUTextureViewDimension
        get() =
            WGPUTextureViewDimension.fromInt(
                WGPUTextureViewDescriptor.dimensionHandle.get(
                    this.`$mem`,
                    0L
                ) as Int
            )
        set(`value`) {
            WGPUTextureViewDescriptor.dimensionHandle.set(this.`$mem`, 0L, value.value)
        }

    public var baseMipLevel: UInt
        get() = (WGPUTextureViewDescriptor.baseMipLevelHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            WGPUTextureViewDescriptor.baseMipLevelHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var mipLevelCount: UInt
        get() = (WGPUTextureViewDescriptor.mipLevelCountHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            WGPUTextureViewDescriptor.mipLevelCountHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var baseArrayLayer: UInt
        get() = (WGPUTextureViewDescriptor.baseArrayLayerHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            WGPUTextureViewDescriptor.baseArrayLayerHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var arrayLayerCount: UInt
        get() = (WGPUTextureViewDescriptor.arrayLayerCountHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            WGPUTextureViewDescriptor.arrayLayerCountHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var aspect: WGPUTextureAspect
        get() = WGPUTextureAspect.fromInt(
            WGPUTextureViewDescriptor.aspectHandle.get(this.`$mem`, 0L) as
                    Int
        )
        set(`value`) {
            WGPUTextureViewDescriptor.aspectHandle.set(this.`$mem`, 0L, value.value)
        }

    public var usage: WGPUTextureUsage
        get() = (WGPUTextureViewDescriptor.usageHandle.get(this.`$mem`, 0L) as Long).toULong()
        set(`value`) {
            WGPUTextureViewDescriptor.usageHandle.set(this.`$mem`, 0L, value.toLong())
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPUTextureViewDescriptor.layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("nextInChain"),
            WGPUStringView.layout.withName("label"),
            ValueLayout.JAVA_INT.withName("format"),
            ValueLayout.JAVA_INT.withName("dimension"),
            ValueLayout.JAVA_INT.withName("baseMipLevel"),
            ValueLayout.JAVA_INT.withName("mipLevelCount"),
            ValueLayout.JAVA_INT.withName("baseArrayLayer"),
            ValueLayout.JAVA_INT.withName("arrayLayerCount"),
            ValueLayout.JAVA_INT.withName("aspect"),
            java.lang.foreign.MemoryLayout.paddingLayout(4),
            ValueLayout.JAVA_LONG.withName("usage"),
        ).withName("WGPUTextureViewDescriptor")

        @JvmField
        public val nextInChainHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("nextInChain"))

        @JvmField
        public val labelHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("label"))

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

        @JvmField
        public val usageHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("usage"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUTextureViewDescriptor =
            WGPUTextureViewDescriptor(alloc.allocate(WGPUTextureViewDescriptor.layout))
    }
}
