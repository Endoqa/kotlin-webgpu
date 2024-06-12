package webgpu

import Converter
import java.lang.foreign.Arena
import java.lang.foreign.MemorySegment
import java.lang.foreign.ValueLayout
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class GPUQueue(
    internal val queue_: WGPUQueue,
    internal val arena: Arena,
) {


    //  undefined submit(sequence<GPUCommandBuffer> commandBuffers);
    fun submit(commandBuffers: List<GPUCommandBuffer>) {
        var commands: MemorySegment = MemorySegment.NULL
        val commandCount = Converter.convert(
            arena,
            { commands = it },
            commandBuffers,
            ValueLayout.ADDRESS,
            { buf, native -> native.setAtIndex(ValueLayout.ADDRESS, 0L, buf.commandBuffer_) }
        )
        wgpuQueueSubmit(queue_, commandCount, commands)
    }


    //   Promise<undefined> onSubmittedWorkDone();
    suspend fun onSubmittedWorkDone() {
        Arena.ofConfined().use { temp ->
            suspendCoroutine<Unit> {
                val callback = webgpu.callback.WGPUQueueWorkDoneCallback2 { status, userdata1, userdata2 ->
                    when (status) {
                        WGPUQueueWorkDoneStatus.Success -> it.resume(Unit)
                        else -> it.resumeWithException(RuntimeException("$status"))
                    }
                }

                val cb = WGPUQueueWorkDoneCallbackInfo2.allocate(temp)
                cb.callback = callback.allocate(temp)
                cb.mode = WGPUCallbackMode.AllowSpontaneous

                with(temp) {
                    wgpuQueueOnSubmittedWorkDone2(queue_, cb)
                }
            }


        }
    }


    fun writeBuffer(
        buffer: GPUBuffer,
        bufferOffset: GPUSize64,
        data: MemorySegment,
        dataOffset: GPUSize64 = 0u,
        size: GPUSize64 = data.byteSize().toULong() - dataOffset
    ) {
        wgpuQueueWriteBuffer(queue_, buffer.buffer_, bufferOffset, data.asSlice(dataOffset.toLong()), size)
    }


    fun writeTexture() {
        TODO()
    }
}