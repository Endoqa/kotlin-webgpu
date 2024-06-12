// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu

import java.lang.foreign.*
import java.lang.invoke.VarHandle

@JvmInline
public value class WGPUFuture(
    public val `$mem`: MemorySegment,
) {
    public var id: uint64_t
        get() = (WGPUFuture.idHandle.get(this.`$mem`, 0L) as Long).toULong()
        set(`value`) {
            WGPUFuture.idHandle.set(this.`$mem`, 0L, value.toLong())
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPUFuture.layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            ValueLayout.JAVA_LONG.withName("id"),
        ).withName("WGPUFuture")

        @JvmField
        public val idHandle: VarHandle = layout.varHandle(MemoryLayout.PathElement.groupElement("id"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUFuture =
            WGPUFuture(alloc.allocate(WGPUFuture.layout))
    }
}
