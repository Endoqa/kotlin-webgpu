package webgpu

data class GPUBindGroupLayoutDescriptor(
    override val label: String = "",
    val entries: List<GPUBindGroupLayoutEntry>,
) : GPUObjectDescriptorBase 