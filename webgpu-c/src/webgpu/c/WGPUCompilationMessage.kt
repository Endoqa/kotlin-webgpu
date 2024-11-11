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
import kotlin.Int
import kotlin.Long
import kotlin.ULong
import kotlin.jvm.JvmField
import kotlin.jvm.JvmInline
import kotlin.jvm.JvmStatic

@JvmInline
public value class WGPUCompilationMessage(
    public val `$mem`: MemorySegment,
) {
    public var nextInChain: Pointer<WGPUChainedStruct>
        get() = WGPUCompilationMessage.nextInChainHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUCompilationMessage.nextInChainHandle.set(this.`$mem`, 0L, value)
        }

    public var message: WGPUStringView
        get() = WGPUStringView(
            WGPUCompilationMessage.messageHandle.invokeExact(this.`$mem`, 0L) as
                    MemorySegment
        )
        set(`value`) {
            MemorySegment.copy(
                value.`$mem`, 0L, this.message.`$mem`, 0L,
                WGPUStringView.layout.byteSize()
            )
        }

    public var type: WGPUCompilationMessageType
        get() = WGPUCompilationMessageType.fromInt(
            WGPUCompilationMessage.typeHandle.get(
                this.`$mem`,
                0L
            ) as Int
        )
        set(`value`) {
            WGPUCompilationMessage.typeHandle.set(this.`$mem`, 0L, value.value)
        }

    public var lineNum: ULong
        get() = (WGPUCompilationMessage.lineNumHandle.get(this.`$mem`, 0L) as Long).toULong()
        set(`value`) {
            WGPUCompilationMessage.lineNumHandle.set(this.`$mem`, 0L, value.toLong())
        }

    public var linePos: ULong
        get() = (WGPUCompilationMessage.linePosHandle.get(this.`$mem`, 0L) as Long).toULong()
        set(`value`) {
            WGPUCompilationMessage.linePosHandle.set(this.`$mem`, 0L, value.toLong())
        }

    public var offset: ULong
        get() = (WGPUCompilationMessage.offsetHandle.get(this.`$mem`, 0L) as Long).toULong()
        set(`value`) {
            WGPUCompilationMessage.offsetHandle.set(this.`$mem`, 0L, value.toLong())
        }

    public var length: ULong
        get() = (WGPUCompilationMessage.lengthHandle.get(this.`$mem`, 0L) as Long).toULong()
        set(`value`) {
            WGPUCompilationMessage.lengthHandle.set(this.`$mem`, 0L, value.toLong())
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPUCompilationMessage.layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("nextInChain"),
            WGPUStringView.layout.withName("message"),
            ValueLayout.JAVA_INT.withName("type"),
            java.lang.foreign.MemoryLayout.paddingLayout(4),
            ValueLayout.JAVA_LONG.withName("lineNum"),
            ValueLayout.JAVA_LONG.withName("linePos"),
            ValueLayout.JAVA_LONG.withName("offset"),
            ValueLayout.JAVA_LONG.withName("length"),
        ).withName("WGPUCompilationMessage")

        @JvmField
        public val nextInChainHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("nextInChain"))

        @JvmField
        public val messageHandle: MethodHandle =
            layout.sliceHandle(MemoryLayout.PathElement.groupElement("message"))

        @JvmField
        public val typeHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("type"))

        @JvmField
        public val lineNumHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("lineNum"))

        @JvmField
        public val linePosHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("linePos"))

        @JvmField
        public val offsetHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("offset"))

        @JvmField
        public val lengthHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("length"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUCompilationMessage =
            WGPUCompilationMessage(alloc.allocate(WGPUCompilationMessage.layout))
    }
}
