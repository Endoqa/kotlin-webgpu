package wgpu

import lib.wgpu.WGPURenderPipeline

public actual class GPURenderPipeline(
    private val pipeline: WGPURenderPipeline
) : GPUObjectBase, GPUPipelineBase {
    actual override var label: String
        get() = TODO("Not yet implemented")
        set(value) {}

    actual override fun getBindGroupLayout(index: UInt): GPUBindGroupLayout {
        TODO("Not yet implemented")
    }

    public fun into(): WGPURenderPipeline = pipeline

}