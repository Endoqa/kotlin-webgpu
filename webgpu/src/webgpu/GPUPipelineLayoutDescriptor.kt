package webgpu

import java.lang.foreign.Arena

public data class GPUPipelineLayoutDescriptor(
    override val label: String = "",
    public val bindGroupLayouts: List<GPUBindGroupLayout>,
) : GPUObjectDescriptorBase {
    public companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(
            interop: GPUPipelineLayoutDescriptor,
            native: WGPUPipelineLayoutDescriptor
        ) {
            TODO()
        }
    }
}
