// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu

import java.lang.foreign.*

@JvmInline
public value class WGPUAdapterImpl(
    public val `$mem`: MemorySegment,
) {
    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPUAdapterImpl.layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
        ).withName("WGPUAdapterImpl")

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUAdapterImpl =
            WGPUAdapterImpl(alloc.allocate(WGPUAdapterImpl.layout))
    }
}
