// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c

import java.lang.foreign.Arena
import java.lang.foreign.MemoryLayout
import java.lang.foreign.MemorySegment
import java.lang.foreign.SegmentAllocator
import java.lang.foreign.StructLayout
import java.lang.invoke.VarHandle
import kotlin.Boolean
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmInline
import kotlin.jvm.JvmStatic

@JvmInline
public value class WGPUUncapturedErrorCallbackInfo(
    public val `$mem`: MemorySegment,
) {
    public var nextInChain: Pointer<WGPUChainedStruct>
        get() = WGPUUncapturedErrorCallbackInfo.nextInChainHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUUncapturedErrorCallbackInfo.nextInChainHandle.set(this.`$mem`, 0L, value)
        }

    public var callback: WGPUUncapturedErrorCallback
        get() = WGPUUncapturedErrorCallbackInfo.callbackHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUUncapturedErrorCallbackInfo.callbackHandle.set(this.`$mem`, 0L, value)
        }

    public var userdata1: Pointer<Unit>
        get() = WGPUUncapturedErrorCallbackInfo.userdata1Handle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUUncapturedErrorCallbackInfo.userdata1Handle.set(this.`$mem`, 0L, value)
        }

    public var userdata2: Pointer<Unit>
        get() = WGPUUncapturedErrorCallbackInfo.userdata2Handle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUUncapturedErrorCallbackInfo.userdata2Handle.set(this.`$mem`, 0L, value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPUUncapturedErrorCallbackInfo.layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("nextInChain"),
            `$RuntimeHelper`.POINTER.withName("callback"),
            `$RuntimeHelper`.POINTER.withName("userdata1"),
            `$RuntimeHelper`.POINTER.withName("userdata2"),
        ).withName("WGPUUncapturedErrorCallbackInfo")

        @JvmField
        public val nextInChainHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("nextInChain"))

        @JvmField
        public val callbackHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("callback"))

        @JvmField
        public val userdata1Handle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("userdata1"))

        @JvmField
        public val userdata2Handle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("userdata2"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUUncapturedErrorCallbackInfo =
            WGPUUncapturedErrorCallbackInfo(alloc.allocate(WGPUUncapturedErrorCallbackInfo.layout))
    }
}
