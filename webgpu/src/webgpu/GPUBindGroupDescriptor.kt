package webgpu

data class GPUBindGroupDescriptor(
    override val label: String = "",
    val layout: GPUBindGroupLayout,
    val entries: List<GPUBindGroupEntry>,
) : GPUObjectDescriptorBase
