package wgpu

/**
 * @param sampleType - Indicates the type required for texture views bound to this binding.
 * @param viewDimension - Indicates the required [wgpu.GPUTextureViewDescriptor.dimension] for texture views bound to
 * this binding.
 * @param multisampled - Indicates whether or not texture views bound to this binding must be multisampled.
 */
public data class GPUTextureBindingLayout(
    public var sampleType: GPUTextureSampleType = GPUTextureSampleType.Float,
    public var viewDimension: GPUTextureViewDimension = GPUTextureViewDimension.`2D`,
    public var multisampled: Boolean = false,
)
