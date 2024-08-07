// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c

import java.lang.foreign.*
import java.lang.invoke.MethodHandle

@JvmInline
public value class WGPUAHardwareBufferProperties(
    public val `$mem`: MemorySegment,
) {
    public var yCbCrInfo: WGPUYCbCrVkDescriptor
        get() =
            WGPUYCbCrVkDescriptor(
                yCbCrInfoHandle.invokeExact(
                    this.`$mem`,
                    0L
                ) as MemorySegment
            )
        set(`value`) {
            MemorySegment.copy(
                value.`$mem`, 0L, this.yCbCrInfo.`$mem`, 0L,
                WGPUYCbCrVkDescriptor.layout.byteSize()
            )
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            WGPUYCbCrVkDescriptor.layout.withName("yCbCrInfo"),
        ).withName("WGPUAHardwareBufferProperties")

        @JvmField
        public val yCbCrInfoHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("yCbCrInfo"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUAHardwareBufferProperties =
            WGPUAHardwareBufferProperties(alloc.allocate(layout))
    }
}
