package wgpu

import lib.wgpu.*

public actual class GPUBuffer(
    private val buffer: WGPUBuffer
) : GPUObjectBase {
    public actual override var label: String
        get() = TODO()
        set(value) {}

    public actual val size: GPUSize64Out get() = wgpuBufferGetSize(buffer)

    public actual val usage: GPUFlagsConstant get() = wgpuBufferGetUsage(buffer).toUInt()

    public actual val mapState: GPUBufferMapState get() = GPUBufferMapState.from(wgpuBufferGetMapState(buffer))

    public actual suspend fun mapAsync(
        mode: GPUMapModeFlags,
        offset: GPUSize64,
        size: GPUSize64,
    ) {
        TODO()
    }

    public actual fun getMappedRange(offset: GPUSize64, size: GPUSize64): NativeBuffer {
        return wgpuBufferGetMappedRange(buffer, offset, size)
    }

    public actual fun unmap() {
        wgpuBufferUnmap(buffer)
    }

    public actual fun destroy() {
        wgpuBufferDestroy(buffer)
    }
}
