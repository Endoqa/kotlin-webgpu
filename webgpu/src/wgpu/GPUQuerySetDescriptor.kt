package wgpu

public data class GPUQuerySetDescriptor(
    override var label: String = "",
    public var type: GPUQueryType,
    public var count: GPUSize32,
) : GPUObjectDescriptorBase(label = label)
