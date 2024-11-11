// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c

import java.lang.foreign.Arena
import java.lang.foreign.MemoryLayout
import java.lang.foreign.MemorySegment
import java.lang.foreign.SegmentAllocator
import java.lang.foreign.StructLayout
import java.lang.foreign.ValueLayout
import java.lang.invoke.VarHandle
import kotlin.Boolean
import kotlin.Int
import kotlin.jvm.JvmField
import kotlin.jvm.JvmInline
import kotlin.jvm.JvmStatic

@JvmInline
public value class WGPUStorageTextureBindingLayout(
    public val `$mem`: MemorySegment,
) {
    public var nextInChain: Pointer<WGPUChainedStruct>
        get() = WGPUStorageTextureBindingLayout.nextInChainHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUStorageTextureBindingLayout.nextInChainHandle.set(this.`$mem`, 0L, value)
        }

    public var access: WGPUStorageTextureAccess
        get() =
            WGPUStorageTextureAccess.fromInt(
                WGPUStorageTextureBindingLayout.accessHandle.get(
                    this.`$mem`,
                    0L
                ) as Int
            )
        set(`value`) {
            WGPUStorageTextureBindingLayout.accessHandle.set(this.`$mem`, 0L, value.value)
        }

    public var format: WGPUTextureFormat
        get() = WGPUTextureFormat.fromInt(
            WGPUStorageTextureBindingLayout.formatHandle.get(
                this.`$mem`,
                0L
            ) as Int
        )
        set(`value`) {
            WGPUStorageTextureBindingLayout.formatHandle.set(this.`$mem`, 0L, value.value)
        }

    public var viewDimension: WGPUTextureViewDimension
        get() =
            WGPUTextureViewDimension.fromInt(
                WGPUStorageTextureBindingLayout.viewDimensionHandle.get(
                    this.`$mem`,
                    0L
                ) as Int
            )
        set(`value`) {
            WGPUStorageTextureBindingLayout.viewDimensionHandle.set(this.`$mem`, 0L, value.value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPUStorageTextureBindingLayout.layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("nextInChain"),
            ValueLayout.JAVA_INT.withName("access"),
            ValueLayout.JAVA_INT.withName("format"),
            ValueLayout.JAVA_INT.withName("viewDimension"),
            java.lang.foreign.MemoryLayout.paddingLayout(4),
        ).withName("WGPUStorageTextureBindingLayout")

        @JvmField
        public val nextInChainHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("nextInChain"))

        @JvmField
        public val accessHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("access"))

        @JvmField
        public val formatHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("format"))

        @JvmField
        public val viewDimensionHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("viewDimension"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUStorageTextureBindingLayout =
            WGPUStorageTextureBindingLayout(alloc.allocate(WGPUStorageTextureBindingLayout.layout))
    }
}
