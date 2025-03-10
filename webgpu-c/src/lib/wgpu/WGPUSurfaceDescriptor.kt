// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu

import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.VarHandle

/**
 * The root descriptor for the creation of an [WGPUSurface] with [wgpuInstanceCreateSurface].
 * It isn't sufficient by itself and must have one of the `WGPUSurfaceSource*` in its chain.
 * See [Surface-Creation](https://webgpu-native.github.io/webgpu-headers/Surfaces.html#Surface-Creation) for more details.
 */
@JvmInline
public value class WGPUSurfaceDescriptor(
    public val `$mem`: MemorySegment,
) {
    public var nextInChain: Pointer<WGPUChainedStruct>
        get() = nextInChainHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            nextInChainHandle.set(this.`$mem`, 0L, value)
        }

    /**
     * Label used to refer to the object.
     */
    public var label: WGPUStringView
        get() = WGPUStringView(labelHandle.invokeExact(this.`$mem`, 0L) as MemorySegment)
        set(`value`) {
            MemorySegment.copy(value.`$mem`, 0L, this.label.`$mem`, 0L, WGPUStringView.layout.byteSize())
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("nextInChain"),
            WGPUStringView.layout.withName("label"),
        ).withName("WGPUSurfaceDescriptor")

        @JvmField
        public val nextInChainHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("nextInChain"))

        @JvmField
        public val labelHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("label"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUSurfaceDescriptor =
            WGPUSurfaceDescriptor(alloc.allocate(layout))
    }
}
