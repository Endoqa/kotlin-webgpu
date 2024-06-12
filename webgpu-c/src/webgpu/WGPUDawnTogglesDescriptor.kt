// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu

import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.VarHandle

@JvmInline
public value class WGPUDawnTogglesDescriptor(
    public val `$mem`: MemorySegment,
) {
    public var chain: WGPUChainedStruct
        get() = WGPUChainedStruct(
            WGPUDawnTogglesDescriptor.chainHandle.invokeExact(this.`$mem`, 0L) as
                    MemorySegment
        )
        set(`value`) {
            MemorySegment.copy(
                value.`$mem`, 0L, this.chain.`$mem`, 0L,
                WGPUChainedStruct.layout.byteSize()
            )
        }

    public var enabledToggleCount: ULong
        get() = (WGPUDawnTogglesDescriptor.enabledToggleCountHandle.get(this.`$mem`, 0L) as
                Long).toULong()
        set(`value`) {
            WGPUDawnTogglesDescriptor.enabledToggleCountHandle.set(this.`$mem`, 0L, value.toLong())
        }

    public var enabledToggles: Pointer<Pointer<Byte>>
        get() = WGPUDawnTogglesDescriptor.enabledTogglesHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUDawnTogglesDescriptor.enabledTogglesHandle.set(this.`$mem`, 0L, value)
        }

    public var disabledToggleCount: ULong
        get() = (WGPUDawnTogglesDescriptor.disabledToggleCountHandle.get(this.`$mem`, 0L) as
                Long).toULong()
        set(`value`) {
            WGPUDawnTogglesDescriptor.disabledToggleCountHandle.set(this.`$mem`, 0L, value.toLong())
        }

    public var disabledToggles: Pointer<Pointer<Byte>>
        get() = WGPUDawnTogglesDescriptor.disabledTogglesHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUDawnTogglesDescriptor.disabledTogglesHandle.set(this.`$mem`, 0L, value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPUDawnTogglesDescriptor.layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            WGPUChainedStruct.layout.withName("chain"),
            ValueLayout.JAVA_LONG.withName("enabledToggleCount"),
            `$RuntimeHelper`.POINTER.withName("enabledToggles"),
            ValueLayout.JAVA_LONG.withName("disabledToggleCount"),
            `$RuntimeHelper`.POINTER.withName("disabledToggles"),
        ).withName("WGPUDawnTogglesDescriptor")

        @JvmField
        public val chainHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("chain"))

        @JvmField
        public val enabledToggleCountHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("enabledToggleCount"))

        @JvmField
        public val enabledTogglesHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("enabledToggles"))

        @JvmField
        public val disabledToggleCountHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("disabledToggleCount"))

        @JvmField
        public val disabledTogglesHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("disabledToggles"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUDawnTogglesDescriptor =
            WGPUDawnTogglesDescriptor(alloc.allocate(WGPUDawnTogglesDescriptor.layout))
    }
}