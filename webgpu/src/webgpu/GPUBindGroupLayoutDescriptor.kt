package webgpu

public data class GPUBindGroupLayoutDescriptor(
    override val label: String = "",
    public val entries: List<GPUBindGroupLayoutEntry>,
) : GPUObjectDescriptorBase 