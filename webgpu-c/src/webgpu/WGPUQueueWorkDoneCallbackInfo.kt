// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu

import java.lang.foreign.Arena
import java.lang.foreign.MemoryLayout
import java.lang.foreign.MemorySegment
import java.lang.foreign.SegmentAllocator
import java.lang.foreign.StructLayout
import java.lang.foreign.ValueLayout
import java.lang.invoke.VarHandle
import kotlin.Boolean
import kotlin.Int
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmInline
import kotlin.jvm.JvmStatic

@JvmInline
public value class WGPUQueueWorkDoneCallbackInfo(
    public val `$mem`: MemorySegment,
) {
    public var nextInChain: Pointer<WGPUChainedStruct>
        get() = nextInChainHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            nextInChainHandle.set(this.`$mem`, 0L, value)
        }

    public var mode: WGPUCallbackMode
        get() = WGPUCallbackMode.fromInt(
            modeHandle.get(this.`$mem`, 0L)
                    as Int
        )
        set(`value`) {
            modeHandle.set(this.`$mem`, 0L, value.value)
        }

    public var callback: WGPUQueueWorkDoneCallback
        get() = callbackHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            callbackHandle.set(this.`$mem`, 0L, value)
        }

    public var userdata: Pointer<Unit>
        get() = userdataHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            userdataHandle.set(this.`$mem`, 0L, value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("nextInChain"),
            ValueLayout.JAVA_INT.withName("mode"),
            MemoryLayout.paddingLayout(4),
            `$RuntimeHelper`.POINTER.withName("callback"),
            `$RuntimeHelper`.POINTER.withName("userdata"),
        ).withName("WGPUQueueWorkDoneCallbackInfo")

        @JvmField
        public val nextInChainHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("nextInChain"))

        @JvmField
        public val modeHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("mode"))

        @JvmField
        public val callbackHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("callback"))

        @JvmField
        public val userdataHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("userdata"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUQueueWorkDoneCallbackInfo =
            WGPUQueueWorkDoneCallbackInfo(alloc.allocate(layout))
    }
}
