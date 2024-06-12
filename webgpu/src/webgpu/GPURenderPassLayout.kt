package webgpu

public interface GPURenderPassLayout : GPUObjectDescriptorBase {

    public val colorFormats: List<GPUTextureFormat?>

    public val depthStencilFormat: GPUTextureFormat

    public val sampleCount: GPUSize32
}
