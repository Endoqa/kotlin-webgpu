// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu

import java.lang.foreign.*
import java.lang.invoke.VarHandle

/**
 * TODO
 */
@JvmInline
public value class WGPUPrimitiveState(
    public val `$mem`: MemorySegment,
) {
    public var nextInChain: Pointer<WGPUChainedStruct>
        get() = nextInChainHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            nextInChainHandle.set(this.`$mem`, 0L, value)
        }

    /**
     * If set to [WGPUPrimitiveTopology.Undefined],
     * [defaults](https://webgpu-native.github.io/webgpu-headers/articles.html) to [WGPUPrimitiveTopology.TriangleList].
     */
    public var topology: WGPUPrimitiveTopology
        get() = WGPUPrimitiveTopology.fromInt(topologyHandle.get(this.`$mem`, 0L) as Int)
        set(`value`) {
            topologyHandle.set(this.`$mem`, 0L, value.value)
        }

    /**
     * TODO
     */
    public var stripIndexFormat: WGPUIndexFormat
        get() = WGPUIndexFormat.fromInt(stripIndexFormatHandle.get(this.`$mem`, 0L) as Int)
        set(`value`) {
            stripIndexFormatHandle.set(this.`$mem`, 0L, value.value)
        }

    /**
     * If set to [WGPUFrontFace.Undefined],
     * [defaults](https://webgpu-native.github.io/webgpu-headers/articles.html) to [WGPUFrontFace.CCW].
     */
    public var frontFace: WGPUFrontFace
        get() = WGPUFrontFace.fromInt(frontFaceHandle.get(this.`$mem`, 0L) as Int)
        set(`value`) {
            frontFaceHandle.set(this.`$mem`, 0L, value.value)
        }

    /**
     * If set to [WGPUCullMode.Undefined],
     * [defaults](https://webgpu-native.github.io/webgpu-headers/articles.html) to [WGPUCullMode.None].
     */
    public var cullMode: WGPUCullMode
        get() = WGPUCullMode.fromInt(cullModeHandle.get(this.`$mem`, 0L) as Int)
        set(`value`) {
            cullModeHandle.set(this.`$mem`, 0L, value.value)
        }

    /**
     * TODO
     */
    public var unclippedDepth: WGPUBool
        get() = (unclippedDepthHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            unclippedDepthHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("nextInChain"),
            ValueLayout.JAVA_INT.withName("topology"),
            ValueLayout.JAVA_INT.withName("stripIndexFormat"),
            ValueLayout.JAVA_INT.withName("frontFace"),
            ValueLayout.JAVA_INT.withName("cullMode"),
            ValueLayout.JAVA_INT.withName("unclippedDepth"),
            MemoryLayout.paddingLayout(4),
        ).withName("WGPUPrimitiveState")

        @JvmField
        public val nextInChainHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("nextInChain"))

        @JvmField
        public val topologyHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("topology"))

        @JvmField
        public val stripIndexFormatHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("stripIndexFormat"))

        @JvmField
        public val frontFaceHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("frontFace"))

        @JvmField
        public val cullModeHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("cullMode"))

        @JvmField
        public val unclippedDepthHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("unclippedDepth"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUPrimitiveState =
            WGPUPrimitiveState(alloc.allocate(layout))
    }
}
