package webgpu

data class GPURenderBundleEncoderDescriptor(
    override val label: String = "",
    override val colorFormats: List<GPUTextureFormat>,
    override val depthStencilFormat: GPUTextureFormat = GPUTextureFormat.Undefined,
    override val sampleCount: GPUSize32 = 1u,
    val depthReadOnly: Boolean = false,
    val stencilReadOnly: Boolean = false,
) : GPURenderPassLayout
