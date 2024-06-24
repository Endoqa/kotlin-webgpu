package webgpu

import java.lang.foreign.Arena

public data class GPURenderPassTimestampWrites(
    public val querySet: GPUQuerySet,
    public val beginningOfPassWriteIndex: GPUSize32 = 0u,
    public val endOfPassWriteIndex: GPUSize32 = 0u,
) {
    public companion object {
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
