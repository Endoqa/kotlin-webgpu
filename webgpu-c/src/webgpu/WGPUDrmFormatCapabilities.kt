// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu

import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.VarHandle

@JvmInline
public value class WGPUDrmFormatCapabilities(
    public val `$mem`: MemorySegment,
) {
    public var chain: WGPUChainedStructOut
        get() = WGPUChainedStructOut(
            WGPUDrmFormatCapabilities.chainHandle.invokeExact(this.`$mem`, 0L)
                    as MemorySegment
        )
        set(`value`) {
            MemorySegment.copy(
                value.`$mem`, 0L, this.chain.`$mem`, 0L,
                WGPUChainedStructOut.layout.byteSize()
            )
        }

    public var propertiesCount: ULong
        get() = (WGPUDrmFormatCapabilities.propertiesCountHandle.get(this.`$mem`, 0L) as Long).toULong()
        set(`value`) {
            WGPUDrmFormatCapabilities.propertiesCountHandle.set(this.`$mem`, 0L, value.toLong())
        }

    public var properties: Pointer<WGPUDrmFormatProperties>
        get() = WGPUDrmFormatCapabilities.propertiesHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUDrmFormatCapabilities.propertiesHandle.set(this.`$mem`, 0L, value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPUDrmFormatCapabilities.layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            WGPUChainedStructOut.layout.withName("chain"),
            ValueLayout.JAVA_LONG.withName("propertiesCount"),
            `$RuntimeHelper`.POINTER.withName("properties"),
        ).withName("WGPUDrmFormatCapabilities")

        @JvmField
        public val chainHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("chain"))

        @JvmField
        public val propertiesCountHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("propertiesCount"))

        @JvmField
        public val propertiesHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("properties"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUDrmFormatCapabilities =
            WGPUDrmFormatCapabilities(alloc.allocate(WGPUDrmFormatCapabilities.layout))
    }
}