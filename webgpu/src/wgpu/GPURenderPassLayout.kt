package wgpu

/**
 * @param colorFormats - A list of the [wgpu.GPUTextureFormat]s of the color attachments for this pass or bundle.
 * @param depthStencilFormat - The [wgpu.GPUTextureFormat] of the depth/stencil attachment for this pass or bundle.
 * @param sampleCount - Number of samples per pixel in the attachments for this pass or bundle.
 */
public abstract class GPURenderPassLayout(
    override var label: String = "",
    public open var colorFormats: List<GPUTextureFormat?>,
    public open var depthStencilFormat: GPUTextureFormat? = null,
    public open var sampleCount: GPUSize32 = 1U,
) : GPUObjectDescriptorBase(label = label)
