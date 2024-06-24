package webgpu

import java.lang.foreign.Arena

public data class GPUPipelineLayoutDescriptor(
    override val label: String = "",
    public val bindGroupLayouts: List<GPUBindGroupLayout>,
) : GPUObjectDescriptorBase 