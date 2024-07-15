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
public value class WGPUSharedTextureMemoryD3DSwapchainBeginState(
    public val `$mem`: MemorySegment,
) {
    public var chain: WGPUChainedStruct
        get() =
            WGPUChainedStruct(
                chainHandle.invokeExact(
                    this.`$mem`,
                    0L
                ) as MemorySegment
            )
        set(`value`) {
            MemorySegment.copy(
                value.`$mem`, 0L, this.chain.`$mem`, 0L,
                WGPUChainedStruct.layout.byteSize()
            )
        }

    public var isSwapchain: WGPUBool
        get() = (isSwapchainHandle.get(this.`$mem`, 0L) as
                Int).toUInt()
        set(`value`) {
            isSwapchainHandle.set(
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
            WGPUChainedStruct.layout.withName("chain"),
            ValueLayout.JAVA_INT.withName("isSwapchain"),
            MemoryLayout.paddingLayout(4),
        ).withName("WGPUSharedTextureMemoryD3DSwapchainBeginState")

        @JvmField
        public val chainHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("chain"))

        @JvmField
        public val isSwapchainHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("isSwapchain"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUSharedTextureMemoryD3DSwapchainBeginState =
            WGPUSharedTextureMemoryD3DSwapchainBeginState(alloc.allocate(layout))
    }
}
