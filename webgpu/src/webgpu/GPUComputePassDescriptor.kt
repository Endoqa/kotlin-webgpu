package webgpu

import Converter
import webgpu.c.WGPUComputePassDescriptor
import webgpu.c.WGPUComputePassTimestampWrites
import java.lang.foreign.Arena

data class GPUComputePassDescriptor(
    override val label: String = "",
    val timestampWrites: GPUComputePassTimestampWrites? = null,
) : GPUObjectDescriptorBase {
    companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(interop: GPUComputePassDescriptor, native: WGPUComputePassDescriptor) {
            Converter.convert(this@Arena, interop.label) { native.label = it }
            if (interop.timestampWrites != null) {
                val writes = WGPUComputePassTimestampWrites.allocate(this@Arena)
                GPUComputePassTimestampWrites.convert(interop.timestampWrites, writes)
                native.timestampWrites = writes.`$mem`
            }
        }
    }
}
