// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c

import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.VarHandle

@JvmInline
public value class WGPUImageCopyExternalTexture(
    public val `$mem`: MemorySegment,
) {
    public var nextInChain: Pointer<WGPUChainedStruct>
        get() = nextInChainHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            nextInChainHandle.set(this.`$mem`, 0L, value)
        }

    public var externalTexture: WGPUExternalTexture
        get() = externalTextureHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            externalTextureHandle.set(this.`$mem`, 0L, value)
        }

    public var origin: WGPUOrigin3D
        get() = WGPUOrigin3D(
            originHandle.invokeExact(this.`$mem`, 0L) as
                    MemorySegment
        )
        set(`value`) {
            MemorySegment.copy(value.`$mem`, 0L, this.origin.`$mem`, 0L, WGPUOrigin3D.layout.byteSize())
        }

    public var naturalSize: WGPUExtent2D
        get() = WGPUExtent2D(
            naturalSizeHandle.invokeExact(this.`$mem`, 0L)
                    as MemorySegment
        )
        set(`value`) {
            MemorySegment.copy(
                value.`$mem`, 0L, this.naturalSize.`$mem`, 0L,
                WGPUExtent2D.layout.byteSize()
            )
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("nextInChain"),
            `$RuntimeHelper`.POINTER.withName("externalTexture"),
            WGPUOrigin3D.layout.withName("origin"),
            WGPUExtent2D.layout.withName("naturalSize"),
            MemoryLayout.paddingLayout(4),
        ).withName("WGPUImageCopyExternalTexture")

        @JvmField
        public val nextInChainHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("nextInChain"))

        @JvmField
        public val externalTextureHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("externalTexture"))

        @JvmField
        public val originHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("origin"))

        @JvmField
        public val naturalSizeHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("naturalSize"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUImageCopyExternalTexture =
            WGPUImageCopyExternalTexture(alloc.allocate(layout))
    }
}
