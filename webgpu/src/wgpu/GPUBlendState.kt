package wgpu

/**
 * @param color - Defines the blending behavior of the corresponding render target for color channels.
 * @param alpha - Defines the blending behavior of the corresponding render target for the alpha channel.
 */
public data class GPUBlendState(
    public var color: GPUBlendComponent,
    public var alpha: GPUBlendComponent,
)
