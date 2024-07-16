package webgpu

import webgpu.c.WGPURenderPassTimestampWrites
import java.lang.foreign.Arena

data class GPURenderPassTimestampWrites(
    val querySet: GPUQuerySet,
    val beginningOfPassWriteIndex: GPUSize32 = 0u,
    val endOfPassWriteIndex: GPUSize32 = 0u,
) {
    companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(
            interop: GPURenderPassTimestampWrites,
            native: WGPURenderPassTimestampWrites
        ) {
            native.querySet = interop.querySet.set_
            native.beginningOfPassWriteIndex = interop.beginningOfPassWriteIndex
            native.endOfPassWriteIndex = interop.endOfPassWriteIndex
        }
    }
}
