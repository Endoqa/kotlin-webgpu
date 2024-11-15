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
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.jvm.JvmField
import kotlin.jvm.JvmInline
import kotlin.jvm.JvmStatic

@JvmInline
public value class WGPUDepthStencilState(
    public val `$mem`: MemorySegment,
) {
    public var nextInChain: Pointer<WGPUChainedStruct>
        get() = WGPUDepthStencilState.nextInChainHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUDepthStencilState.nextInChainHandle.set(this.`$mem`, 0L, value)
        }

    public var format: WGPUTextureFormat
        get() = WGPUTextureFormat.fromInt(
            WGPUDepthStencilState.formatHandle.get(this.`$mem`, 0L) as
                    Int
        )
        set(`value`) {
            WGPUDepthStencilState.formatHandle.set(this.`$mem`, 0L, value.value)
        }

    public var depthWriteEnabled: WGPUOptionalBool
        get() = WGPUOptionalBool.fromInt(
            WGPUDepthStencilState.depthWriteEnabledHandle.get(
                this.`$mem`,
                0L
            ) as Int
        )
        set(`value`) {
            WGPUDepthStencilState.depthWriteEnabledHandle.set(this.`$mem`, 0L, value.value)
        }

    public var depthCompare: WGPUCompareFunction
        get() = WGPUCompareFunction.fromInt(
            WGPUDepthStencilState.depthCompareHandle.get(
                this.`$mem`,
                0L
            ) as Int
        )
        set(`value`) {
            WGPUDepthStencilState.depthCompareHandle.set(this.`$mem`, 0L, value.value)
        }

    public var stencilFront: WGPUStencilFaceState
        get() = WGPUStencilFaceState(
            WGPUDepthStencilState.stencilFrontHandle.invokeExact(
                this.`$mem`,
                0L
            ) as MemorySegment
        )
        set(`value`) {
            MemorySegment.copy(
                value.`$mem`, 0L, this.stencilFront.`$mem`, 0L,
                WGPUStencilFaceState.layout.byteSize()
            )
        }

    public var stencilBack: WGPUStencilFaceState
        get() = WGPUStencilFaceState(
            WGPUDepthStencilState.stencilBackHandle.invokeExact(
                this.`$mem`,
                0L
            ) as MemorySegment
        )
        set(`value`) {
            MemorySegment.copy(
                value.`$mem`, 0L, this.stencilBack.`$mem`, 0L,
                WGPUStencilFaceState.layout.byteSize()
            )
        }

    public var stencilReadMask: UInt
        get() = (WGPUDepthStencilState.stencilReadMaskHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            WGPUDepthStencilState.stencilReadMaskHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var stencilWriteMask: UInt
        get() = (WGPUDepthStencilState.stencilWriteMaskHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            WGPUDepthStencilState.stencilWriteMaskHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var depthBias: Int
        get() = WGPUDepthStencilState.depthBiasHandle.get(this.`$mem`, 0L) as Int
        set(`value`) {
            WGPUDepthStencilState.depthBiasHandle.set(this.`$mem`, 0L, value)
        }

    public var depthBiasSlopeScale: Float
        get() = WGPUDepthStencilState.depthBiasSlopeScaleHandle.get(this.`$mem`, 0L) as Float
        set(`value`) {
            WGPUDepthStencilState.depthBiasSlopeScaleHandle.set(this.`$mem`, 0L, value)
        }

    public var depthBiasClamp: Float
        get() = WGPUDepthStencilState.depthBiasClampHandle.get(this.`$mem`, 0L) as Float
        set(`value`) {
            WGPUDepthStencilState.depthBiasClampHandle.set(this.`$mem`, 0L, value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPUDepthStencilState.layout)
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
            WGPUDepthStencilState(alloc.allocate(WGPUDepthStencilState.layout))
    }
}
