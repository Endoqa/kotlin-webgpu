package wgpu

public data class GPUTextureBindingLayout(
    public var sampleType: GPUTextureSampleType = GPUTextureSampleType.Float,
    public var viewDimension: GPUTextureViewDimension = GPUTextureViewDimension.`2D`,
    public var multisampled: Boolean = false,
)
