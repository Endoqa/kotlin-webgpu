// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu

import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.VarHandle

/**
 * TODO
 */
@JvmInline
public value class WGPUTextureDescriptor(
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
    public var label: WGPUStringView
        get() = WGPUStringView(labelHandle.invokeExact(this.`$mem`, 0L) as MemorySegment)
        set(`value`) {
            MemorySegment.copy(value.`$mem`, 0L, this.label.`$mem`, 0L, WGPUStringView.layout.byteSize())
        }

    /**
     * TODO
     */
    public var usage: ULong
        get() = (usageHandle.get(this.`$mem`, 0L) as Long).toULong()
        set(`value`) {
            usageHandle.set(this.`$mem`, 0L, value.toLong())
        }

    /**
     * If set to [WGPUTextureDimension.Undefined],
     * [defaults](https://webgpu-native.github.io/webgpu-headers/SentinelValues.html) to [WGPUTextureDimension.2D].
     */
    public var dimension: WGPUTextureDimension
        get() = WGPUTextureDimension.fromInt(dimensionHandle.get(this.`$mem`, 0L) as Int)
        set(`value`) {
            dimensionHandle.set(this.`$mem`, 0L, value.value)
        }

    /**
     * TODO
     */
    public var size: WGPUExtent3D
        get() = WGPUExtent3D(sizeHandle.invokeExact(this.`$mem`, 0L) as MemorySegment)
        set(`value`) {
            MemorySegment.copy(value.`$mem`, 0L, this.size.`$mem`, 0L, WGPUExtent3D.layout.byteSize())
        }

    /**
     * TODO
     */
    public var format: WGPUTextureFormat
        get() = WGPUTextureFormat.fromInt(formatHandle.get(this.`$mem`, 0L) as Int)
        set(`value`) {
            formatHandle.set(this.`$mem`, 0L, value.value)
        }

    /**
     * TODO
     */
    public var mipLevelCount: UInt
        get() = (mipLevelCountHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            mipLevelCountHandle.set(this.`$mem`, 0L, value.toInt())
        }

    /**
     * TODO
     */
    public var sampleCount: UInt
        get() = (sampleCountHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            sampleCountHandle.set(this.`$mem`, 0L, value.toInt())
        }

    /**
     * Array count for [viewFormats].
     */
    public var viewFormatCount: ULong
        get() = (viewFormatCountHandle.get(this.`$mem`, 0L) as Long).toULong()
        set(`value`) {
            viewFormatCountHandle.set(this.`$mem`, 0L, value.toLong())
        }

    /**
     * TODO
     */
    public var viewFormats: Pointer<WGPUTextureFormat>
        get() = viewFormatsHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            viewFormatsHandle.set(this.`$mem`, 0L, value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("nextInChain"),
            WGPUStringView.layout.withName("label"),
            ValueLayout.JAVA_LONG.withName("usage"),
            ValueLayout.JAVA_INT.withName("dimension"),
            WGPUExtent3D.layout.withName("size"),
            ValueLayout.JAVA_INT.withName("format"),
            ValueLayout.JAVA_INT.withName("mipLevelCount"),
            ValueLayout.JAVA_INT.withName("sampleCount"),
            ValueLayout.JAVA_LONG.withName("viewFormatCount"),
            `$RuntimeHelper`.POINTER.withName("viewFormats"),
        ).withName("WGPUTextureDescriptor")

        @JvmField
        public val nextInChainHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("nextInChain"))

        @JvmField
        public val labelHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("label"))

        @JvmField
        public val usageHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("usage"))

        @JvmField
        public val dimensionHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("dimension"))

        @JvmField
        public val sizeHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("size"))

        @JvmField
        public val formatHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("format"))

        @JvmField
        public val mipLevelCountHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("mipLevelCount"))

        @JvmField
        public val sampleCountHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("sampleCount"))

        @JvmField
        public val viewFormatCountHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("viewFormatCount"))

        @JvmField
        public val viewFormatsHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("viewFormats"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUTextureDescriptor =
            WGPUTextureDescriptor(alloc.allocate(layout))
    }
}
