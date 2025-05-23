package wgpu

public data class GPUSurfaceConfiguration(
    public var device: GPUDevice,
    public var format: GPUTextureFormat,
    public var usage: ULong,
    public var width: UInt,
    public var height: UInt,
    public var viewFormats: List<GPUTextureFormat>,
    public var alphaMode: GPUCompositeAlphaMode,
    public var presentMode: GPUPresentMode,
)
