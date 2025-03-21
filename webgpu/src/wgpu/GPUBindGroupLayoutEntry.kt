package wgpu

public data class GPUBindGroupLayoutEntry(
    public var binding: GPUIndex32,
    public var visibility: GPUShaderStageFlags,
    public var buffer: GPUBufferBindingLayout? = null,
    public var sampler: GPUSamplerBindingLayout? = null,
    public var texture: GPUTextureBindingLayout? = null,
    public var storageTexture: GPUStorageTextureBindingLayout? = null,
)
