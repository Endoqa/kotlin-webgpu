package webgpu

import Converter
import java.lang.foreign.Arena

public data class GPUComputePassDescriptor(
    override val label: String = "",
    public val timestampWrites: GPUComputePassTimestampWrites? = null,
) : GPUObjectDescriptorBase {
    public companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(interop: GPUComputePassDescriptor, native: WGPUComputePassDescriptor) {
            Converter.convert(this@Arena, interop.label) { native.label = it}
            if (interop.timestampWrites != null) {
                val writes = WGPUComputePassTimestampWrites.allocate(this@Arena)
                GPUComputePassTimestampWrites.convert(interop.timestampWrites, writes)
                native.timestampWrites = writes.`$mem`
            }
        }
    }
}
