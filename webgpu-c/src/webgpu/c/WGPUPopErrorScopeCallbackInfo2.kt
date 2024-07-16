// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c

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
public value class WGPUPopErrorScopeCallbackInfo2(
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

    public var callback: WGPUPopErrorScopeCallback2
        get() = callbackHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            callbackHandle.set(this.`$mem`, 0L, value)
        }

    public var userdata1: Pointer<Unit>
        get() = userdata1Handle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            userdata1Handle.set(this.`$mem`, 0L, value)
        }

    public var userdata2: Pointer<Unit>
        get() = userdata2Handle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            userdata2Handle.set(this.`$mem`, 0L, value)
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
            `$RuntimeHelper`.POINTER.withName("userdata1"),
            `$RuntimeHelper`.POINTER.withName("userdata2"),
        ).withName("WGPUPopErrorScopeCallbackInfo2")

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
        public val userdata1Handle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("userdata1"))

        @JvmField
        public val userdata2Handle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("userdata2"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUPopErrorScopeCallbackInfo2 =
            WGPUPopErrorScopeCallbackInfo2(alloc.allocate(layout))
    }
}