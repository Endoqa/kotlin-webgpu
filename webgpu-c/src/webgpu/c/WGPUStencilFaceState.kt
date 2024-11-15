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
import kotlin.Int
import kotlin.jvm.JvmField
import kotlin.jvm.JvmInline
import kotlin.jvm.JvmStatic

@JvmInline
public value class WGPUStencilFaceState(
    public val `$mem`: MemorySegment,
) {
    public var compare: WGPUCompareFunction
        get() = WGPUCompareFunction.fromInt(
            WGPUStencilFaceState.compareHandle.get(this.`$mem`, 0L) as
                    Int
        )
        set(`value`) {
            WGPUStencilFaceState.compareHandle.set(this.`$mem`, 0L, value.value)
        }

    public var failOp: WGPUStencilOperation
        get() = WGPUStencilOperation.fromInt(
            WGPUStencilFaceState.failOpHandle.get(this.`$mem`, 0L) as
                    Int
        )
        set(`value`) {
            WGPUStencilFaceState.failOpHandle.set(this.`$mem`, 0L, value.value)
        }

    public var depthFailOp: WGPUStencilOperation
        get() = WGPUStencilOperation.fromInt(
            WGPUStencilFaceState.depthFailOpHandle.get(this.`$mem`, 0L)
                    as Int
        )
        set(`value`) {
            WGPUStencilFaceState.depthFailOpHandle.set(this.`$mem`, 0L, value.value)
        }

    public var passOp: WGPUStencilOperation
        get() = WGPUStencilOperation.fromInt(
            WGPUStencilFaceState.passOpHandle.get(this.`$mem`, 0L) as
                    Int
        )
        set(`value`) {
            WGPUStencilFaceState.passOpHandle.set(this.`$mem`, 0L, value.value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPUStencilFaceState.layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            ValueLayout.JAVA_INT.withName("compare"),
            ValueLayout.JAVA_INT.withName("failOp"),
            ValueLayout.JAVA_INT.withName("depthFailOp"),
            ValueLayout.JAVA_INT.withName("passOp"),
        ).withName("WGPUStencilFaceState")

        @JvmField
        public val compareHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("compare"))

        @JvmField
        public val failOpHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("failOp"))

        @JvmField
        public val depthFailOpHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("depthFailOp"))

        @JvmField
        public val passOpHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("passOp"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUStencilFaceState =
            WGPUStencilFaceState(alloc.allocate(WGPUStencilFaceState.layout))
    }
}
