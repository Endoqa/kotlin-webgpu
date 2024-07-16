package webgpu

interface GPURenderPassLayout : GPUObjectDescriptorBase {

    val colorFormats: List<GPUTextureFormat?>

    val depthStencilFormat: GPUTextureFormat

    val sampleCount: GPUSize32
}
