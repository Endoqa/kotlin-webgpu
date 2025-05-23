package wgpu

/**
 * @param format - The [wgpu.GPUTextureViewDescriptor.format] of [wgpu.GPURenderPassDescriptor.depthStencilAttachment]
 * this [wgpu.GPURenderPipeline] will be compatible with.
 * @param depthWriteEnabled - Indicates if this [wgpu.GPURenderPipeline] can modify
 * [wgpu.GPURenderPassDescriptor.depthStencilAttachment] depth values.
 * @param depthCompare - The comparison operation used to test fragment depths against
 * [wgpu.GPURenderPassDescriptor.depthStencilAttachment] depth values.
 * @param stencilFront - Defines how stencil comparisons and operations are performed for front-facing primitives.
 * @param stencilBack - Defines how stencil comparisons and operations are performed for back-facing primitives.
 * @param stencilReadMask - Bitmask controlling which [wgpu.GPURenderPassDescriptor.depthStencilAttachment] stencil value
 * bits are read when performing stencil comparison tests.
 * @param stencilWriteMask - Bitmask controlling which [wgpu.GPURenderPassDescriptor.depthStencilAttachment] stencil value
 * bits are written to when performing stencil operations.
 * @param depthBias - Constant depth bias added to each triangle fragment. See [$biased fragment depth$] for details.
 * @param depthBiasSlopeScale - Depth bias that scales with the triangle fragment’s slope. See [$biased fragment depth$] for details.
 * @param depthBiasClamp - The maximum depth bias of a triangle fragment. See [$biased fragment depth$] for details.
 */
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
