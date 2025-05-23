package wgpu

/**
 * @param layout - The [wgpu.GPUPipelineLayout] for this pipeline, or {{GPUAutoLayoutMode/"auto"}} to generate
 * the pipeline layout automatically.
 *
 * Note: If {{GPUAutoLayoutMode/"auto"}} is used the pipeline cannot share [wgpu.GPUBindGroup]s
 * with any other pipelines.
 */
public abstract class GPUPipelineDescriptorBase(
    override var label: String = "",
    public open var layout: GPUPipelineLayout?,
) : GPUObjectDescriptorBase(label = label)
