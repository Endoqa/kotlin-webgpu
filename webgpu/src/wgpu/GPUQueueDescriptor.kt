package wgpu

public data class GPUQueueDescriptor(
    override var label: String = "",
) : GPUObjectDescriptorBase(label = label)
