// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c

import java.lang.foreign.*

@JvmInline
public value class WGPUINTERNAL__HAVE_EMDAWNWEBGPU_HEADER(
    public val `$mem`: MemorySegment,
) {
    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
        ).withName("WGPUINTERNAL__HAVE_EMDAWNWEBGPU_HEADER")

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUINTERNAL__HAVE_EMDAWNWEBGPU_HEADER =
            WGPUINTERNAL__HAVE_EMDAWNWEBGPU_HEADER(alloc.allocate(layout))
    }
}
