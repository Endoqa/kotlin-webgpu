package webgpu

import webgpu.c.WGPURenderPipeline
import webgpu.c.wgpuRenderPipelineGetBindGroupLayout

class GPURenderPipeline(
    internal val pipeline_: WGPURenderPipeline,
    internal val desc: GPURenderPipelineDescriptor,
) : GPUPipelineBase {
    override fun getBindGroupLayout(index: GPUIndex32): GPUBindGroupLayout {
        val layout = wgpuRenderPipelineGetBindGroupLayout(pipeline_, index)

        return GPUBindGroupLayout(layout, GPUBindGroupLayoutDescriptor(entries = emptyList())) // this is what dawn does
    }
}