package webgpu

import not
import java.lang.foreign.Arena
import java.lang.foreign.MemorySegment
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine
import kotlin.math.max

class GPUBuffer(
    internal val buffer_: WGPUBuffer,
    internal val desc_: GPUBufferDescriptor,
    internal val device: GPUDevice,
    internal val arena: Arena,
) {

    val size: GPUSize64Out get() = wgpuBufferGetSize(buffer_)
    val usage: GPUFlagsConstant get() = wgpuBufferGetUsage(buffer_)
    val mapState: GPUBufferMapState get() = wgpuBufferGetMapState(buffer_)


    suspend fun mapAsync(mode: GPUMapModeFlags, offset: GPUSize64 = 0u, size: GPUSize64 = 0u) {

        Arena.ofConfined().use { temp ->
            suspendCoroutine<Unit> { cont ->

                val callback = webgpu.callback.WGPUBufferMapCallback2 { status, message, _, _ ->
                    when (status) {
                        WGPUMapAsyncStatus.Success -> cont.resume(Unit)
                        else -> {
                            if (!message) {
                                cont.resumeWithException(IllegalStateException("$status"))
                            } else {
                                cont.resumeWithException(IllegalStateException("$status: ${message.getString(0)}"))
                            }
                        }
                    }

                }


                val cb = WGPUBufferMapCallbackInfo2.allocate(temp)
                cb.mode = WGPUCallbackMode.AllowSpontaneous
                cb.callback = callback.allocate(temp)

                with(temp) {
                    wgpuBufferMapAsync2(buffer_, mode, offset, size, cb)
                }
            }
        }


    }


    fun getMappedRange(
        offset: GPUSize64 = 0u,
        size: GPUSize64 = max(0u, this.size - offset)
    ): MemorySegment {
        return wgpuBufferGetMappedRange(buffer_, offset, size).reinterpret(size.toLong())
    }


    fun unmap() {
        wgpuBufferUnmap(buffer_)
    }

    fun destroy() {
        wgpuBufferDestroy(buffer_)
    }

}