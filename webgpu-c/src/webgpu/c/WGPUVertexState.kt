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
import kotlin.Long
import kotlin.ULong
import kotlin.jvm.JvmField
import kotlin.jvm.JvmInline
import kotlin.jvm.JvmStatic

@JvmInline
public value class WGPUVertexState(
    public val `$mem`: MemorySegment,
) {
    public var nextInChain: Pointer<WGPUChainedStruct>
        get() = WGPUVertexState.nextInChainHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUVertexState.nextInChainHandle.set(this.`$mem`, 0L, value)
        }

    public var module: WGPUShaderModule
        get() = WGPUVertexState.moduleHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUVertexState.moduleHandle.set(this.`$mem`, 0L, value)
        }

    public var entryPoint: WGPUStringView
        get() = WGPUStringView(
            WGPUVertexState.entryPointHandle.invokeExact(this.`$mem`, 0L) as
                    MemorySegment
        )
        set(`value`) {
            MemorySegment.copy(
                value.`$mem`, 0L, this.entryPoint.`$mem`, 0L,
                WGPUStringView.layout.byteSize()
            )
        }

    public var constantCount: ULong
        get() = (WGPUVertexState.constantCountHandle.get(this.`$mem`, 0L) as Long).toULong()
        set(`value`) {
            WGPUVertexState.constantCountHandle.set(this.`$mem`, 0L, value.toLong())
        }

    public var constants: Pointer<WGPUConstantEntry>
        get() = WGPUVertexState.constantsHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUVertexState.constantsHandle.set(this.`$mem`, 0L, value)
        }

    public var bufferCount: ULong
        get() = (WGPUVertexState.bufferCountHandle.get(this.`$mem`, 0L) as Long).toULong()
        set(`value`) {
            WGPUVertexState.bufferCountHandle.set(this.`$mem`, 0L, value.toLong())
        }

    public var buffers: Pointer<WGPUVertexBufferLayout>
        get() = WGPUVertexState.buffersHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUVertexState.buffersHandle.set(this.`$mem`, 0L, value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPUVertexState.layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("nextInChain"),
            `$RuntimeHelper`.POINTER.withName("module"),
            WGPUStringView.layout.withName("entryPoint"),
            ValueLayout.JAVA_LONG.withName("constantCount"),
            `$RuntimeHelper`.POINTER.withName("constants"),
            ValueLayout.JAVA_LONG.withName("bufferCount"),
            `$RuntimeHelper`.POINTER.withName("buffers"),
        ).withName("WGPUVertexState")

        @JvmField
        public val nextInChainHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("nextInChain"))

        @JvmField
        public val moduleHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("module"))

        @JvmField
        public val entryPointHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("entryPoint"))

        @JvmField
        public val constantCountHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("constantCount"))

        @JvmField
        public val constantsHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("constants"))

        @JvmField
        public val bufferCountHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("bufferCount"))

        @JvmField
        public val buffersHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("buffers"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUVertexState =
            WGPUVertexState(alloc.allocate(WGPUVertexState.layout))
    }
}
