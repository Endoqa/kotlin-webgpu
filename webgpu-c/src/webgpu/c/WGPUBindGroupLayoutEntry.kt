// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c

import java.lang.foreign.Arena
import java.lang.foreign.MemoryLayout
import java.lang.foreign.MemorySegment
import java.lang.foreign.SegmentAllocator
import java.lang.foreign.StructLayout
import java.lang.foreign.ValueLayout
import java.lang.invoke.MethodHandle
import java.lang.invoke.VarHandle
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.UInt
import kotlin.jvm.JvmField
import kotlin.jvm.JvmInline
import kotlin.jvm.JvmStatic

@JvmInline
public value class WGPUBindGroupLayoutEntry(
    public val `$mem`: MemorySegment,
) {
    public var nextInChain: Pointer<WGPUChainedStruct>
        get() = WGPUBindGroupLayoutEntry.nextInChainHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUBindGroupLayoutEntry.nextInChainHandle.set(this.`$mem`, 0L, value)
        }

    public var binding: UInt
        get() = (WGPUBindGroupLayoutEntry.bindingHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            WGPUBindGroupLayoutEntry.bindingHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var visibility: WGPUShaderStage
        get() = (WGPUBindGroupLayoutEntry.visibilityHandle.get(this.`$mem`, 0L) as Long).toULong()
        set(`value`) {
            WGPUBindGroupLayoutEntry.visibilityHandle.set(this.`$mem`, 0L, value.toLong())
        }

    public var buffer: WGPUBufferBindingLayout
        get() = WGPUBufferBindingLayout(
            WGPUBindGroupLayoutEntry.bufferHandle.invokeExact(
                this.`$mem`,
                0L
            ) as MemorySegment
        )
        set(`value`) {
            MemorySegment.copy(
                value.`$mem`, 0L, this.buffer.`$mem`, 0L,
                WGPUBufferBindingLayout.layout.byteSize()
            )
        }

    public var sampler: WGPUSamplerBindingLayout
        get() = WGPUSamplerBindingLayout(
            WGPUBindGroupLayoutEntry.samplerHandle.invokeExact(
                this.`$mem`,
                0L
            ) as MemorySegment
        )
        set(`value`) {
            MemorySegment.copy(
                value.`$mem`, 0L, this.sampler.`$mem`, 0L,
                WGPUSamplerBindingLayout.layout.byteSize()
            )
        }

    public var texture: WGPUTextureBindingLayout
        get() = WGPUTextureBindingLayout(
            WGPUBindGroupLayoutEntry.textureHandle.invokeExact(
                this.`$mem`,
                0L
            ) as MemorySegment
        )
        set(`value`) {
            MemorySegment.copy(
                value.`$mem`, 0L, this.texture.`$mem`, 0L,
                WGPUTextureBindingLayout.layout.byteSize()
            )
        }

    public var storageTexture: WGPUStorageTextureBindingLayout
        get() =
            WGPUStorageTextureBindingLayout(
                WGPUBindGroupLayoutEntry.storageTextureHandle.invokeExact(
                    this.`$mem`,
                    0L
                ) as MemorySegment
            )
        set(`value`) {
            MemorySegment.copy(
                value.`$mem`, 0L, this.storageTexture.`$mem`, 0L,
                WGPUStorageTextureBindingLayout.layout.byteSize()
            )
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPUBindGroupLayoutEntry.layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("nextInChain"),
            ValueLayout.JAVA_INT.withName("binding"),
            java.lang.foreign.MemoryLayout.paddingLayout(4),
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
            WGPUBindGroupLayoutEntry(alloc.allocate(WGPUBindGroupLayoutEntry.layout))
    }
}
