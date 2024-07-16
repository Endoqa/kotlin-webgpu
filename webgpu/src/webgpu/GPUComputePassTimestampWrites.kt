package webgpu

import webgpu.c.WGPUComputePassTimestampWrites
import java.lang.foreign.Arena

data class GPUComputePassTimestampWrites(
    val querySet: GPUQuerySet,
    val beginningOfPassWriteIndex: GPUSize32 = 0u,
    val endOfPassWriteIndex: GPUSize32 = 0u,
) {
    companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(
            interop: GPUComputePassTimestampWrites,
            native: WGPUComputePassTimestampWrites
        ) {
            native.querySet = interop.querySet.set_
            native.beginningOfPassWriteIndex = interop.beginningOfPassWriteIndex
            native.endOfPassWriteIndex = interop.endOfPassWriteIndex
        }
    }
}
