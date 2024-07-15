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
public value class WGPUSharedTextureMemoryVkImageLayoutEndState(
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

    public var oldLayout: int32_t
        get() = oldLayoutHandle.get(this.`$mem`, 0L) as Int
        set(`value`) {
            oldLayoutHandle.set(this.`$mem`, 0L, value)
        }

    public var newLayout: int32_t
        get() = newLayoutHandle.get(this.`$mem`, 0L) as Int
        set(`value`) {
            newLayoutHandle.set(this.`$mem`, 0L, value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            WGPUChainedStructOut.layout.withName("chain"),
            ValueLayout.JAVA_INT.withName("oldLayout"),
            ValueLayout.JAVA_INT.withName("newLayout"),
        ).withName("WGPUSharedTextureMemoryVkImageLayoutEndState")

        @JvmField
        public val chainHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("chain"))

        @JvmField
        public val oldLayoutHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("oldLayout"))

        @JvmField
        public val newLayoutHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("newLayout"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUSharedTextureMemoryVkImageLayoutEndState =
            WGPUSharedTextureMemoryVkImageLayoutEndState(alloc.allocate(layout))
    }
}
