package wgpu

public data class GPUPipelineLayoutDescriptor(
    override var label: String = "",
    public var bindGroupLayouts: List<GPUBindGroupLayout?>,
) : GPUObjectDescriptorBase(label = label)
