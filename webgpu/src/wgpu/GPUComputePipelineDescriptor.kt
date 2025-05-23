package wgpu

/**
 * @param compute - Describes the compute shader entry point of the pipeline.
 */
public data class GPUComputePipelineDescriptor(
    override var label: String = "",
    override var layout: GPUPipelineLayout?,
    public var compute: GPUProgrammableStage,
) : GPUPipelineDescriptorBase(layout = layout)
