// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu

import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.VarHandle

/**
 * TODO
 */
@JvmInline
public value class WGPUDepthStencilState(
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
    public var format: WGPUTextureFormat
        get() = WGPUTextureFormat.fromInt(formatHandle.get(this.`$mem`, 0L) as Int)
        set(`value`) {
            formatHandle.set(this.`$mem`, 0L, value.value)
        }

    /**
     * TODO
     */
    public var depthWriteEnabled: WGPUOptionalBool
        get() = WGPUOptionalBool.fromInt(depthWriteEnabledHandle.get(this.`$mem`, 0L) as Int)
        set(`value`) {
            depthWriteEnabledHandle.set(this.`$mem`, 0L, value.value)
        }

    /**
     * TODO
     */
    public var depthCompare: WGPUCompareFunction
        get() = WGPUCompareFunction.fromInt(depthCompareHandle.get(this.`$mem`, 0L) as Int)
        set(`value`) {
            depthCompareHandle.set(this.`$mem`, 0L, value.value)
        }

    /**
     * TODO
     */
    public var stencilFront: WGPUStencilFaceState
        get() = WGPUStencilFaceState(
            stencilFrontHandle.invokeExact(
                this.`$mem`,
                0L
            ) as MemorySegment
        )
        set(`value`) {
            MemorySegment.copy(value.`$mem`, 0L, this.stencilFront.`$mem`, 0L, WGPUStencilFaceState.layout.byteSize())
        }

    /**
     * TODO
     */
    public var stencilBack: WGPUStencilFaceState
        get() = WGPUStencilFaceState(
            stencilBackHandle.invokeExact(
                this.`$mem`,
                0L
            ) as MemorySegment
        )
        set(`value`) {
            MemorySegment.copy(value.`$mem`, 0L, this.stencilBack.`$mem`, 0L, WGPUStencilFaceState.layout.byteSize())
        }

    /**
     * TODO
     */
    public var stencilReadMask: UInt
        get() = (stencilReadMaskHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            stencilReadMaskHandle.set(this.`$mem`, 0L, value.toInt())
        }

    /**
     * TODO
     */
    public var stencilWriteMask: UInt
        get() = (stencilWriteMaskHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            stencilWriteMaskHandle.set(this.`$mem`, 0L, value.toInt())
        }

    /**
     * TODO
     */
    public var depthBias: Int
        get() = depthBiasHandle.get(this.`$mem`, 0L) as Int
        set(`value`) {
            depthBiasHandle.set(this.`$mem`, 0L, value)
        }

    /**
     * TODO
     *
     * If non-finite, produces a [NonFiniteFloatValueError](https://webgpu-native.github.io/webgpu-headers/articles.html).
     */
    public var depthBiasSlopeScale: Float
        get() = depthBiasSlopeScaleHandle.get(this.`$mem`, 0L) as Float
        set(`value`) {
            depthBiasSlopeScaleHandle.set(this.`$mem`, 0L, value)
        }

    /**
     * TODO
     *
     * If non-finite, produces a [NonFiniteFloatValueError](https://webgpu-native.github.io/webgpu-headers/articles.html).
     */
    public var depthBiasClamp: Float
        get() = depthBiasClampHandle.get(this.`$mem`, 0L) as Float
        set(`value`) {
            depthBiasClampHandle.set(this.`$mem`, 0L, value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("nextInChain"),
            ValueLayout.JAVA_INT.withName("format"),
            ValueLayout.JAVA_INT.withName("depthWriteEnabled"),
            ValueLayout.JAVA_INT.withName("depthCompare"),
            WGPUStencilFaceState.layout.withName("stencilFront"),
            WGPUStencilFaceState.layout.withName("stencilBack"),
            ValueLayout.JAVA_INT.withName("stencilReadMask"),
            ValueLayout.JAVA_INT.withName("stencilWriteMask"),
            ValueLayout.JAVA_INT.withName("depthBias"),
            ValueLayout.JAVA_FLOAT.withName("depthBiasSlopeScale"),
            ValueLayout.JAVA_FLOAT.withName("depthBiasClamp"),
        ).withName("WGPUDepthStencilState")

        @JvmField
        public val nextInChainHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("nextInChain"))

        @JvmField
        public val formatHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("format"))

        @JvmField
        public val depthWriteEnabledHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("depthWriteEnabled"))

        @JvmField
        public val depthCompareHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("depthCompare"))

        @JvmField
        public val stencilFrontHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("stencilFront"))

        @JvmField
        public val stencilBackHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("stencilBack"))

        @JvmField
        public val stencilReadMaskHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("stencilReadMask"))

        @JvmField
        public val stencilWriteMaskHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("stencilWriteMask"))

        @JvmField
        public val depthBiasHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("depthBias"))

        @JvmField
        public val depthBiasSlopeScaleHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("depthBiasSlopeScale"))

        @JvmField
        public val depthBiasClampHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("depthBiasClamp"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUDepthStencilState =
            WGPUDepthStencilState(alloc.allocate(layout))
    }
}
