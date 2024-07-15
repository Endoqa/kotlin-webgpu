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
import kotlin.jvm.JvmField
import kotlin.jvm.JvmInline
import kotlin.jvm.JvmStatic

@JvmInline
public value class WGPUShaderModuleWGSLDescriptor(
    public val `$mem`: MemorySegment,
) {
    public var chain: WGPUChainedStruct
        get() = WGPUChainedStruct(
            chainHandle.invokeExact(
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

    public var code: Pointer<Byte>
        get() = codeHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            codeHandle.set(this.`$mem`, 0L, value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            WGPUChainedStruct.layout.withName("chain"),
            `$RuntimeHelper`.POINTER.withName("code"),
        ).withName("WGPUShaderModuleWGSLDescriptor")

        @JvmField
        public val chainHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("chain"))

        @JvmField
        public val codeHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("code"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUShaderModuleWGSLDescriptor =
            WGPUShaderModuleWGSLDescriptor(alloc.allocate(layout))
    }
}
