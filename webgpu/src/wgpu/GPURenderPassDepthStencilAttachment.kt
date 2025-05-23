package wgpu

/**
 * @param view - A [wgpu.GPUTextureView] describing the texture subresource that will be output to
 * and read from for this depth/stencil attachment.
 * @param depthClearValue - Indicates the value to clear [wgpu.GPURenderPassDepthStencilAttachment.view]'s depth component
 * to prior to executing the render pass. Ignored if [wgpu.GPURenderPassDepthStencilAttachment.depthLoadOp]
 * is not {{GPULoadOp/"clear"}}. Must be between 0.0 and 1.0, inclusive.
 * <!-- POSTV1(unrestricted-depth): unless unrestricted depth is enabled -->
 * @param depthLoadOp - Indicates the load operation to perform on [wgpu.GPURenderPassDepthStencilAttachment.view]'s
 * depth component prior to executing the render pass.
 *
 * Note: It is recommended to prefer clearing; see {{GPULoadOp/"clear"}} for details.
 * @param depthStoreOp - The store operation to perform on [wgpu.GPURenderPassDepthStencilAttachment.view]'s
 * depth component after executing the render pass.
 * @param depthReadOnly - Indicates that the depth component of [wgpu.GPURenderPassDepthStencilAttachment.view]
 * is read only.
 * @param stencilClearValue - Indicates the value to clear [wgpu.GPURenderPassDepthStencilAttachment.view]'s stencil component
 * to prior to executing the render pass. Ignored if [wgpu.GPURenderPassDepthStencilAttachment.stencilLoadOp]
 * is not {{GPULoadOp/"clear"}}.
 *
 * The value will be converted to the type of the stencil aspect of |view| by taking the same
 * number of LSBs as the number of bits in the stencil aspect of one texel block|texel of |view|.
 * @param stencilLoadOp - Indicates the load operation to perform on [wgpu.GPURenderPassDepthStencilAttachment.view]'s
 * stencil component prior to executing the render pass.
 *
 * Note: It is recommended to prefer clearing; see {{GPULoadOp/"clear"}} for details.
 * @param stencilStoreOp - The store operation to perform on [wgpu.GPURenderPassDepthStencilAttachment.view]'s
 * stencil component after executing the render pass.
 * @param stencilReadOnly - Indicates that the stencil component of [wgpu.GPURenderPassDepthStencilAttachment.view]
 * is read only.
 */
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
