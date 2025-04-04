package wgpu

import lib.wgpu.*
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

public actual class GPUBuffer(
    private val buffer: WGPUBuffer
) : GPUObjectBase {
    public actual override var label: String
        get() = TODO()
        set(value) {
            unsafeScope { wgpuBufferSetLabel(buffer, value.into()) }
        }

    public actual val size: GPUSize64Out get() = wgpuBufferGetSize(buffer)

    public actual val usage: GPUFlagsConstant get() = wgpuBufferGetUsage(buffer).toUInt()

    public actual val mapState: GPUBufferMapState get() = GPUBufferMapState.from(wgpuBufferGetMapState(buffer))

    public actual suspend fun mapAsync(
        mode: GPUMapModeFlags,
        offset: GPUSize64,
        size: GPUSize64,
    ) {
        return unsafeScope {
            suspendCoroutine { cont ->
                val info = createBufferMapCallback { status, message, _, _ ->
                    when (status) {
                        WGPUMapAsyncStatus.Success -> cont.resume(Unit)
                        else -> cont.resumeWithException(Error(String.from(message)))
                    }
                }
                wgpuBufferMapAsync(buffer, mode.toULong(), offset, size, info)
            }
        }
    }

    public actual fun getMappedRange(offset: GPUSize64, size: GPUSize64): NativeBuffer {
        return wgpuBufferGetMappedRange(buffer, offset, size).address()
    }

    public actual fun unmap() {
        wgpuBufferUnmap(buffer)
    }

    public actual fun destroy() {
        wgpuBufferDestroy(buffer)
    }

    public fun into(): WGPUBuffer = buffer
}
