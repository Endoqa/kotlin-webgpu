// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c

import java.lang.foreign.Arena
import java.lang.foreign.MemoryLayout
import java.lang.foreign.MemorySegment
import java.lang.foreign.SegmentAllocator
import java.lang.foreign.StructLayout
import kotlin.Boolean
import kotlin.jvm.JvmInline
import kotlin.jvm.JvmStatic

@JvmInline
public value class WGPUTextureViewImpl(
    public val `$mem`: MemorySegment,
) {
    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPUTextureViewImpl.layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
        ).withName("WGPUTextureViewImpl")

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUTextureViewImpl =
            WGPUTextureViewImpl(alloc.allocate(WGPUTextureViewImpl.layout))
    }
}
