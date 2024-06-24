package webgpu

import java.lang.foreign.Arena

public data class GPURenderBundleEncoderDescriptor(
    override val label: String = "",
    override val colorFormats: List<GPUTextureFormat>,
    override val depthStencilFormat: GPUTextureFormat = GPUTextureFormat.Undefined,
    override val sampleCount: GPUSize32 = 1u,
    public val depthReadOnly: Boolean = false,
    public val stencilReadOnly: Boolean = false,
) : GPURenderPassLayout
