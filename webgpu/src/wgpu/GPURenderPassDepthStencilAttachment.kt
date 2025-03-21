package wgpu

public data class GPURenderPassDepthStencilAttachment(
    public var view: GPUTextureView,
    public var depthClearValue: Float? = null,
    public var depthLoadOp: GPULoadOp? = null,
    public var depthStoreOp: GPUStoreOp? = null,
    public var depthReadOnly: Boolean = false,
    public var stencilClearValue: GPUStencilValue = 0U,
    public var stencilLoadOp: GPULoadOp? = null,
    public var stencilStoreOp: GPUStoreOp? = null,
    public var stencilReadOnly: Boolean = false,
)
