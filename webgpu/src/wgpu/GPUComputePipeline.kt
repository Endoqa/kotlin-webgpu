package wgpu

public expect class GPUComputePipeline : GPUObjectBase, GPUPipelineBase {
    override var label: String

    override fun getBindGroupLayout(index: UInt): GPUBindGroupLayout
}
