// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu

import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.VarHandle

@JvmInline
public value class WGPUDawnTextureInternalUsageDescriptor(
    public val `$mem`: MemorySegment,
) {
    public var chain: WGPUChainedStruct
        get() =
            WGPUChainedStruct(
                WGPUDawnTextureInternalUsageDescriptor.chainHandle.invokeExact(
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

    public var internalUsage: WGPUTextureUsageFlags
        get() = (WGPUDawnTextureInternalUsageDescriptor.internalUsageHandle.get(this.`$mem`, 0L) as
                Int).toUInt()
        set(`value`) {
            WGPUDawnTextureInternalUsageDescriptor.internalUsageHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPUDawnTextureInternalUsageDescriptor.layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            WGPUChainedStruct.layout.withName("chain"),
            ValueLayout.JAVA_INT.withName("internalUsage"),
            java.lang.foreign.MemoryLayout.paddingLayout(4),
        ).withName("WGPUDawnTextureInternalUsageDescriptor")

        @JvmField
        public val chainHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("chain"))

        @JvmField
        public val internalUsageHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("internalUsage"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUDawnTextureInternalUsageDescriptor =
            WGPUDawnTextureInternalUsageDescriptor(alloc.allocate(WGPUDawnTextureInternalUsageDescriptor.layout))
    }
}
