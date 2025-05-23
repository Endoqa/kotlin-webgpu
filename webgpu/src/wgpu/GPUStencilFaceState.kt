package wgpu

/**
 * @param compare - The [wgpu.GPUCompareFunction] used when testing the {{RenderState/[[stencilReference]]}} value
 * against the fragment's [wgpu.GPURenderPassDescriptor.depthStencilAttachment] stencil values.
 * @param failOp - The [wgpu.GPUStencilOperation] performed if the fragment stencil comparison test described by
 * [wgpu.GPUStencilFaceState.compare] fails.
 * @param depthFailOp - The [wgpu.GPUStencilOperation] performed if the fragment depth comparison described by
 * [wgpu.GPUDepthStencilState.depthCompare] fails.
 * @param passOp - The [wgpu.GPUStencilOperation] performed if the fragment stencil comparison test described by
 * [wgpu.GPUStencilFaceState.compare] passes.
 */
public data class GPUStencilFaceState(
    public var compare: GPUCompareFunction = GPUCompareFunction.Always,
    public var failOp: GPUStencilOperation = GPUStencilOperation.Keep,
    public var depthFailOp: GPUStencilOperation = GPUStencilOperation.Keep,
    public var passOp: GPUStencilOperation = GPUStencilOperation.Keep,
)
