// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu

import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.VarHandle

/**
 * TODO
 */
@JvmInline
public value class WGPUBindGroupLayoutEntry(
    public val `$mem`: MemorySegment,
) {
    public var nextInChain: Pointer<WGPUChainedStruct>
        get() = nextInChainHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            nextInChainHandle.set(this.`$mem`, 0L, value)
        }

    /**
     * TODO
     */
    public var binding: UInt
        get() = (bindingHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            bindingHandle.set(this.`$mem`, 0L, value.toInt())
        }

    /**
     * TODO
     */
    public var visibility: ULong
        get() = (visibilityHandle.get(this.`$mem`, 0L) as Long).toULong()
        set(`value`) {
            visibilityHandle.set(this.`$mem`, 0L, value.toLong())
        }

    /**
     * TODO
     */
    public var buffer: WGPUBufferBindingLayout
        get() = WGPUBufferBindingLayout(
            bufferHandle.invokeExact(
                this.`$mem`,
                0L
            ) as MemorySegment
        )
        set(`value`) {
            MemorySegment.copy(value.`$mem`, 0L, this.buffer.`$mem`, 0L, WGPUBufferBindingLayout.layout.byteSize())
        }

    /**
     * TODO
     */
    public var sampler: WGPUSamplerBindingLayout
        get() = WGPUSamplerBindingLayout(
            samplerHandle.invokeExact(
                this.`$mem`,
                0L
            ) as MemorySegment
        )
        set(`value`) {
            MemorySegment.copy(value.`$mem`, 0L, this.sampler.`$mem`, 0L, WGPUSamplerBindingLayout.layout.byteSize())
        }

    /**
     * TODO
     */
    public var texture: WGPUTextureBindingLayout
        get() = WGPUTextureBindingLayout(
            textureHandle.invokeExact(
                this.`$mem`,
                0L
            ) as MemorySegment
        )
        set(`value`) {
            MemorySegment.copy(value.`$mem`, 0L, this.texture.`$mem`, 0L, WGPUTextureBindingLayout.layout.byteSize())
        }

    /**
     * TODO
     */
    public var storageTexture: WGPUStorageTextureBindingLayout
        get() = WGPUStorageTextureBindingLayout(
            storageTextureHandle.invokeExact(
                this.`$mem`,
                0L
            ) as MemorySegment
        )
        set(`value`) {
            MemorySegment.copy(
                value.`$mem`,
                0L,
                this.storageTexture.`$mem`,
                0L,
                WGPUStorageTextureBindingLayout.layout.byteSize()
            )
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
            ValueLayout.JAVA_LONG.withName("visibility"),
            WGPUBufferBindingLayout.layout.withName("buffer"),
            WGPUSamplerBindingLayout.layout.withName("sampler"),
            WGPUTextureBindingLayout.layout.withName("texture"),
            WGPUStorageTextureBindingLayout.layout.withName("storageTexture"),
        ).withName("WGPUBindGroupLayoutEntry")

        @JvmField
        public val nextInChainHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("nextInChain"))

        @JvmField
        public val bindingHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("binding"))

        @JvmField
        public val visibilityHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("visibility"))

        @JvmField
        public val bufferHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("buffer"))

        @JvmField
        public val samplerHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("sampler"))

        @JvmField
        public val textureHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("texture"))

        @JvmField
        public val storageTextureHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("storageTexture"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUBindGroupLayoutEntry =
            WGPUBindGroupLayoutEntry(alloc.allocate(layout))
    }
}
