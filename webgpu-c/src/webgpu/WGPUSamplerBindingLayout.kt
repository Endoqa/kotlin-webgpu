// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu

import java.lang.foreign.*
import java.lang.invoke.VarHandle

@JvmInline
public value class WGPUSamplerBindingLayout(
    public val `$mem`: MemorySegment,
) {
    public var nextInChain: Pointer<WGPUChainedStruct>
        get() = WGPUSamplerBindingLayout.nextInChainHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUSamplerBindingLayout.nextInChainHandle.set(this.`$mem`, 0L, value)
        }

    public var type: WGPUSamplerBindingType
        get() = WGPUSamplerBindingType.fromInt(
            WGPUSamplerBindingLayout.typeHandle.get(this.`$mem`, 0L)
                    as Int
        )
        set(`value`) {
            WGPUSamplerBindingLayout.typeHandle.set(this.`$mem`, 0L, value.value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPUSamplerBindingLayout.layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("nextInChain"),
            ValueLayout.JAVA_INT.withName("type"),
            java.lang.foreign.MemoryLayout.paddingLayout(4),
        ).withName("WGPUSamplerBindingLayout")

        @JvmField
        public val nextInChainHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("nextInChain"))

        @JvmField
        public val typeHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("type"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUSamplerBindingLayout =
            WGPUSamplerBindingLayout(alloc.allocate(WGPUSamplerBindingLayout.layout))
    }
}
