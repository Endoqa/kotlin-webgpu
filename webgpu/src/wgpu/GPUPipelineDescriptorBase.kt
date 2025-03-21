package wgpu

public abstract class GPUPipelineDescriptorBase(
    override var label: String = "",
    public open var layout: GPUPipelineLayout?,
) : GPUObjectDescriptorBase(label = label)
