package wgpu

public data class GPURenderPassColorAttachment(
    public var view: GPUTextureView,
    public var depthSlice: GPUIntegerCoordinate? = null,
    public var resolveTarget: GPUTextureView? = null,
    public var clearValue: GPUColor? = null,
    public var loadOp: GPULoadOp,
    public var storeOp: GPUStoreOp,
)
