// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu

import java.lang.foreign.*
import java.lang.invoke.VarHandle

/**
 * TODO
 */
@JvmInline
public value class WGPURenderPassDepthStencilAttachment(
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
    public var view: WGPUTextureView
        get() = viewHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            viewHandle.set(this.`$mem`, 0L, value)
        }

    /**
     * TODO
     */
    public var depthLoadOp: WGPULoadOp
        get() = WGPULoadOp.fromInt(depthLoadOpHandle.get(this.`$mem`, 0L) as Int)
        set(`value`) {
            depthLoadOpHandle.set(this.`$mem`, 0L, value.value)
        }

    /**
     * TODO
     */
    public var depthStoreOp: WGPUStoreOp
        get() = WGPUStoreOp.fromInt(depthStoreOpHandle.get(this.`$mem`, 0L) as Int)
        set(`value`) {
            depthStoreOpHandle.set(this.`$mem`, 0L, value.value)
        }

    /**
     * This is a [NullableFloatingPointType](https://webgpu-native.github.io/webgpu-headers/articles.html).
     *
     * If [NaN], indicates an [undefined] value (as defined by the JS spec).
     * Use [WGPU_DEPTH_CLEAR_VALUE.UNDEFINED] to indicate this semantically.
     *
     * If infinite, produces a [NonFiniteFloatValueError](https://webgpu-native.github.io/webgpu-headers/articles.html).
     */
    public var depthClearValue: Float
        get() = depthClearValueHandle.get(this.`$mem`, 0L) as Float
        set(`value`) {
            depthClearValueHandle.set(this.`$mem`, 0L, value)
        }

    /**
     * TODO
     */
    public var depthReadOnly: WGPUBool
        get() = (depthReadOnlyHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            depthReadOnlyHandle.set(this.`$mem`, 0L, value.toInt())
        }

    /**
     * TODO
     */
    public var stencilLoadOp: WGPULoadOp
        get() = WGPULoadOp.fromInt(stencilLoadOpHandle.get(this.`$mem`, 0L) as Int)
        set(`value`) {
            stencilLoadOpHandle.set(this.`$mem`, 0L, value.value)
        }

    /**
     * TODO
     */
    public var stencilStoreOp: WGPUStoreOp
        get() = WGPUStoreOp.fromInt(
            stencilStoreOpHandle.get(
                this.`$mem`,
                0L
            ) as Int
        )
        set(`value`) {
            stencilStoreOpHandle.set(this.`$mem`, 0L, value.value)
        }

    /**
     * TODO
     */
    public var stencilClearValue: UInt
        get() = (stencilClearValueHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            stencilClearValueHandle.set(this.`$mem`, 0L, value.toInt())
        }

    /**
     * TODO
     */
    public var stencilReadOnly: WGPUBool
        get() = (stencilReadOnlyHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            stencilReadOnlyHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("nextInChain"),
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
        public val nextInChainHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("nextInChain"))

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
            WGPURenderPassDepthStencilAttachment(alloc.allocate(layout))
    }
}
