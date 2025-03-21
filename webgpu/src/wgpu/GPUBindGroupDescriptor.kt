package wgpu

public data class GPUBindGroupDescriptor(
    override var label: String = "",
    public var layout: GPUBindGroupLayout,
    public var entries: List<GPUBindGroupEntry>,
) : GPUObjectDescriptorBase(label = label)
