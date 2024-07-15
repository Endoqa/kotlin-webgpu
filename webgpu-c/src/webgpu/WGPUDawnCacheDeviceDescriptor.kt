// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu

import java.lang.foreign.Arena
import java.lang.foreign.MemoryLayout
import java.lang.foreign.MemorySegment
import java.lang.foreign.SegmentAllocator
import java.lang.foreign.StructLayout
import java.lang.invoke.MethodHandle
import java.lang.invoke.VarHandle
import kotlin.Boolean
import kotlin.Byte
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmInline
import kotlin.jvm.JvmStatic

@JvmInline
public value class WGPUDawnCacheDeviceDescriptor(
    public val `$mem`: MemorySegment,
) {
    public var chain: WGPUChainedStruct
        get() = WGPUChainedStruct(
            chainHandle.invokeExact(this.`$mem`, 0L)
                    as MemorySegment
        )
        set(`value`) {
            MemorySegment.copy(
                value.`$mem`, 0L, this.chain.`$mem`, 0L,
                WGPUChainedStruct.layout.byteSize()
            )
        }

    public var isolationKey: Pointer<Byte>
        get() = isolationKeyHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            isolationKeyHandle.set(this.`$mem`, 0L, value)
        }

    public var loadDataFunction: WGPUDawnLoadCacheDataFunction
        get() = loadDataFunctionHandle.get(this.`$mem`, 0L) as
                MemorySegment
        set(`value`) {
            loadDataFunctionHandle.set(this.`$mem`, 0L, value)
        }

    public var storeDataFunction: WGPUDawnStoreCacheDataFunction
        get() = storeDataFunctionHandle.get(this.`$mem`, 0L) as
                MemorySegment
        set(`value`) {
            storeDataFunctionHandle.set(this.`$mem`, 0L, value)
        }

    public var functionUserdata: Pointer<Unit>
        get() = functionUserdataHandle.get(this.`$mem`, 0L) as
                MemorySegment
        set(`value`) {
            functionUserdataHandle.set(this.`$mem`, 0L, value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            WGPUChainedStruct.layout.withName("chain"),
            `$RuntimeHelper`.POINTER.withName("isolationKey"),
            `$RuntimeHelper`.POINTER.withName("loadDataFunction"),
            `$RuntimeHelper`.POINTER.withName("storeDataFunction"),
            `$RuntimeHelper`.POINTER.withName("functionUserdata"),
        ).withName("WGPUDawnCacheDeviceDescriptor")

        @JvmField
        public val chainHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("chain"))

        @JvmField
        public val isolationKeyHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("isolationKey"))

        @JvmField
        public val loadDataFunctionHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("loadDataFunction"))

        @JvmField
        public val storeDataFunctionHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("storeDataFunction"))

        @JvmField
        public val functionUserdataHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("functionUserdata"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUDawnCacheDeviceDescriptor =
            WGPUDawnCacheDeviceDescriptor(alloc.allocate(layout))
    }
}
