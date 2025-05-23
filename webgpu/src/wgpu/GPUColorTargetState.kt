package wgpu

/**
 * @param format - The [wgpu.GPUTextureFormat] of this color target. The pipeline will only be compatible with
 * [wgpu.GPURenderPassEncoder]s which use a [wgpu.GPUTextureView] of this format in the
 * corresponding color attachment.
 * @param blend - The blending behavior for this color target. If left undefined, disables blending for this
 * color target.
 * @param writeMask - Bitmask controlling which channels are are written to when drawing to this color target.
 */
public data class GPUColorTargetState(
    public var format: GPUTextureFormat,
    public var blend: GPUBlendState? = null,
    public var writeMask: GPUColorWriteFlags = 0xFU,
)
