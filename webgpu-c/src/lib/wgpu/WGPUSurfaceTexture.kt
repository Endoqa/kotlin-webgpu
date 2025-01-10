// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu

import java.lang.foreign.*
import java.lang.invoke.VarHandle

/**
 * Queried each frame from a [WGPUSurface] to get a [WGPUTexture] to render to along with some metadata.
 * See [Surface-Presenting](https://webgpu-native.github.io/webgpu-headers/articles.html) for more details.
 */
@JvmInline
public value class WGPUSurfaceTexture(
    public val `$mem`: MemorySegment,
) {
    public var nextInChain: Pointer<WGPUChainedStruct>
        get() = nextInChainHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            nextInChainHandle.set(this.`$mem`, 0L, value)
        }

    /**
     * The [WGPUTexture] representing the frame that will be shown on the surface.
     * It is [ReturnedWithOwnership](https://webgpu-native.github.io/webgpu-headers/articles.html) from [wgpuSurfaceGetCurrentTexture].
     */
    public var texture: WGPUTexture
        get() = textureHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            textureHandle.set(this.`$mem`, 0L, value)
        }

    /**
     * Whether the call to [wgpuSurfaceGetCurrentTexture] succeeded and a hint as to why it might not have.
     */
    public var status: WGPUSurfaceGetCurrentTextureStatus
        get() = WGPUSurfaceGetCurrentTextureStatus.fromInt(statusHandle.get(this.`$mem`, 0L) as Int)
        set(`value`) {
            statusHandle.set(this.`$mem`, 0L, value.value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("nextInChain"),
            `$RuntimeHelper`.POINTER.withName("texture"),
            ValueLayout.JAVA_INT.withName("status"),
            MemoryLayout.paddingLayout(4),
        ).withName("WGPUSurfaceTexture")

        @JvmField
        public val nextInChainHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("nextInChain"))

        @JvmField
        public val textureHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("texture"))

        @JvmField
        public val statusHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("status"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUSurfaceTexture =
            WGPUSurfaceTexture(alloc.allocate(layout))
    }
}
