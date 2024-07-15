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
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.Short
import kotlin.jvm.JvmField
import kotlin.jvm.JvmInline
import kotlin.jvm.JvmStatic

@JvmInline
public value class WGPUSamplerDescriptor(
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

    public var addressModeU: WGPUAddressMode
        get() = WGPUAddressMode.fromInt(
            addressModeUHandle.get(this.`$mem`, 0L) as
                    Int
        )
        set(`value`) {
            addressModeUHandle.set(this.`$mem`, 0L, value.value)
        }

    public var addressModeV: WGPUAddressMode
        get() = WGPUAddressMode.fromInt(
            addressModeVHandle.get(this.`$mem`, 0L) as
                    Int
        )
        set(`value`) {
            addressModeVHandle.set(this.`$mem`, 0L, value.value)
        }

    public var addressModeW: WGPUAddressMode
        get() = WGPUAddressMode.fromInt(
            addressModeWHandle.get(this.`$mem`, 0L) as
                    Int
        )
        set(`value`) {
            addressModeWHandle.set(this.`$mem`, 0L, value.value)
        }

    public var magFilter: WGPUFilterMode
        get() = WGPUFilterMode.fromInt(
            magFilterHandle.get(this.`$mem`, 0L) as
                    Int
        )
        set(`value`) {
            magFilterHandle.set(this.`$mem`, 0L, value.value)
        }

    public var minFilter: WGPUFilterMode
        get() = WGPUFilterMode.fromInt(
            minFilterHandle.get(this.`$mem`, 0L) as
                    Int
        )
        set(`value`) {
            minFilterHandle.set(this.`$mem`, 0L, value.value)
        }

    public var mipmapFilter: WGPUMipmapFilterMode
        get() = WGPUMipmapFilterMode.fromInt(
            mipmapFilterHandle.get(
                this.`$mem`,
                0L
            ) as Int
        )
        set(`value`) {
            mipmapFilterHandle.set(this.`$mem`, 0L, value.value)
        }

    public var lodMinClamp: Float
        get() = lodMinClampHandle.get(this.`$mem`, 0L) as Float
        set(`value`) {
            lodMinClampHandle.set(this.`$mem`, 0L, value)
        }

    public var lodMaxClamp: Float
        get() = lodMaxClampHandle.get(this.`$mem`, 0L) as Float
        set(`value`) {
            lodMaxClampHandle.set(this.`$mem`, 0L, value)
        }

    public var compare: WGPUCompareFunction
        get() = WGPUCompareFunction.fromInt(
            compareHandle.get(this.`$mem`, 0L) as
                    Int
        )
        set(`value`) {
            compareHandle.set(this.`$mem`, 0L, value.value)
        }

    public var maxAnisotropy: uint16_t
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
            `$RuntimeHelper`.POINTER.withName("label"),
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
        public val labelHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("label"))

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
