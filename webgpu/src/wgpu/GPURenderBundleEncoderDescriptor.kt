package wgpu

/**
 * @param depthReadOnly - If `true`, indicates that the render bundle does not modify the depth component of the
 * [wgpu.GPURenderPassDepthStencilAttachment] of any render pass the render bundle is executed
 * in.
 *
 * See read-only depth-stencil.
 * @param stencilReadOnly - If `true`, indicates that the render bundle does not modify the stencil component of the
 * [wgpu.GPURenderPassDepthStencilAttachment] of any render pass the render bundle is executed
 * in.
 *
 * See read-only depth-stencil.
 */
public data class GPURenderBundleEncoderDescriptor(
    override var label: String = "",
    override var colorFormats: List<GPUTextureFormat?>,
    override var depthStencilFormat: GPUTextureFormat? = null,
    override var sampleCount: GPUSize32 = 1U,
    public var depthReadOnly: Boolean = false,
    public var stencilReadOnly: Boolean = false,
) : GPURenderPassLayout(colorFormats = colorFormats, depthStencilFormat = depthStencilFormat, sampleCount = sampleCount)
