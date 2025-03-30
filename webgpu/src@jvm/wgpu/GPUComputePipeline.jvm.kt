package wgpu

import lib.wgpu.WGPUComputePipeline

public actual class GPUComputePipeline(
    private val pipeline: WGPUComputePipeline
) : GPUObjectBase, GPUPipelineBase {
    actual override var label: String
        get() = TODO("Not yet implemented")
        set(value) {}

    actual override fun getBindGroupLayout(index: UInt): GPUBindGroupLayout {
        TODO("Not yet implemented")
    }

    public fun into(): WGPUComputePipeline = pipeline
}