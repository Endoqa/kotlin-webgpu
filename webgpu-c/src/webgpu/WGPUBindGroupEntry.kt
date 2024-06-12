// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu

import java.lang.foreign.*
import java.lang.invoke.VarHandle

@JvmInline
public value class WGPUBindGroupEntry(
    public val `$mem`: MemorySegment,
) {
    public var nextInChain: Pointer<WGPUChainedStruct>
        get() = WGPUBindGroupEntry.nextInChainHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUBindGroupEntry.nextInChainHandle.set(this.`$mem`, 0L, value)
        }

    public var binding: uint32_t
        get() = (WGPUBindGroupEntry.bindingHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            WGPUBindGroupEntry.bindingHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var buffer: WGPUBuffer
        get() = WGPUBindGroupEntry.bufferHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUBindGroupEntry.bufferHandle.set(this.`$mem`, 0L, value)
        }

    public var offset: uint64_t
        get() = (WGPUBindGroupEntry.offsetHandle.get(this.`$mem`, 0L) as Long).toULong()
        set(`value`) {
            WGPUBindGroupEntry.offsetHandle.set(this.`$mem`, 0L, value.toLong())
        }

    public var size: uint64_t
        get() = (WGPUBindGroupEntry.sizeHandle.get(this.`$mem`, 0L) as Long).toULong()
        set(`value`) {
            WGPUBindGroupEntry.sizeHandle.set(this.`$mem`, 0L, value.toLong())
        }

    public var sampler: WGPUSampler
        get() = WGPUBindGroupEntry.samplerHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUBindGroupEntry.samplerHandle.set(this.`$mem`, 0L, value)
        }

    public var textureView: WGPUTextureView
        get() = WGPUBindGroupEntry.textureViewHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUBindGroupEntry.textureViewHandle.set(this.`$mem`, 0L, value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPUBindGroupEntry.layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("nextInChain"),
            ValueLayout.JAVA_INT.withName("binding"),
            java.lang.foreign.MemoryLayout.paddingLayout(4),
            `$RuntimeHelper`.POINTER.withName("buffer"),
            ValueLayout.JAVA_LONG.withName("offset"),
            ValueLayout.JAVA_LONG.withName("size"),
            `$RuntimeHelper`.POINTER.withName("sampler"),
            `$RuntimeHelper`.POINTER.withName("textureView"),
        ).withName("WGPUBindGroupEntry")

        @JvmField
        public val nextInChainHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("nextInChain"))

        @JvmField
        public val bindingHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("binding"))

        @JvmField
        public val bufferHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("buffer"))

        @JvmField
        public val offsetHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("offset"))

        @JvmField
        public val sizeHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("size"))

        @JvmField
        public val samplerHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("sampler"))

        @JvmField
        public val textureViewHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("textureView"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUBindGroupEntry =
            WGPUBindGroupEntry(alloc.allocate(WGPUBindGroupEntry.layout))
    }
}