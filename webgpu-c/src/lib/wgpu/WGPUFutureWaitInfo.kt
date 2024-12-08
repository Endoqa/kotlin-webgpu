// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu

import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.VarHandle

/**
 * Struct holding a future to wait on, and a `completed` boolean flag.
 */
@JvmInline
public value class WGPUFutureWaitInfo(
    public val `$mem`: MemorySegment,
) {
    /**
     * The future to wait on.
     */
    public var future: WGPUFuture
        get() = WGPUFuture(futureHandle.invokeExact(this.`$mem`, 0L) as MemorySegment)
        set(`value`) {
            MemorySegment.copy(value.`$mem`, 0L, this.future.`$mem`, 0L, WGPUFuture.layout.byteSize())
        }

    /**
     * Whether or not the future completed.
     */
    public var completed: WGPUBool
        get() = (completedHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            completedHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            WGPUFuture.layout.withName("future"),
            ValueLayout.JAVA_INT.withName("completed"),
            MemoryLayout.paddingLayout(4),
        ).withName("WGPUFutureWaitInfo")

        @JvmField
        public val futureHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("future"))

        @JvmField
        public val completedHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("completed"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUFutureWaitInfo =
            WGPUFutureWaitInfo(alloc.allocate(layout))
    }
}
