package wgpu

public data class GPUComputePassDescriptor(
    override var label: String = "",
    public var timestampWrites: GPUComputePassTimestampWrites? = null,
) : GPUObjectDescriptorBase(label = label)
