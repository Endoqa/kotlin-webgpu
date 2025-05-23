package wgpu

/**
 * @param timestampWrites - Defines which timestamp values will be written for this pass, and where to write them to.
 */
public data class GPUComputePassDescriptor(
    override var label: String = "",
    public var timestampWrites: GPUComputePassTimestampWrites? = null,
) : GPUObjectDescriptorBase(label = label)
