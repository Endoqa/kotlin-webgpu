package wgpu

public data class GPUCommandEncoderDescriptor(
    override var label: String = "",
) : GPUObjectDescriptorBase(label = label)
