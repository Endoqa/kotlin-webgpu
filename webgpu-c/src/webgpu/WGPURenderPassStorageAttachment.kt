// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu

import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.VarHandle

@JvmInline
public value class WGPURenderPassStorageAttachment(
    public val `$mem`: MemorySegment,
) {
    public var nextInChain: Pointer<WGPUChainedStruct>
        get() = WGPURenderPassStorageAttachment.nextInChainHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPURenderPassStorageAttachment.nextInChainHandle.set(this.`$mem`, 0L, value)
        }

    public var offset: uint64_t
        get() = (WGPURenderPassStorageAttachment.offsetHandle.get(this.`$mem`, 0L) as Long).toULong()
        set(`value`) {
            WGPURenderPassStorageAttachment.offsetHandle.set(this.`$mem`, 0L, value.toLong())
        }

    public var storage: WGPUTextureView
        get() = WGPURenderPassStorageAttachment.storageHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPURenderPassStorageAttachment.storageHandle.set(this.`$mem`, 0L, value)
        }

    public var loadOp: WGPULoadOp
        get() = WGPULoadOp.fromInt(
            WGPURenderPassStorageAttachment.loadOpHandle.get(this.`$mem`, 0L) as
                    Int
        )
        set(`value`) {
            WGPURenderPassStorageAttachment.loadOpHandle.set(this.`$mem`, 0L, value.value)
        }

    public var storeOp: WGPUStoreOp
        get() = WGPUStoreOp.fromInt(
            WGPURenderPassStorageAttachment.storeOpHandle.get(this.`$mem`, 0L)
                    as Int
        )
        set(`value`) {
            WGPURenderPassStorageAttachment.storeOpHandle.set(this.`$mem`, 0L, value.value)
        }

    public var clearValue: WGPUColor
        get() = WGPUColor(
            WGPURenderPassStorageAttachment.clearValueHandle.invokeExact(this.`$mem`, 0L)
                    as MemorySegment
        )
        set(`value`) {
            MemorySegment.copy(value.`$mem`, 0L, this.clearValue.`$mem`, 0L, WGPUColor.layout.byteSize())
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPURenderPassStorageAttachment.layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("nextInChain"),
            ValueLayout.JAVA_LONG.withName("offset"),
            `$RuntimeHelper`.POINTER.withName("storage"),
            ValueLayout.JAVA_INT.withName("loadOp"),
            ValueLayout.JAVA_INT.withName("storeOp"),
            WGPUColor.layout.withName("clearValue"),
        ).withName("WGPURenderPassStorageAttachment")

        @JvmField
        public val nextInChainHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("nextInChain"))

        @JvmField
        public val offsetHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("offset"))

        @JvmField
        public val storageHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("storage"))

        @JvmField
        public val loadOpHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("loadOp"))

        @JvmField
        public val storeOpHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("storeOp"))

        @JvmField
        public val clearValueHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("clearValue"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPURenderPassStorageAttachment =
            WGPURenderPassStorageAttachment(alloc.allocate(WGPURenderPassStorageAttachment.layout))
    }
}
