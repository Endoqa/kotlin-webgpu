package wgpu

/**
 * @param bindGroupLayouts - A list of optional [wgpu.GPUBindGroupLayout]s the pipeline will use. Each element corresponds
 * to a @group attribute in the [wgpu.GPUShaderModule], with the `N`th element corresponding
 * with `@group(N)`.
 */
public data class GPUPipelineLayoutDescriptor(
    override var label: String = "",
    public var bindGroupLayouts: List<GPUBindGroupLayout?>,
) : GPUObjectDescriptorBase(label = label)
