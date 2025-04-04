package wgpu

import lib.wgpu.*
import java.lang.foreign.MemorySegment
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

public actual class GPUQueue(
    private val queue: WGPUQueue
) : GPUObjectBase {
    actual override var label: String
        get() = TODO()
        set(value) {
            unsafeScope { wgpuQueueSetLabel(queue, value.into()) }
        }

    public actual fun submit(commandBuffers: List<GPUCommandBuffer>) {
        return unsafeScope {
            val cmds = allocateList(commandBuffers) { it.into() }
            wgpuQueueSubmit(queue, commandBuffers.size.toULong(), cmds)
        }
    }

    public actual suspend fun onSubmittedWorkDone() {
        return unsafeScope {
            suspendCoroutine { cont ->
                val info = createQueueWorkDoneCallback { status, _, _ ->
                    when (status) {
                        WGPUQueueWorkDoneStatus.Success -> cont.resume(Unit)
                        else -> cont.resumeWithException(Error(status.name))
                    }
                }
                wgpuQueueOnSubmittedWorkDone(queue, info)
            }
        }
    }

    public actual fun writeBuffer(
        buffer: GPUBuffer,
        bufferOffset: GPUSize64,
        `data`: AllowSharedBufferSource,
        dataOffset: GPUSize64,
        size: GPUSize64,
    ) {
        wgpuQueueWriteBuffer(
            queue,
            buffer.into(),
            bufferOffset,
            MemorySegment.ofAddress(data).reinterpret(Long.MAX_VALUE).asSlice(dataOffset.toLong()),
            size
        )
    }

    public actual fun writeTexture(
        destination: GPUTexelCopyTextureInfo,
        `data`: AllowSharedBufferSource,
        dataLayout: GPUTexelCopyBufferLayout,
        size: GPUExtent3D,
    ) {
        TODO("don't know the size of data")
    }
}
