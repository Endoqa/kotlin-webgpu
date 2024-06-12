package webgpu

interface GPUPipelineBase {
    //     [NewObject] GPUBindGroupLayout getBindGroupLayout(unsigned long index);
    fun getBindGroupLayout(index: GPUIndex32): GPUBindGroupLayout
}