// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu

import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.VarHandle

@JvmInline
public value class WGPURenderPassPixelLocalStorage(
    public val `$mem`: MemorySegment,
) {
    public var chain: WGPUChainedStruct
        get() = WGPUChainedStruct(
            WGPURenderPassPixelLocalStorage.chainHandle.invokeExact(
                this.`$mem`,
                0L
            ) as MemorySegment
        )
        set(`value`) {
            MemorySegment.copy(
                value.`$mem`, 0L, this.chain.`$mem`, 0L,
                WGPUChainedStruct.layout.byteSize()
            )
        }

    public var totalPixelLocalStorageSize: uint64_t
        get() = (WGPURenderPassPixelLocalStorage.totalPixelLocalStorageSizeHandle.get(this.`$mem`, 0L)
                as Long).toULong()
        set(`value`) {
            WGPURenderPassPixelLocalStorage.totalPixelLocalStorageSizeHandle.set(
                this.`$mem`,
                0L, value.toLong()
            )
        }

    public var storageAttachmentCount: ULong
        get() = (WGPURenderPassPixelLocalStorage.storageAttachmentCountHandle.get(this.`$mem`, 0L) as
                Long).toULong()
        set(`value`) {
            WGPURenderPassPixelLocalStorage.storageAttachmentCountHandle.set(
                this.`$mem`,
                0L, value.toLong()
            )
        }

    public var storageAttachments: Pointer<WGPURenderPassStorageAttachment>
        get() = WGPURenderPassPixelLocalStorage.storageAttachmentsHandle.get(this.`$mem`, 0L) as
                MemorySegment
        set(`value`) {
            WGPURenderPassPixelLocalStorage.storageAttachmentsHandle.set(this.`$mem`, 0L, value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPURenderPassPixelLocalStorage.layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            WGPUChainedStruct.layout.withName("chain"),
            ValueLayout.JAVA_LONG.withName("totalPixelLocalStorageSize"),
            ValueLayout.JAVA_LONG.withName("storageAttachmentCount"),
            `$RuntimeHelper`.POINTER.withName("storageAttachments"),
        ).withName("WGPURenderPassPixelLocalStorage")

        @JvmField
        public val chainHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("chain"))

        @JvmField
        public val totalPixelLocalStorageSizeHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("totalPixelLocalStorageSize"))

        @JvmField
        public val storageAttachmentCountHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("storageAttachmentCount"))

        @JvmField
        public val storageAttachmentsHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("storageAttachments"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPURenderPassPixelLocalStorage =
            WGPURenderPassPixelLocalStorage(alloc.allocate(WGPURenderPassPixelLocalStorage.layout))
    }
}
