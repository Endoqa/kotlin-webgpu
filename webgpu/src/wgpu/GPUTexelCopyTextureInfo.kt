package wgpu

public data class GPUTexelCopyTextureInfo(
    public var texture: GPUTexture,
    public var mipLevel: GPUIntegerCoordinate = 0U,
    public var origin: GPUOrigin3D = GPUOrigin3D(),
    public var aspect: GPUTextureAspect = GPUTextureAspect.All,
)
