// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu

import java.lang.foreign.*

@JvmInline
public value class WGPUBufferImpl(
    public val `$mem`: MemorySegment,
) {
    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
        ).withName("WGPUBufferImpl")

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUBufferImpl =
            WGPUBufferImpl(alloc.allocate(layout))
    }
}
