// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu

import java.lang.foreign.*
import java.lang.invoke.VarHandle

@JvmInline
public value class WGPUPrimitiveState(
    public val `$mem`: MemorySegment,
) {
    public var nextInChain: Pointer<WGPUChainedStruct>
        get() = WGPUPrimitiveState.nextInChainHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUPrimitiveState.nextInChainHandle.set(this.`$mem`, 0L, value)
        }

    public var topology: WGPUPrimitiveTopology
        get() = WGPUPrimitiveTopology.fromInt(
            WGPUPrimitiveState.topologyHandle.get(this.`$mem`, 0L) as
                    Int
        )
        set(`value`) {
            WGPUPrimitiveState.topologyHandle.set(this.`$mem`, 0L, value.value)
        }

    public var stripIndexFormat: WGPUIndexFormat
        get() = WGPUIndexFormat.fromInt(
            WGPUPrimitiveState.stripIndexFormatHandle.get(this.`$mem`, 0L)
                    as Int
        )
        set(`value`) {
            WGPUPrimitiveState.stripIndexFormatHandle.set(this.`$mem`, 0L, value.value)
        }

    public var frontFace: WGPUFrontFace
        get() = WGPUFrontFace.fromInt(WGPUPrimitiveState.frontFaceHandle.get(this.`$mem`, 0L) as Int)
        set(`value`) {
            WGPUPrimitiveState.frontFaceHandle.set(this.`$mem`, 0L, value.value)
        }

    public var cullMode: WGPUCullMode
        get() = WGPUCullMode.fromInt(WGPUPrimitiveState.cullModeHandle.get(this.`$mem`, 0L) as Int)
        set(`value`) {
            WGPUPrimitiveState.cullModeHandle.set(this.`$mem`, 0L, value.value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPUPrimitiveState.layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("nextInChain"),
            ValueLayout.JAVA_INT.withName("topology"),
            ValueLayout.JAVA_INT.withName("stripIndexFormat"),
            ValueLayout.JAVA_INT.withName("frontFace"),
            ValueLayout.JAVA_INT.withName("cullMode"),
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

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUPrimitiveState =
            WGPUPrimitiveState(alloc.allocate(WGPUPrimitiveState.layout))
    }
}
