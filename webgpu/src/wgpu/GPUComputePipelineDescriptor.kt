package wgpu

public data class GPUComputePipelineDescriptor(
    override var label: String = "",
    override var layout: GPUPipelineLayout?,
    public var compute: GPUProgrammableStage,
) : GPUPipelineDescriptorBase(layout = layout)
