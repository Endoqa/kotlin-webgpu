package wgpu

public data class GPUCommandBufferDescriptor(
    override var label: String = "",
) : GPUObjectDescriptorBase(label = label)
