// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c

import java.lang.foreign.Arena
import java.lang.foreign.MemoryLayout
import java.lang.foreign.MemorySegment
import java.lang.foreign.SegmentAllocator
import java.lang.foreign.StructLayout
import java.lang.foreign.ValueLayout
import java.lang.invoke.VarHandle
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.jvm.JvmField
import kotlin.jvm.JvmInline
import kotlin.jvm.JvmStatic

@JvmInline
public value class WGPURenderPassDepthStencilAttachment(
    public val `$mem`: MemorySegment,
) {
    public var view: WGPUTextureView
        get() = WGPURenderPassDepthStencilAttachment.viewHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPURenderPassDepthStencilAttachment.viewHandle.set(this.`$mem`, 0L, value)
        }

    public var depthLoadOp: WGPULoadOp
        get() =
            WGPULoadOp.fromInt(
                WGPURenderPassDepthStencilAttachment.depthLoadOpHandle.get(
                    this.`$mem`,
                    0L
                ) as Int
            )
        set(`value`) {
            WGPURenderPassDepthStencilAttachment.depthLoadOpHandle.set(this.`$mem`, 0L, value.value)
        }

    public var depthStoreOp: WGPUStoreOp
        get() =
            WGPUStoreOp.fromInt(
                WGPURenderPassDepthStencilAttachment.depthStoreOpHandle.get(
                    this.`$mem`,
                    0L
                ) as Int
            )
        set(`value`) {
            WGPURenderPassDepthStencilAttachment.depthStoreOpHandle.set(this.`$mem`, 0L, value.value)
        }

    public var depthClearValue: Float
        get() = WGPURenderPassDepthStencilAttachment.depthClearValueHandle.get(this.`$mem`, 0L) as Float
        set(`value`) {
            WGPURenderPassDepthStencilAttachment.depthClearValueHandle.set(this.`$mem`, 0L, value)
        }

    public var depthReadOnly: WGPUBool
        get() = (WGPURenderPassDepthStencilAttachment.depthReadOnlyHandle.get(this.`$mem`, 0L) as
                Int).toUInt()
        set(`value`) {
            WGPURenderPassDepthStencilAttachment.depthReadOnlyHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var stencilLoadOp: WGPULoadOp
        get() =
            WGPULoadOp.fromInt(
                WGPURenderPassDepthStencilAttachment.stencilLoadOpHandle.get(
                    this.`$mem`,
                    0L
                ) as Int
            )
        set(`value`) {
            WGPURenderPassDepthStencilAttachment.stencilLoadOpHandle.set(this.`$mem`, 0L, value.value)
        }

    public var stencilStoreOp: WGPUStoreOp
        get() =
            WGPUStoreOp.fromInt(
                WGPURenderPassDepthStencilAttachment.stencilStoreOpHandle.get(
                    this.`$mem`,
                    0L
                ) as Int
            )
        set(`value`) {
            WGPURenderPassDepthStencilAttachment.stencilStoreOpHandle.set(this.`$mem`, 0L, value.value)
        }

    public var stencilClearValue: UInt
        get() = (WGPURenderPassDepthStencilAttachment.stencilClearValueHandle.get(this.`$mem`, 0L) as
                Int).toUInt()
        set(`value`) {
            WGPURenderPassDepthStencilAttachment.stencilClearValueHandle.set(
                this.`$mem`,
                0L, value.toInt()
            )
        }

    public var stencilReadOnly: WGPUBool
        get() = (WGPURenderPassDepthStencilAttachment.stencilReadOnlyHandle.get(this.`$mem`, 0L) as
                Int).toUInt()
        set(`value`) {
            WGPURenderPassDepthStencilAttachment.stencilReadOnlyHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPURenderPassDepthStencilAttachment.layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("view"),
            ValueLayout.JAVA_INT.withName("depthLoadOp"),
            ValueLayout.JAVA_INT.withName("depthStoreOp"),
            ValueLayout.JAVA_FLOAT.withName("depthClearValue"),
            ValueLayout.JAVA_INT.withName("depthReadOnly"),
            ValueLayout.JAVA_INT.withName("stencilLoadOp"),
            ValueLayout.JAVA_INT.withName("stencilStoreOp"),
            ValueLayout.JAVA_INT.withName("stencilClearValue"),
            ValueLayout.JAVA_INT.withName("stencilReadOnly"),
        ).withName("WGPURenderPassDepthStencilAttachment")

        @JvmField
        public val viewHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("view"))

        @JvmField
        public val depthLoadOpHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("depthLoadOp"))

        @JvmField
        public val depthStoreOpHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("depthStoreOp"))

        @JvmField
        public val depthClearValueHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("depthClearValue"))

        @JvmField
        public val depthReadOnlyHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("depthReadOnly"))

        @JvmField
        public val stencilLoadOpHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("stencilLoadOp"))

        @JvmField
        public val stencilStoreOpHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("stencilStoreOp"))

        @JvmField
        public val stencilClearValueHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("stencilClearValue"))

        @JvmField
        public val stencilReadOnlyHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("stencilReadOnly"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPURenderPassDepthStencilAttachment =
            WGPURenderPassDepthStencilAttachment(alloc.allocate(WGPURenderPassDepthStencilAttachment.layout))
    }
}
