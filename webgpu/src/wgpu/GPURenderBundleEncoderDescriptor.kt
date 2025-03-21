package wgpu

public data class GPURenderBundleEncoderDescriptor(
    override var label: String = "",
    override var colorFormats: List<GPUTextureFormat?>,
    override var depthStencilFormat: GPUTextureFormat? = null,
    override var sampleCount: GPUSize32 = 1U,
    public var depthReadOnly: Boolean = false,
    public var stencilReadOnly: Boolean = false,
) : GPURenderPassLayout(colorFormats = colorFormats, depthStencilFormat = depthStencilFormat, sampleCount = sampleCount)
