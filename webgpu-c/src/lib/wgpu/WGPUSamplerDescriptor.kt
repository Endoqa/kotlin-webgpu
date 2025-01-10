// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu

import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.VarHandle

/**
 * TODO
 */
@JvmInline
public value class WGPUSamplerDescriptor(
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
     * If set to [WGPUAddressMode.Undefined],
     * [defaults](https://webgpu-native.github.io/webgpu-headers/articles.html) to [WGPUAddressMode.ClampToEdge].
     */
    public var addressModeU: WGPUAddressMode
        get() = WGPUAddressMode.fromInt(addressModeUHandle.get(this.`$mem`, 0L) as Int)
        set(`value`) {
            addressModeUHandle.set(this.`$mem`, 0L, value.value)
        }

    /**
     * If set to [WGPUAddressMode.Undefined],
     * [defaults](https://webgpu-native.github.io/webgpu-headers/articles.html) to [WGPUAddressMode.ClampToEdge].
     */
    public var addressModeV: WGPUAddressMode
        get() = WGPUAddressMode.fromInt(addressModeVHandle.get(this.`$mem`, 0L) as Int)
        set(`value`) {
            addressModeVHandle.set(this.`$mem`, 0L, value.value)
        }

    /**
     * If set to [WGPUAddressMode.Undefined],
     * [defaults](https://webgpu-native.github.io/webgpu-headers/articles.html) to [WGPUAddressMode.ClampToEdge].
     */
    public var addressModeW: WGPUAddressMode
        get() = WGPUAddressMode.fromInt(addressModeWHandle.get(this.`$mem`, 0L) as Int)
        set(`value`) {
            addressModeWHandle.set(this.`$mem`, 0L, value.value)
        }

    /**
     * If set to [WGPUFilterMode.Undefined],
     * [defaults](https://webgpu-native.github.io/webgpu-headers/articles.html) to [WGPUFilterMode.Nearest].
     */
    public var magFilter: WGPUFilterMode
        get() = WGPUFilterMode.fromInt(magFilterHandle.get(this.`$mem`, 0L) as Int)
        set(`value`) {
            magFilterHandle.set(this.`$mem`, 0L, value.value)
        }

    /**
     * If set to [WGPUFilterMode.Undefined],
     * [defaults](https://webgpu-native.github.io/webgpu-headers/articles.html) to [WGPUFilterMode.Nearest].
     */
    public var minFilter: WGPUFilterMode
        get() = WGPUFilterMode.fromInt(minFilterHandle.get(this.`$mem`, 0L) as Int)
        set(`value`) {
            minFilterHandle.set(this.`$mem`, 0L, value.value)
        }

    /**
     * If set to [WGPUFilterMode.Undefined],
     * [defaults](https://webgpu-native.github.io/webgpu-headers/articles.html) to [WGPUMipmapFilterMode.Nearest].
     */
    public var mipmapFilter: WGPUMipmapFilterMode
        get() = WGPUMipmapFilterMode.fromInt(mipmapFilterHandle.get(this.`$mem`, 0L) as Int)
        set(`value`) {
            mipmapFilterHandle.set(this.`$mem`, 0L, value.value)
        }

    /**
     * TODO
     *
     * If non-finite, produces a [NonFiniteFloatValueError](https://webgpu-native.github.io/webgpu-headers/articles.html).
     */
    public var lodMinClamp: Float
        get() = lodMinClampHandle.get(this.`$mem`, 0L) as Float
        set(`value`) {
            lodMinClampHandle.set(this.`$mem`, 0L, value)
        }

    /**
     * TODO
     *
     * If non-finite, produces a [NonFiniteFloatValueError](https://webgpu-native.github.io/webgpu-headers/articles.html).
     */
    public var lodMaxClamp: Float
        get() = lodMaxClampHandle.get(this.`$mem`, 0L) as Float
        set(`value`) {
            lodMaxClampHandle.set(this.`$mem`, 0L, value)
        }

    /**
     * TODO
     */
    public var compare: WGPUCompareFunction
        get() = WGPUCompareFunction.fromInt(compareHandle.get(this.`$mem`, 0L) as Int)
        set(`value`) {
            compareHandle.set(this.`$mem`, 0L, value.value)
        }

    /**
     * TODO
     */
    public var maxAnisotropy: UShort
        get() = (maxAnisotropyHandle.get(this.`$mem`, 0L) as Short).toUShort()
        set(`value`) {
            maxAnisotropyHandle.set(this.`$mem`, 0L, value.toShort())
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("nextInChain"),
            WGPUStringView.layout.withName("label"),
            ValueLayout.JAVA_INT.withName("addressModeU"),
            ValueLayout.JAVA_INT.withName("addressModeV"),
            ValueLayout.JAVA_INT.withName("addressModeW"),
            ValueLayout.JAVA_INT.withName("magFilter"),
            ValueLayout.JAVA_INT.withName("minFilter"),
            ValueLayout.JAVA_INT.withName("mipmapFilter"),
            ValueLayout.JAVA_FLOAT.withName("lodMinClamp"),
            ValueLayout.JAVA_FLOAT.withName("lodMaxClamp"),
            ValueLayout.JAVA_INT.withName("compare"),
            ValueLayout.JAVA_SHORT.withName("maxAnisotropy"),
            MemoryLayout.paddingLayout(2),
        ).withName("WGPUSamplerDescriptor")

        @JvmField
        public val nextInChainHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("nextInChain"))

        @JvmField
        public val labelHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("label"))

        @JvmField
        public val addressModeUHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("addressModeU"))

        @JvmField
        public val addressModeVHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("addressModeV"))

        @JvmField
        public val addressModeWHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("addressModeW"))

        @JvmField
        public val magFilterHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("magFilter"))

        @JvmField
        public val minFilterHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("minFilter"))

        @JvmField
        public val mipmapFilterHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("mipmapFilter"))

        @JvmField
        public val lodMinClampHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("lodMinClamp"))

        @JvmField
        public val lodMaxClampHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("lodMaxClamp"))

        @JvmField
        public val compareHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("compare"))

        @JvmField
        public val maxAnisotropyHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("maxAnisotropy"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUSamplerDescriptor =
            WGPUSamplerDescriptor(alloc.allocate(layout))
    }
}
