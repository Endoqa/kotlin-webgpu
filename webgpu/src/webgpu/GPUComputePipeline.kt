package webgpu

import webgpu.c.WGPUComputePipeline
import webgpu.c.wgpuComputePipelineGetBindGroupLayout
import java.lang.foreign.Arena

class GPUComputePipeline(
    internal val pipeline_: WGPUComputePipeline,
    internal val desc_: GPUComputePipelineDescriptor,
    internal val arena: Arena,
) : GPUPipelineBase {
    override fun getBindGroupLayout(index: GPUIndex32): GPUBindGroupLayout {
        val layout = wgpuComputePipelineGetBindGroupLayout(pipeline_, index)
        return GPUBindGroupLayout(layout, GPUBindGroupLayoutDescriptor(entries = emptyList())) // this is what dawn does
    }


}