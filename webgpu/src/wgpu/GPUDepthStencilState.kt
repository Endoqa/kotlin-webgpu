package wgpu

public data class GPUDepthStencilState(
    public var format: GPUTextureFormat,
    public var depthWriteEnabled: Boolean? = null,
    public var depthCompare: GPUCompareFunction? = null,
    public var stencilFront: GPUStencilFaceState = GPUStencilFaceState(),
    public var stencilBack: GPUStencilFaceState = GPUStencilFaceState(),
    public var stencilReadMask: GPUStencilValue = 0xFFFFFFFFU,
    public var stencilWriteMask: GPUStencilValue = 0xFFFFFFFFU,
    public var depthBias: GPUDepthBias = 0,
    public var depthBiasSlopeScale: Float = 0f,
    public var depthBiasClamp: Float = 0f,
)
