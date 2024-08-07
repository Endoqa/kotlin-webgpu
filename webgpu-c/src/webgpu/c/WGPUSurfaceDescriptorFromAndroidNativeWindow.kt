// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c

import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.VarHandle

@JvmInline
public value class WGPUSurfaceDescriptorFromAndroidNativeWindow(
    public val `$mem`: MemorySegment,
) {
    public var chain: WGPUChainedStruct
        get() =
            WGPUChainedStruct(
                chainHandle.invokeExact(
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

    public var window: Pointer<Unit>
        get() = windowHandle.get(this.`$mem`, 0L) as
                MemorySegment
        set(`value`) {
            windowHandle.set(this.`$mem`, 0L, value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            WGPUChainedStruct.layout.withName("chain"),
            `$RuntimeHelper`.POINTER.withName("window"),
        ).withName("WGPUSurfaceDescriptorFromAndroidNativeWindow")

        @JvmField
        public val chainHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("chain"))

        @JvmField
        public val windowHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("window"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUSurfaceDescriptorFromAndroidNativeWindow =
            WGPUSurfaceDescriptorFromAndroidNativeWindow(alloc.allocate(layout))
    }
}
