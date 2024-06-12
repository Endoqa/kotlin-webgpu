// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu

import java.lang.foreign.*
import java.lang.invoke.VarHandle

@JvmInline
public value class WGPURenderBundleDescriptor(
    public val `$mem`: MemorySegment,
) {
    public var nextInChain: Pointer<WGPUChainedStruct>
        get() = WGPURenderBundleDescriptor.nextInChainHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPURenderBundleDescriptor.nextInChainHandle.set(this.`$mem`, 0L, value)
        }

    public var label: Pointer<Byte>
        get() = WGPURenderBundleDescriptor.labelHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPURenderBundleDescriptor.labelHandle.set(this.`$mem`, 0L, value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPURenderBundleDescriptor.layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("nextInChain"),
            `$RuntimeHelper`.POINTER.withName("label"),
        ).withName("WGPURenderBundleDescriptor")

        @JvmField
        public val nextInChainHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("nextInChain"))

        @JvmField
        public val labelHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("label"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPURenderBundleDescriptor =
            WGPURenderBundleDescriptor(alloc.allocate(WGPURenderBundleDescriptor.layout))
    }
}
