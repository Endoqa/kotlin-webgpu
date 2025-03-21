package wgpu

public data class GPUColorTargetState(
    public var format: GPUTextureFormat,
    public var blend: GPUBlendState? = null,
    public var writeMask: GPUColorWriteFlags = 0xFU,
)
