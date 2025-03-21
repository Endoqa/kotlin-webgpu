package wgpu

public expect class GPURenderPipeline : GPUObjectBase, GPUPipelineBase {
    override var label: String

    override fun getBindGroupLayout(index: UInt): GPUBindGroupLayout
}
