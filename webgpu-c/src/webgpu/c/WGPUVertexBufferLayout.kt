// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c

import java.lang.foreign.*
import java.lang.invoke.VarHandle

@JvmInline
public value class WGPUVertexBufferLayout(
    public val `$mem`: MemorySegment,
) {
    public var arrayStride: uint64_t
        get() = (arrayStrideHandle.get(this.`$mem`, 0L) as Long).toULong()
        set(`value`) {
            arrayStrideHandle.set(this.`$mem`, 0L, value.toLong())
        }

    public var stepMode: WGPUVertexStepMode
        get() = WGPUVertexStepMode.fromInt(
            stepModeHandle.get(this.`$mem`, 0L) as
                    Int
        )
        set(`value`) {
            stepModeHandle.set(this.`$mem`, 0L, value.value)
        }

    public var attributeCount: ULong
        get() = (attributeCountHandle.get(this.`$mem`, 0L) as Long).toULong()
        set(`value`) {
            attributeCountHandle.set(this.`$mem`, 0L, value.toLong())
        }

    public var attributes: Pointer<WGPUVertexAttribute>
        get() = attributesHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            attributesHandle.set(this.`$mem`, 0L, value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            ValueLayout.JAVA_LONG.withName("arrayStride"),
            ValueLayout.JAVA_INT.withName("stepMode"),
            MemoryLayout.paddingLayout(4),
            ValueLayout.JAVA_LONG.withName("attributeCount"),
            `$RuntimeHelper`.POINTER.withName("attributes"),
        ).withName("WGPUVertexBufferLayout")

        @JvmField
        public val arrayStrideHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("arrayStride"))

        @JvmField
        public val stepModeHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("stepMode"))

        @JvmField
        public val attributeCountHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("attributeCount"))

        @JvmField
        public val attributesHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("attributes"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUVertexBufferLayout =
            WGPUVertexBufferLayout(alloc.allocate(layout))
    }
}
