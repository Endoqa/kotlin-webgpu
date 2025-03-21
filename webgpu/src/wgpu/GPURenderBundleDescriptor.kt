package wgpu

public data class GPURenderBundleDescriptor(
    override var label: String = "",
) : GPUObjectDescriptorBase(label = label)
