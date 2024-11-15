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
import kotlin.UInt
import kotlin.jvm.JvmField
import kotlin.jvm.JvmInline
import kotlin.jvm.JvmStatic

@JvmInline
public value class WGPUAdapterInfo(
    public val `$mem`: MemorySegment,
) {
    public var nextInChain: Pointer<WGPUChainedStructOut>
        get() = WGPUAdapterInfo.nextInChainHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUAdapterInfo.nextInChainHandle.set(this.`$mem`, 0L, value)
        }

    public var vendor: WGPUStringView
        get() = WGPUStringView(
            WGPUAdapterInfo.vendorHandle.invokeExact(this.`$mem`, 0L) as
                    MemorySegment
        )
        set(`value`) {
            MemorySegment.copy(value.`$mem`, 0L, this.vendor.`$mem`, 0L, WGPUStringView.layout.byteSize())
        }

    public var architecture: WGPUStringView
        get() = WGPUStringView(
            WGPUAdapterInfo.architectureHandle.invokeExact(this.`$mem`, 0L) as
                    MemorySegment
        )
        set(`value`) {
            MemorySegment.copy(
                value.`$mem`, 0L, this.architecture.`$mem`, 0L,
                WGPUStringView.layout.byteSize()
            )
        }

    public var device: WGPUStringView
        get() = WGPUStringView(
            WGPUAdapterInfo.deviceHandle.invokeExact(this.`$mem`, 0L) as
                    MemorySegment
        )
        set(`value`) {
            MemorySegment.copy(value.`$mem`, 0L, this.device.`$mem`, 0L, WGPUStringView.layout.byteSize())
        }

    public var description: WGPUStringView
        get() = WGPUStringView(
            WGPUAdapterInfo.descriptionHandle.invokeExact(this.`$mem`, 0L) as
                    MemorySegment
        )
        set(`value`) {
            MemorySegment.copy(
                value.`$mem`, 0L, this.description.`$mem`, 0L,
                WGPUStringView.layout.byteSize()
            )
        }

    public var backendType: WGPUBackendType
        get() = WGPUBackendType.fromInt(WGPUAdapterInfo.backendTypeHandle.get(this.`$mem`, 0L) as Int)
        set(`value`) {
            WGPUAdapterInfo.backendTypeHandle.set(this.`$mem`, 0L, value.value)
        }

    public var adapterType: WGPUAdapterType
        get() = WGPUAdapterType.fromInt(WGPUAdapterInfo.adapterTypeHandle.get(this.`$mem`, 0L) as Int)
        set(`value`) {
            WGPUAdapterInfo.adapterTypeHandle.set(this.`$mem`, 0L, value.value)
        }

    public var vendorID: UInt
        get() = (WGPUAdapterInfo.vendorIDHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            WGPUAdapterInfo.vendorIDHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var deviceID: UInt
        get() = (WGPUAdapterInfo.deviceIDHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            WGPUAdapterInfo.deviceIDHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPUAdapterInfo.layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("nextInChain"),
            WGPUStringView.layout.withName("vendor"),
            WGPUStringView.layout.withName("architecture"),
            WGPUStringView.layout.withName("device"),
            WGPUStringView.layout.withName("description"),
            ValueLayout.JAVA_INT.withName("backendType"),
            ValueLayout.JAVA_INT.withName("adapterType"),
            ValueLayout.JAVA_INT.withName("vendorID"),
            ValueLayout.JAVA_INT.withName("deviceID"),
        ).withName("WGPUAdapterInfo")

        @JvmField
        public val nextInChainHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("nextInChain"))

        @JvmField
        public val vendorHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("vendor"))

        @JvmField
        public val architectureHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("architecture"))

        @JvmField
        public val deviceHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("device"))

        @JvmField
        public val descriptionHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("description"))

        @JvmField
        public val backendTypeHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("backendType"))

        @JvmField
        public val adapterTypeHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("adapterType"))

        @JvmField
        public val vendorIDHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("vendorID"))

        @JvmField
        public val deviceIDHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("deviceID"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUAdapterInfo =
            WGPUAdapterInfo(alloc.allocate(WGPUAdapterInfo.layout))
    }
}
