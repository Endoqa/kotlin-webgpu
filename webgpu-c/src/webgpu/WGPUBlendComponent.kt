// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu

import java.lang.foreign.*
import java.lang.invoke.VarHandle

@JvmInline
public value class WGPUBlendComponent(
    public val `$mem`: MemorySegment,
) {
    public var operation: WGPUBlendOperation
        get() = WGPUBlendOperation.fromInt(
            WGPUBlendComponent.operationHandle.get(this.`$mem`, 0L) as
                    Int
        )
        set(`value`) {
            WGPUBlendComponent.operationHandle.set(this.`$mem`, 0L, value.value)
        }

    public var srcFactor: WGPUBlendFactor
        get() = WGPUBlendFactor.fromInt(WGPUBlendComponent.srcFactorHandle.get(this.`$mem`, 0L) as Int)
        set(`value`) {
            WGPUBlendComponent.srcFactorHandle.set(this.`$mem`, 0L, value.value)
        }

    public var dstFactor: WGPUBlendFactor
        get() = WGPUBlendFactor.fromInt(WGPUBlendComponent.dstFactorHandle.get(this.`$mem`, 0L) as Int)
        set(`value`) {
            WGPUBlendComponent.dstFactorHandle.set(this.`$mem`, 0L, value.value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPUBlendComponent.layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            ValueLayout.JAVA_INT.withName("operation"),
            ValueLayout.JAVA_INT.withName("srcFactor"),
            ValueLayout.JAVA_INT.withName("dstFactor"),
        ).withName("WGPUBlendComponent")

        @JvmField
        public val operationHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("operation"))

        @JvmField
        public val srcFactorHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("srcFactor"))

        @JvmField
        public val dstFactorHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("dstFactor"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUBlendComponent =
            WGPUBlendComponent(alloc.allocate(WGPUBlendComponent.layout))
    }
}
