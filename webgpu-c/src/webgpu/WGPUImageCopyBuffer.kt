// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu

import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.VarHandle

@JvmInline
public value class WGPUImageCopyBuffer(
    public val `$mem`: MemorySegment,
) {
    public var layout: WGPUTextureDataLayout
        get() = WGPUTextureDataLayout(
            WGPUImageCopyBuffer.layoutHandle.invokeExact(this.`$mem`, 0L) as
                    MemorySegment
        )
        set(`value`) {
            MemorySegment.copy(
                value.`$mem`, 0L, this.layout.`$mem`, 0L,
                WGPUTextureDataLayout.layout.byteSize()
            )
        }

    public var buffer: WGPUBuffer
        get() = WGPUImageCopyBuffer.bufferHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUImageCopyBuffer.bufferHandle.set(this.`$mem`, 0L, value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPUImageCopyBuffer.layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            WGPUTextureDataLayout.layout.withName("layout"),
            `$RuntimeHelper`.POINTER.withName("buffer"),
        ).withName("WGPUImageCopyBuffer")

        @JvmField
        public val layoutHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("layout"))

        @JvmField
        public val bufferHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("buffer"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUImageCopyBuffer =
            WGPUImageCopyBuffer(alloc.allocate(WGPUImageCopyBuffer.layout))
    }
}
