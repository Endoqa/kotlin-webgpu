// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu

import java.lang.foreign.*
import java.lang.invoke.VarHandle

/**
 * TODO
 */
@JvmInline
public value class WGPUTextureBindingLayout(
    public val `$mem`: MemorySegment,
) {
    public var nextInChain: Pointer<WGPUChainedStruct>
        get() = nextInChainHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            nextInChainHandle.set(this.`$mem`, 0L, value)
        }

    /**
     * If set to @ref WGPUTextureSampleType_Undefined,
     * [defaults](@ref SentinelValues) to @ref WGPUTextureSampleType_Float.
     */
    public var sampleType: WGPUTextureSampleType
        get() = WGPUTextureSampleType.fromInt(sampleTypeHandle.get(this.`$mem`, 0L) as Int)
        set(`value`) {
            sampleTypeHandle.set(this.`$mem`, 0L, value.value)
        }

    /**
     * If set to @ref WGPUTextureViewDimension_Undefined,
     * [defaults](@ref SentinelValues) to @ref WGPUTextureViewDimension_2D.
     */
    public var viewDimension: WGPUTextureViewDimension
        get() = WGPUTextureViewDimension.fromInt(
            viewDimensionHandle.get(
                this.`$mem`,
                0L
            ) as Int
        )
        set(`value`) {
            viewDimensionHandle.set(this.`$mem`, 0L, value.value)
        }

    /**
     * TODO
     */
    public var multisampled: WGPUBool
        get() = (multisampledHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            multisampledHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("nextInChain"),
            ValueLayout.JAVA_INT.withName("sampleType"),
            ValueLayout.JAVA_INT.withName("viewDimension"),
            ValueLayout.JAVA_INT.withName("multisampled"),
            MemoryLayout.paddingLayout(4),
        ).withName("WGPUTextureBindingLayout")

        @JvmField
        public val nextInChainHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("nextInChain"))

        @JvmField
        public val sampleTypeHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("sampleType"))

        @JvmField
        public val viewDimensionHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("viewDimension"))

        @JvmField
        public val multisampledHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("multisampled"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUTextureBindingLayout =
            WGPUTextureBindingLayout(alloc.allocate(layout))
    }
}
