// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu

import java.lang.foreign.*
import java.lang.invoke.VarHandle

/**
 * TODO
 */
@JvmInline
public value class WGPUBindGroupEntry(
    public val `$mem`: MemorySegment,
) {
    public var nextInChain: Pointer<WGPUChainedStruct>
        get() = nextInChainHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            nextInChainHandle.set(this.`$mem`, 0L, value)
        }

    /**
     * Binding index in the bind group.
     */
    public var binding: UInt
        get() = (bindingHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            bindingHandle.set(this.`$mem`, 0L, value.toInt())
        }

    /**
     * Set this if the binding is a buffer object.
     * Otherwise must be null.
     */
    public var buffer: WGPUBuffer
        get() = bufferHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            bufferHandle.set(this.`$mem`, 0L, value)
        }

    /**
     * If the binding is a buffer, this is the byte offset of the binding range.
     * Otherwise ignored.
     */
    public var offset: ULong
        get() = (offsetHandle.get(this.`$mem`, 0L) as Long).toULong()
        set(`value`) {
            offsetHandle.set(this.`$mem`, 0L, value.toLong())
        }

    /**
     * If the binding is a buffer, this is the byte size of the binding range
     * (@ref WGPU_WHOLE_SIZE means the binding ends at the end of the buffer).
     * Otherwise ignored.
     */
    public var size: ULong
        get() = (sizeHandle.get(this.`$mem`, 0L) as Long).toULong()
        set(`value`) {
            sizeHandle.set(this.`$mem`, 0L, value.toLong())
        }

    /**
     * Set this if the binding is a sampler object.
     * Otherwise must be null.
     */
    public var sampler: WGPUSampler
        get() = samplerHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            samplerHandle.set(this.`$mem`, 0L, value)
        }

    /**
     * Set this if the binding is a texture view object.
     * Otherwise must be null.
     */
    public var textureView: WGPUTextureView
        get() = textureViewHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            textureViewHandle.set(this.`$mem`, 0L, value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("nextInChain"),
            ValueLayout.JAVA_INT.withName("binding"),
            MemoryLayout.paddingLayout(4),
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
            WGPUBindGroupEntry(alloc.allocate(layout))
    }
}
