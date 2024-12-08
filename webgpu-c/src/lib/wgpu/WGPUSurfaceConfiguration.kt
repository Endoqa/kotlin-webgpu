// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu

import java.lang.foreign.*
import java.lang.invoke.VarHandle

/**
 * Options to @ref wgpuSurfaceConfigure for defining how a @ref WGPUSurface will be rendered to and presented to the user.
 * See @ref Surface-Configuration for more details.
 */
@JvmInline
public value class WGPUSurfaceConfiguration(
    public val `$mem`: MemorySegment,
) {
    public var nextInChain: Pointer<WGPUChainedStruct>
        get() = nextInChainHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            nextInChainHandle.set(this.`$mem`, 0L, value)
        }

    /**
     * The @ref WGPUDevice to use to render to surface's textures.
     */
    public var device: WGPUDevice
        get() = deviceHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            deviceHandle.set(this.`$mem`, 0L, value)
        }

    /**
     * The @ref WGPUTextureFormat of the surface's textures.
     */
    public var format: WGPUTextureFormat
        get() = WGPUTextureFormat.fromInt(formatHandle.get(this.`$mem`, 0L) as Int)
        set(`value`) {
            formatHandle.set(this.`$mem`, 0L, value.value)
        }

    /**
     * The @ref WGPUTextureUsage of the surface's textures.
     */
    public var usage: ULong
        get() = (usageHandle.get(this.`$mem`, 0L) as Long).toULong()
        set(`value`) {
            usageHandle.set(this.`$mem`, 0L, value.toLong())
        }

    /**
     * The width of the surface's textures.
     */
    public var width: UInt
        get() = (widthHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            widthHandle.set(this.`$mem`, 0L, value.toInt())
        }

    /**
     * The height of the surface's textures.
     */
    public var height: UInt
        get() = (heightHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            heightHandle.set(this.`$mem`, 0L, value.toInt())
        }

    /**
     * Array count for viewFormats.
     */
    public var viewFormatCount: ULong
        get() = (viewFormatCountHandle.get(this.`$mem`, 0L) as Long).toULong()
        set(`value`) {
            viewFormatCountHandle.set(this.`$mem`, 0L, value.toLong())
        }

    /**
     * The additional @ref WGPUTextureFormat for @ref WGPUTextureView format reinterpretation of the surface's textures.
     */
    public var viewFormats: Pointer<WGPUTextureFormat>
        get() = viewFormatsHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            viewFormatsHandle.set(this.`$mem`, 0L, value)
        }

    /**
     * How the surface's frames will be composited on the screen.
     *
     * If set to @ref WGPUCompositeAlphaMode_Auto,
     * [defaults] to @ref WGPUCompositeAlphaMode_Inherit in native (allowing the mode
     * to be configured externally), and to @ref WGPUCompositeAlphaMode_Opaque in Wasm.
     */
    public var alphaMode: WGPUCompositeAlphaMode
        get() = WGPUCompositeAlphaMode.fromInt(alphaModeHandle.get(this.`$mem`, 0L) as Int)
        set(`value`) {
            alphaModeHandle.set(this.`$mem`, 0L, value.value)
        }

    /**
     * When and in which order the surface's frames will be shown on the screen.
     *
     * If set to @ref WGPUPresentMode_Undefined,
     * [defaults](@ref SentinelValues) to @ref WGPUPresentMode_Fifo.
     */
    public var presentMode: WGPUPresentMode
        get() = WGPUPresentMode.fromInt(presentModeHandle.get(this.`$mem`, 0L) as Int)
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
            MemoryLayout.paddingLayout(4),
            ValueLayout.JAVA_LONG.withName("usage"),
            ValueLayout.JAVA_INT.withName("width"),
            ValueLayout.JAVA_INT.withName("height"),
            ValueLayout.JAVA_LONG.withName("viewFormatCount"),
            `$RuntimeHelper`.POINTER.withName("viewFormats"),
            ValueLayout.JAVA_INT.withName("alphaMode"),
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
        public val widthHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("width"))

        @JvmField
        public val heightHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("height"))

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
        public val presentModeHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("presentMode"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUSurfaceConfiguration =
            WGPUSurfaceConfiguration(alloc.allocate(layout))
    }
}
