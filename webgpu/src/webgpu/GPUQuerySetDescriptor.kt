package webgpu

import webgpu.c.WGPUQuerySetDescriptor
import java.lang.foreign.Arena

data class GPUQuerySetDescriptor(
    override val label: String = "",
    val type: GPUQueryType,
    val count: GPUSize32,
) : GPUObjectDescriptorBase {
    companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(interop: GPUQuerySetDescriptor, native: WGPUQuerySetDescriptor) {

        }
    }
}
