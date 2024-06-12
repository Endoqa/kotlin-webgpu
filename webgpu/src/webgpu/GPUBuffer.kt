package webgpu

import java.lang.foreign.Arena
import java.lang.foreign.MemorySegment
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
        wgpuBufferMapAsync(buffer_, mode, offset, size, MemorySegment.NULL, TODO())
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