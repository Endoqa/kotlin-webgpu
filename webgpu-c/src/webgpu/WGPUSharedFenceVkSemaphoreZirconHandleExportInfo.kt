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
import kotlin.Int
import kotlin.jvm.JvmField
import kotlin.jvm.JvmInline
import kotlin.jvm.JvmStatic

@JvmInline
public value class WGPUSharedFenceVkSemaphoreZirconHandleExportInfo(
    public val `$mem`: MemorySegment,
) {
    public var chain: WGPUChainedStructOut
        get() =
            WGPUChainedStructOut(
                chainHandle.invokeExact(
                    this.`$mem`,
                    0L
                ) as MemorySegment
            )
        set(`value`) {
            MemorySegment.copy(
                value.`$mem`, 0L, this.chain.`$mem`, 0L,
                WGPUChainedStructOut.layout.byteSize()
            )
        }

    public var handle: uint32_t
        get() = (handleHandle.get(this.`$mem`, 0L) as
                Int).toUInt()
        set(`value`) {
            handleHandle.set(
                this.`$mem`,
                0L, value.toInt()
            )
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            WGPUChainedStructOut.layout.withName("chain"),
            ValueLayout.JAVA_INT.withName("handle"),
            MemoryLayout.paddingLayout(4),
        ).withName("WGPUSharedFenceVkSemaphoreZirconHandleExportInfo")

        @JvmField
        public val chainHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("chain"))

        @JvmField
        public val handleHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("handle"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUSharedFenceVkSemaphoreZirconHandleExportInfo =
            WGPUSharedFenceVkSemaphoreZirconHandleExportInfo(
                alloc.allocate(
                    layout
                )
            )
    }
}
