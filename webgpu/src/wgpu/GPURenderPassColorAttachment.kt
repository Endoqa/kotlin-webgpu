package wgpu

/**
 * @param view - A [wgpu.GPUTextureView] describing the texture subresource that will be output to for this
 * color attachment.
 * @param depthSlice - Indicates the depth slice index of {{GPUTextureViewDimension/"3d"}} [wgpu.GPURenderPassColorAttachment.view]
 * that will be output to for this color attachment.
 * @param resolveTarget - A [wgpu.GPUTextureView] describing the texture subresource that will receive the resolved
 * output for this color attachment if [wgpu.GPURenderPassColorAttachment.view] is
 * multisampled.
 * @param clearValue - Indicates the value to clear [wgpu.GPURenderPassColorAttachment.view] to prior to executing the
 * render pass. If not map/exist|provided, defaults to `{r: 0, g: 0, b: 0, a: 0}`. Ignored
 * if [wgpu.GPURenderPassColorAttachment.loadOp] is not {{GPULoadOp/"clear"}}.
 *
 * The components of [wgpu.GPURenderPassColorAttachment.clearValue] are all double values.
 * They are converted [$to a texel value of texture format$] matching the render attachment.
 * If conversion fails, a validation error is generated.
 * @param loadOp - Indicates the load operation to perform on [wgpu.GPURenderPassColorAttachment.view] prior to
 * executing the render pass.
 *
 * Note: It is recommended to prefer clearing; see {{GPULoadOp/"clear"}} for details.
 * @param storeOp - The store operation to perform on [wgpu.GPURenderPassColorAttachment.view]
 * after executing the render pass.
 */
public data class GPURenderPassColorAttachment(
    public var view: GPUTextureView,
    public var depthSlice: GPUIntegerCoordinate? = null,
    public var resolveTarget: GPUTextureView? = null,
    public var clearValue: GPUColor? = null,
    public var loadOp: GPULoadOp,
    public var storeOp: GPUStoreOp,
)
