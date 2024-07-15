// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu

import java.lang.foreign.Arena
import java.lang.foreign.MemoryLayout
import java.lang.foreign.MemorySegment
import java.lang.foreign.SegmentAllocator
import java.lang.foreign.StructLayout
import java.lang.foreign.ValueLayout
import java.lang.invoke.VarHandle
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.ULong
import kotlin.jvm.JvmField
import kotlin.jvm.JvmInline
import kotlin.jvm.JvmStatic

@JvmInline
public value class WGPUSurfaceConfiguration(
    public val `$mem`: MemorySegment,
) {
    public var nextInChain: Pointer<WGPUChainedStruct>
        get() = nextInChainHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            nextInChainHandle.set(this.`$mem`, 0L, value)
        }

    public var device: WGPUDevice
        get() = deviceHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            deviceHandle.set(this.`$mem`, 0L, value)
        }

    public var format: WGPUTextureFormat
        get() = WGPUTextureFormat.fromInt(
            formatHandle.get(this.`$mem`, 0L) as
                    Int
        )
        set(`value`) {
            formatHandle.set(this.`$mem`, 0L, value.value)
        }

    public var usage: WGPUTextureUsageFlags
        get() = (usageHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            usageHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var viewFormatCount: ULong
        get() = (viewFormatCountHandle.get(this.`$mem`, 0L) as Long).toULong()
        set(`value`) {
            viewFormatCountHandle.set(this.`$mem`, 0L, value.toLong())
        }

    public var viewFormats: Pointer<WGPUTextureFormat>
        get() = viewFormatsHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            viewFormatsHandle.set(this.`$mem`, 0L, value)
        }

    public var alphaMode: WGPUCompositeAlphaMode
        get() = WGPUCompositeAlphaMode.fromInt(
            alphaModeHandle.get(
                this.`$mem`,
                0L
            ) as Int
        )
        set(`value`) {
            alphaModeHandle.set(this.`$mem`, 0L, value.value)
        }

    public var width: uint32_t
        get() = (widthHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            widthHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var height: uint32_t
        get() = (heightHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            heightHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var presentMode: WGPUPresentMode
        get() = WGPUPresentMode.fromInt(
            presentModeHandle.get(this.`$mem`, 0L)
                    as Int
        )
        set(`value`) {
            presentModeHandle.set(this.`$mem`, 0L, value.value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("nextInChain"),
            `$RuntimeHelper`.POINTER.withName("device"),
            ValueLayout.JAVA_INT.withName("format"),
            ValueLayout.JAVA_INT.withName("usage"),
            ValueLayout.JAVA_LONG.withName("viewFormatCount"),
            `$RuntimeHelper`.POINTER.withName("viewFormats"),
            ValueLayout.JAVA_INT.withName("alphaMode"),
            ValueLayout.JAVA_INT.withName("width"),
            ValueLayout.JAVA_INT.withName("height"),
            ValueLayout.JAVA_INT.withName("presentMode"),
        ).withName("WGPUSurfaceConfiguration")

        @JvmField
        public val nextInChainHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("nextInChain"))

        @JvmField
        public val deviceHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("device"))

        @JvmField
        public val formatHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("format"))

        @JvmField
        public val usageHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("usage"))

        @JvmField
        public val viewFormatCountHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("viewFormatCount"))

        @JvmField
        public val viewFormatsHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("viewFormats"))

        @JvmField
        public val alphaModeHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("alphaMode"))

        @JvmField
        public val widthHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("width"))

        @JvmField
        public val heightHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("height"))

        @JvmField
        public val presentModeHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("presentMode"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUSurfaceConfiguration =
            WGPUSurfaceConfiguration(alloc.allocate(layout))
    }
}
