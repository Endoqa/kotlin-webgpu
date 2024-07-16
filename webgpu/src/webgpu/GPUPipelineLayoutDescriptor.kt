package webgpu

data class GPUPipelineLayoutDescriptor(
    override val label: String = "",
    val bindGroupLayouts: List<GPUBindGroupLayout>,
) : GPUObjectDescriptorBase 