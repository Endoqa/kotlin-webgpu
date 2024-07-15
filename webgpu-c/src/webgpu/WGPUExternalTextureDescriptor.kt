// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu

import java.lang.foreign.Arena
import java.lang.foreign.MemoryLayout
import java.lang.foreign.MemorySegment
import java.lang.foreign.SegmentAllocator
import java.lang.foreign.StructLayout
import java.lang.foreign.ValueLayout
import java.lang.invoke.MethodHandle
import java.lang.invoke.VarHandle
import kotlin.Boolean
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.jvm.JvmField
import kotlin.jvm.JvmInline
import kotlin.jvm.JvmStatic

@JvmInline
public value class WGPUExternalTextureDescriptor(
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

    public var plane0: WGPUTextureView
        get() = plane0Handle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            plane0Handle.set(this.`$mem`, 0L, value)
        }

    public var plane1: WGPUTextureView
        get() = plane1Handle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            plane1Handle.set(this.`$mem`, 0L, value)
        }

    public var visibleOrigin: WGPUOrigin2D
        get() = WGPUOrigin2D(
            visibleOriginHandle.invokeExact(
                this.`$mem`,
                0L
            ) as MemorySegment
        )
        set(`value`) {
            MemorySegment.copy(
                value.`$mem`, 0L, this.visibleOrigin.`$mem`, 0L,
                WGPUOrigin2D.layout.byteSize()
            )
        }

    public var visibleSize: WGPUExtent2D
        get() = WGPUExtent2D(
            visibleSizeHandle.invokeExact(
                this.`$mem`,
                0L
            ) as MemorySegment
        )
        set(`value`) {
            MemorySegment.copy(
                value.`$mem`, 0L, this.visibleSize.`$mem`, 0L,
                WGPUExtent2D.layout.byteSize()
            )
        }

    public var doYuvToRgbConversionOnly: WGPUBool
        get() = (doYuvToRgbConversionOnlyHandle.get(this.`$mem`, 0L) as
                Int).toUInt()
        set(`value`) {
            doYuvToRgbConversionOnlyHandle.set(
                this.`$mem`,
                0L, value.toInt()
            )
        }

    public var yuvToRgbConversionMatrix: Pointer<Float>
        get() = yuvToRgbConversionMatrixHandle.get(this.`$mem`, 0L) as
                MemorySegment
        set(`value`) {
            yuvToRgbConversionMatrixHandle.set(this.`$mem`, 0L, value)
        }

    public var srcTransferFunctionParameters: Pointer<Float>
        get() = srcTransferFunctionParametersHandle.get(this.`$mem`, 0L)
                as MemorySegment
        set(`value`) {
            srcTransferFunctionParametersHandle.set(this.`$mem`, 0L, value)
        }

    public var dstTransferFunctionParameters: Pointer<Float>
        get() = dstTransferFunctionParametersHandle.get(this.`$mem`, 0L)
                as MemorySegment
        set(`value`) {
            dstTransferFunctionParametersHandle.set(this.`$mem`, 0L, value)
        }

    public var gamutConversionMatrix: Pointer<Float>
        get() = gamutConversionMatrixHandle.get(this.`$mem`, 0L) as
                MemorySegment
        set(`value`) {
            gamutConversionMatrixHandle.set(this.`$mem`, 0L, value)
        }

    public var mirrored: WGPUBool
        get() = (mirroredHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            mirroredHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var rotation: WGPUExternalTextureRotation
        get() =
            WGPUExternalTextureRotation.fromInt(
                rotationHandle.get(
                    this.`$mem`,
                    0L
                ) as Int
            )
        set(`value`) {
            rotationHandle.set(this.`$mem`, 0L, value.value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("nextInChain"),
            `$RuntimeHelper`.POINTER.withName("label"),
            `$RuntimeHelper`.POINTER.withName("plane0"),
            `$RuntimeHelper`.POINTER.withName("plane1"),
            WGPUOrigin2D.layout.withName("visibleOrigin"),
            WGPUExtent2D.layout.withName("visibleSize"),
            ValueLayout.JAVA_INT.withName("doYuvToRgbConversionOnly"),
            MemoryLayout.paddingLayout(4),
            `$RuntimeHelper`.POINTER.withName("yuvToRgbConversionMatrix"),
            `$RuntimeHelper`.POINTER.withName("srcTransferFunctionParameters"),
            `$RuntimeHelper`.POINTER.withName("dstTransferFunctionParameters"),
            `$RuntimeHelper`.POINTER.withName("gamutConversionMatrix"),
            ValueLayout.JAVA_INT.withName("mirrored"),
            ValueLayout.JAVA_INT.withName("rotation"),
        ).withName("WGPUExternalTextureDescriptor")

        @JvmField
        public val nextInChainHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("nextInChain"))

        @JvmField
        public val labelHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("label"))

        @JvmField
        public val plane0Handle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("plane0"))

        @JvmField
        public val plane1Handle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("plane1"))

        @JvmField
        public val visibleOriginHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("visibleOrigin"))

        @JvmField
        public val visibleSizeHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("visibleSize"))

        @JvmField
        public val doYuvToRgbConversionOnlyHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("doYuvToRgbConversionOnly"))

        @JvmField
        public val yuvToRgbConversionMatrixHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("yuvToRgbConversionMatrix"))

        @JvmField
        public val srcTransferFunctionParametersHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("srcTransferFunctionParameters"))

        @JvmField
        public val dstTransferFunctionParametersHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("dstTransferFunctionParameters"))

        @JvmField
        public val gamutConversionMatrixHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("gamutConversionMatrix"))

        @JvmField
        public val mirroredHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("mirrored"))

        @JvmField
        public val rotationHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("rotation"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUExternalTextureDescriptor =
            WGPUExternalTextureDescriptor(alloc.allocate(layout))
    }
}
