// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c

import java.lang.foreign.Arena
import java.lang.foreign.MemoryLayout
import java.lang.foreign.MemorySegment
import java.lang.foreign.SegmentAllocator
import java.lang.foreign.StructLayout
import java.lang.invoke.MethodHandle
import java.lang.invoke.VarHandle
import kotlin.Boolean
import kotlin.jvm.JvmField
import kotlin.jvm.JvmInline
import kotlin.jvm.JvmStatic

@JvmInline
public value class WGPUInstanceDescriptor(
    public val `$mem`: MemorySegment,
) {
    public var nextInChain: Pointer<WGPUChainedStruct>
        get() = WGPUInstanceDescriptor.nextInChainHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUInstanceDescriptor.nextInChainHandle.set(this.`$mem`, 0L, value)
        }

    public var features: WGPUInstanceCapabilities
        get() = WGPUInstanceCapabilities(
            WGPUInstanceDescriptor.featuresHandle.invokeExact(
                this.`$mem`,
                0L
            ) as MemorySegment
        )
        set(`value`) {
            MemorySegment.copy(
                value.`$mem`, 0L, this.features.`$mem`, 0L,
                WGPUInstanceCapabilities.layout.byteSize()
            )
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPUInstanceDescriptor.layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("nextInChain"),
            WGPUInstanceCapabilities.layout.withName("features"),
        ).withName("WGPUInstanceDescriptor")

        @JvmField
        public val nextInChainHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("nextInChain"))

        @JvmField
        public val featuresHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("features"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUInstanceDescriptor =
            WGPUInstanceDescriptor(alloc.allocate(WGPUInstanceDescriptor.layout))
    }
}
