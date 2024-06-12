package webgpu

import java.lang.foreign.Arena

public data class GPUImageCopyBuffer(
    override val offset: GPUSize64 = 0u,
    override val bytesPerRow: GPUSize32 = 0u,
    override val rowsPerImage: GPUSize32 = 0u,
    public val buffer: GPUBuffer,
) : GPUImageDataLayout {
    public companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(interop: GPUImageCopyBuffer, native: WGPUImageCopyBuffer) {
            TODO()
        }
    }
}
