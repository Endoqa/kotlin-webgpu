// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu

import java.lang.foreign.*
import java.lang.invoke.VarHandle

/**
 * TODO
 */
@JvmInline
public value class WGPUBlendComponent(
    public val `$mem`: MemorySegment,
) {
    /**
     * If set to @ref WGPUBlendOperation_Undefined,
     * [defaults](@ref SentinelValues) to @ref WGPUBlendOperation_Add.
     */
    public var operation: WGPUBlendOperation
        get() = WGPUBlendOperation.fromInt(operationHandle.get(this.`$mem`, 0L) as Int)
        set(`value`) {
            operationHandle.set(this.`$mem`, 0L, value.value)
        }

    /**
     * If set to @ref WGPUBlendFactor_Undefined,
     * [defaults](@ref SentinelValues) to @ref WGPUBlendFactor_One.
     */
    public var srcFactor: WGPUBlendFactor
        get() = WGPUBlendFactor.fromInt(srcFactorHandle.get(this.`$mem`, 0L) as Int)
        set(`value`) {
            srcFactorHandle.set(this.`$mem`, 0L, value.value)
        }

    /**
     * If set to @ref WGPUBlendFactor_Undefined,
     * [defaults](@ref SentinelValues) to @ref WGPUBlendFactor_Zero.
     */
    public var dstFactor: WGPUBlendFactor
        get() = WGPUBlendFactor.fromInt(dstFactorHandle.get(this.`$mem`, 0L) as Int)
        set(`value`) {
            dstFactorHandle.set(this.`$mem`, 0L, value.value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(layout)
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
            WGPUBlendComponent(alloc.allocate(layout))
    }
}
