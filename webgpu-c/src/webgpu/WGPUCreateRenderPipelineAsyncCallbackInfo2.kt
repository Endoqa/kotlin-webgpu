// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu

import java.lang.foreign.*
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.VarHandle

@JvmInline
public value class WGPUCreateRenderPipelineAsyncCallbackInfo2(
    public val `$mem`: MemorySegment,
) {
    public var nextInChain: Pointer<WGPUChainedStruct>
        get() = WGPUCreateRenderPipelineAsyncCallbackInfo2.nextInChainHandle.get(this.`$mem`, 0L) as
                MemorySegment
        set(`value`) {
            WGPUCreateRenderPipelineAsyncCallbackInfo2.nextInChainHandle.set(this.`$mem`, 0L, value)
        }

    public var mode: WGPUCallbackMode
        get() =
            WGPUCallbackMode.fromInt(
                WGPUCreateRenderPipelineAsyncCallbackInfo2.modeHandle.get(
                    this.`$mem`,
                    0L
                ) as Int
            )
        set(`value`) {
            WGPUCreateRenderPipelineAsyncCallbackInfo2.modeHandle.set(this.`$mem`, 0L, value.value)
        }

    public var callback: WGPUCreateRenderPipelineAsyncCallback2
        get() = WGPUCreateRenderPipelineAsyncCallbackInfo2.callbackHandle.get(this.`$mem`, 0L) as
                MemorySegment
        set(`value`) {
            WGPUCreateRenderPipelineAsyncCallbackInfo2.callbackHandle.set(this.`$mem`, 0L, value)
        }

    public var userdata1: Pointer<Unit>
        get() = WGPUCreateRenderPipelineAsyncCallbackInfo2.userdata1Handle.get(this.`$mem`, 0L) as
                MemorySegment
        set(`value`) {
            WGPUCreateRenderPipelineAsyncCallbackInfo2.userdata1Handle.set(this.`$mem`, 0L, value)
        }

    public var userdata2: Pointer<Unit>
        get() = WGPUCreateRenderPipelineAsyncCallbackInfo2.userdata2Handle.get(this.`$mem`, 0L) as
                MemorySegment
        set(`value`) {
            WGPUCreateRenderPipelineAsyncCallbackInfo2.userdata2Handle.set(this.`$mem`, 0L, value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPUCreateRenderPipelineAsyncCallbackInfo2.layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            `$RuntimeHelper`.POINTER.withName("nextInChain"),
            ValueLayout.JAVA_INT.withName("mode"),
            java.lang.foreign.MemoryLayout.paddingLayout(4),
            `$RuntimeHelper`.POINTER.withName("callback"),
            `$RuntimeHelper`.POINTER.withName("userdata1"),
            `$RuntimeHelper`.POINTER.withName("userdata2"),
        ).withName("WGPUCreateRenderPipelineAsyncCallbackInfo2")

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
        public fun allocate(alloc: SegmentAllocator): WGPUCreateRenderPipelineAsyncCallbackInfo2 =
            WGPUCreateRenderPipelineAsyncCallbackInfo2(alloc.allocate(WGPUCreateRenderPipelineAsyncCallbackInfo2.layout))

        public fun interface callback {
            public fun invoke(
                status: WGPUCreatePipelineAsyncStatus,
                pipeline: WGPURenderPipeline,
                message: Pointer<Byte>,
                userdata1: Pointer<Unit>,
                userdata2: Pointer<Unit>,
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
                        1, WGPUCreatePipelineAsyncStatus.fromInt, null, null, null, null,
                    )

                @JvmStatic
                public val fd: FunctionDescriptor = FunctionDescriptor.ofVoid(
                    ValueLayout.JAVA_INT,
                    `$RuntimeHelper`.POINTER,
                    `$RuntimeHelper`.POINTER,
                    `$RuntimeHelper`.POINTER,
                    `$RuntimeHelper`.POINTER,
                )
            }
        }
    }
}