// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu

import java.lang.foreign.*
import java.lang.invoke.VarHandle

@JvmInline
public value class WGPUColorTargetState(
    public val `$mem`: MemorySegment,
) {
    public var nextInChain: Pointer<WGPUChainedStruct>
        get() = WGPUColorTargetState.nextInChainHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUColorTargetState.nextInChainHandle.set(this.`$mem`, 0L, value)
        }

    public var format: WGPUTextureFormat
        get() = WGPUTextureFormat.fromInt(WGPUColorTargetState.formatHandle.get(this.`$mem`, 0L) as Int)
        set(`value`) {
            WGPUColorTargetState.formatHandle.set(this.`$mem`, 0L, value.value)
        }

    public var blend: Pointer<WGPUBlendState>
        get() = WGPUColorTargetState.blendHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUColorTargetState.blendHandle.set(this.`$mem`, 0L, value)
        }

    public var writeMask: WGPUColorWriteMaskFlags
        get() = (WGPUColorTargetState.writeMaskHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            WGPUColorTargetState.writeMaskHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPUColorTargetState.layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("nextInChain"),
            ValueLayout.JAVA_INT.withName("format"),
            java.lang.foreign.MemoryLayout.paddingLayout(4),
            `$RuntimeHelper`.POINTER.withName("blend"),
            ValueLayout.JAVA_INT.withName("writeMask"),
            java.lang.foreign.MemoryLayout.paddingLayout(4),
        ).withName("WGPUColorTargetState")

        @JvmField
        public val nextInChainHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("nextInChain"))

        @JvmField
        public val formatHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("format"))

        @JvmField
        public val blendHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("blend"))

        @JvmField
        public val writeMaskHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("writeMask"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUColorTargetState =
            WGPUColorTargetState(alloc.allocate(WGPUColorTargetState.layout))
    }
}
