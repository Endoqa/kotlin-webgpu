package wgpu

public data class GPUBindGroupLayoutDescriptor(
    override var label: String = "",
    public var entries: List<GPUBindGroupLayoutEntry>,
) : GPUObjectDescriptorBase(label = label)
