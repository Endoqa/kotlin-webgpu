// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu

import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.VarHandle

/**
 * TODO
 */
@JvmInline
public value class WGPUTexelCopyTextureInfo(
    public val `$mem`: MemorySegment,
) {
    /**
     * TODO
     */
    public var texture: WGPUTexture
        get() = textureHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            textureHandle.set(this.`$mem`, 0L, value)
        }

    /**
     * TODO
     */
    public var mipLevel: UInt
        get() = (mipLevelHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            mipLevelHandle.set(this.`$mem`, 0L, value.toInt())
        }

    /**
     * TODO
     */
    public var origin: WGPUOrigin3D
        get() = WGPUOrigin3D(originHandle.invokeExact(this.`$mem`, 0L) as MemorySegment)
        set(`value`) {
            MemorySegment.copy(value.`$mem`, 0L, this.origin.`$mem`, 0L, WGPUOrigin3D.layout.byteSize())
        }

    /**
     * If set to [WGPUTextureAspect.Undefined],
     * [defaults](https://webgpu-native.github.io/webgpu-headers/SentinelValues.html) to [WGPUTextureAspect.All].
     */
    public var aspect: WGPUTextureAspect
        get() = WGPUTextureAspect.fromInt(aspectHandle.get(this.`$mem`, 0L) as Int)
        set(`value`) {
            aspectHandle.set(this.`$mem`, 0L, value.value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("texture"),
            ValueLayout.JAVA_INT.withName("mipLevel"),
            WGPUOrigin3D.layout.withName("origin"),
            ValueLayout.JAVA_INT.withName("aspect"),
            MemoryLayout.paddingLayout(4),
        ).withName("WGPUTexelCopyTextureInfo")

        @JvmField
        public val textureHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("texture"))

        @JvmField
        public val mipLevelHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("mipLevel"))

        @JvmField
        public val originHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("origin"))

        @JvmField
        public val aspectHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("aspect"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUTexelCopyTextureInfo =
            WGPUTexelCopyTextureInfo(alloc.allocate(layout))
    }
}
