package webgpu

import java.lang.foreign.Arena

public data class GPUComputePassDescriptor(
    override val label: String = "",
    public val timestampWrites: GPUComputePassTimestampWrites? = null,
) : GPUObjectDescriptorBase {
    public companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(interop: GPUComputePassDescriptor, native: WGPUComputePassDescriptor) {
            TODO()
        }
    }
}
