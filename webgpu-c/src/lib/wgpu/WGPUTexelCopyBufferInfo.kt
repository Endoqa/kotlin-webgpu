// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu

import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.VarHandle

/**
 * TODO
 */
@JvmInline
public value class WGPUTexelCopyBufferInfo(
    public val `$mem`: MemorySegment,
) {
    /**
     * TODO
     */
    public var layout: WGPUTexelCopyBufferLayout
        get() = WGPUTexelCopyBufferLayout(
            layoutHandle.invokeExact(
                this.`$mem`,
                0L
            ) as MemorySegment
        )
        set(`value`) {
            MemorySegment.copy(value.`$mem`, 0L, this.layout.`$mem`, 0L, WGPUTexelCopyBufferLayout.layout.byteSize())
        }

    /**
     * TODO
     */
    public var buffer: WGPUBuffer
        get() = bufferHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            bufferHandle.set(this.`$mem`, 0L, value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPUTexelCopyBufferInfo.layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            WGPUTexelCopyBufferLayout.layout.withName("layout"),
            `$RuntimeHelper`.POINTER.withName("buffer"),
        ).withName("WGPUTexelCopyBufferInfo")

        @JvmField
        public val layoutHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("layout"))

        @JvmField
        public val bufferHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("buffer"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUTexelCopyBufferInfo =
            WGPUTexelCopyBufferInfo(alloc.allocate(layout))
    }
}
