package webgpu

import java.lang.foreign.Arena

public data class GPUQuerySetDescriptor(
    override val label: String = "",
    public val type: GPUQueryType,
    public val count: GPUSize32,
) : GPUObjectDescriptorBase {
    public companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(interop: GPUQuerySetDescriptor, native: WGPUQuerySetDescriptor) {
            TODO()
        }
    }
}
