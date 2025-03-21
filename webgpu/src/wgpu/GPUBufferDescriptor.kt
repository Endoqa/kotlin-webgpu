package wgpu

public data class GPUBufferDescriptor(
    override var label: String = "",
    public var size: GPUSize64,
    public var usage: GPUBufferUsageFlags,
    public var mappedAtCreation: Boolean = false,
) : GPUObjectDescriptorBase(label = label)
