// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu

import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.VarHandle

@JvmInline
public value class WGPUDeviceLostCallbackInfo(
    public val `$mem`: MemorySegment,
) {
    public var nextInChain: Pointer<WGPUChainedStruct>
        get() = WGPUDeviceLostCallbackInfo.nextInChainHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUDeviceLostCallbackInfo.nextInChainHandle.set(this.`$mem`, 0L, value)
        }

    public var mode: WGPUCallbackMode
        get() = WGPUCallbackMode.fromInt(
            WGPUDeviceLostCallbackInfo.modeHandle.get(this.`$mem`, 0L) as
                    Int
        )
        set(`value`) {
            WGPUDeviceLostCallbackInfo.modeHandle.set(this.`$mem`, 0L, value.value)
        }

    public var callback: WGPUDeviceLostCallbackNew
        get() = WGPUDeviceLostCallbackInfo.callbackHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUDeviceLostCallbackInfo.callbackHandle.set(this.`$mem`, 0L, value)
        }

    public var userdata: Pointer<Unit>
        get() = WGPUDeviceLostCallbackInfo.userdataHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUDeviceLostCallbackInfo.userdataHandle.set(this.`$mem`, 0L, value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPUDeviceLostCallbackInfo.layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("nextInChain"),
            ValueLayout.JAVA_INT.withName("mode"),
            java.lang.foreign.MemoryLayout.paddingLayout(4),
            `$RuntimeHelper`.POINTER.withName("callback"),
            `$RuntimeHelper`.POINTER.withName("userdata"),
        ).withName("WGPUDeviceLostCallbackInfo")

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
        public fun allocate(alloc: SegmentAllocator): WGPUDeviceLostCallbackInfo =
            WGPUDeviceLostCallbackInfo(alloc.allocate(WGPUDeviceLostCallbackInfo.layout))

        public fun interface callback {
            public fun invoke(
                device: Pointer<WGPUDevice>,
                reason: WGPUDeviceLostReason,
                message: Pointer<Byte>,
                userdata: Pointer<Unit>,
            )

            public fun allocate(arena: Arena): MemorySegment =
                Linker.nativeLinker().upcallStub(invokeHandle.bindTo(this), fd, arena)

            public companion object {
                @JvmStatic
                public val invokeHandle: MethodHandle =
                    MethodHandles.filterArguments(
                        MethodHandles.lookup().unreflect(callback::class.java.methods.find {
                            it.name == "invoke"
                        }
                        ),
                        1, null, WGPUDeviceLostReason.fromInt, null, null,
                    )

                @JvmStatic
                public val fd: FunctionDescriptor = FunctionDescriptor.ofVoid(
                    `$RuntimeHelper`.POINTER,
                    ValueLayout.JAVA_INT,
                    `$RuntimeHelper`.POINTER,
                    `$RuntimeHelper`.POINTER,
                )
            }
        }
    }
}