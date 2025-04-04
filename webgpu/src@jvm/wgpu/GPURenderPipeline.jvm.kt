package wgpu

import lib.wgpu.WGPURenderPipeline
import lib.wgpu.wgpuRenderPipelineGetBindGroupLayout
import lib.wgpu.wgpuRenderPipelineSetLabel

public actual class GPURenderPipeline(
    private val pipeline: WGPURenderPipeline
) : GPUObjectBase, GPUPipelineBase {
    actual override var label: String
        get() = TODO("Not yet implemented")
        set(value) {
            unsafeScope { wgpuRenderPipelineSetLabel(pipeline, value.into()) }
        }

    actual override fun getBindGroupLayout(index: UInt): GPUBindGroupLayout {
        return GPUBindGroupLayout(wgpuRenderPipelineGetBindGroupLayout(pipeline, index))
    }

    public fun into(): WGPURenderPipeline = pipeline
}
