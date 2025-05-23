package wgpu

/**
 * @param count - Number of samples per pixel. This [wgpu.GPURenderPipeline] will be compatible only
 * with attachment textures ([wgpu.GPURenderPassDescriptor.colorAttachments]
 * and [wgpu.GPURenderPassDescriptor.depthStencilAttachment])
 * with matching [wgpu.GPUTextureDescriptor.sampleCount]s.
 * @param mask - Mask determining which samples are written to.
 * @param alphaToCoverageEnabled - When `true` indicates that a fragment's alpha channel should be used to generate a sample
 * coverage mask.
 */
public data class GPUMultisampleState(
    public var count: GPUSize32 = 1U,
    public var mask: GPUSampleMask = 0xFFFFFFFFU,
    public var alphaToCoverageEnabled: Boolean = false,
)
