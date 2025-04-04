package wgpu

import lib.wgpu.WGPUComputePipeline
import lib.wgpu.wgpuComputePipelineSetLabel

public actual class GPUComputePipeline(
    private val pipeline: WGPUComputePipeline
) : GPUObjectBase, GPUPipelineBase {
    actual override var label: String
        get() = TODO("Not yet implemented")
        set(value) {
            unsafeScope { wgpuComputePipelineSetLabel(pipeline, value.into()) }
        }

    actual override fun getBindGroupLayout(index: UInt): GPUBindGroupLayout {
        TODO("Not yet implemented")
    }

    public fun into(): WGPUComputePipeline = pipeline
}
