package wgpu

/**
 * @param type - The type of queries managed by [wgpu.GPUQuerySet].
 * @param count - The number of queries managed by [wgpu.GPUQuerySet].
 */
public data class GPUQuerySetDescriptor(
    override var label: String = "",
    public var type: GPUQueryType,
    public var count: GPUSize32,
) : GPUObjectDescriptorBase(label = label)
