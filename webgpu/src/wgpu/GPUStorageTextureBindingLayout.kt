package wgpu

/**
 * @param access - The access mode for this binding, indicating readability and writability.
 * @param format - The required [wgpu.GPUTextureViewDescriptor.format] of texture views bound to this binding.
 * @param viewDimension - Indicates the required [wgpu.GPUTextureViewDescriptor.dimension] for texture views bound to
 * this binding.
 */
public data class GPUStorageTextureBindingLayout(
    public var access: GPUStorageTextureAccess = GPUStorageTextureAccess.WriteOnly,
    public var format: GPUTextureFormat,
    public var viewDimension: GPUTextureViewDimension = GPUTextureViewDimension.`2D`,
)
