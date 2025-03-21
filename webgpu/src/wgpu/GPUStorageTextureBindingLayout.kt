package wgpu

public data class GPUStorageTextureBindingLayout(
    public var access: GPUStorageTextureAccess = GPUStorageTextureAccess.WriteOnly,
    public var format: GPUTextureFormat,
    public var viewDimension: GPUTextureViewDimension = GPUTextureViewDimension.`2D`,
)
