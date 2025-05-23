package wgpu

/**
 * @param binding - A unique identifier for a resource binding within the [wgpu.GPUBindGroupLayout], corresponding
 * to a {{GPUBindGroupEntry/binding|GPUBindGroupEntry.binding}} and a @binding
 * attribute in the [wgpu.GPUShaderModule].
 * @param visibility - A bitset of the members of [wgpu.GPUShaderStage].
 * Each set bit indicates that a [wgpu.GPUBindGroupLayoutEntry]'s resource
 * will be accessible from the associated shader stage.
 * @param buffer - When map/exist|provided=], indicates the [=binding resource type for this [wgpu.GPUBindGroupLayoutEntry]
 * is [wgpu.GPUBufferBinding].
 * @param sampler - When map/exist|provided=], indicates the [=binding resource type for this [wgpu.GPUBindGroupLayoutEntry]
 * is [wgpu.GPUSampler].
 * @param texture - When map/exist|provided=], indicates the [=binding resource type for this [wgpu.GPUBindGroupLayoutEntry]
 * is [wgpu.GPUTextureView].
 * @param storageTexture - When map/exist|provided=], indicates the [=binding resource type for this [wgpu.GPUBindGroupLayoutEntry]
 * is [wgpu.GPUTextureView].
 * @param externalTexture - When map/exist|provided=], indicates the [=binding resource type for this [wgpu.GPUBindGroupLayoutEntry]
 * is either [wgpu.GPUExternalTexture] or [wgpu.GPUTextureView].
 *
 * External textures use several binding slots: see Exceeds the binding slot limits.
 */
public data class GPUBindGroupLayoutEntry(
    public var binding: GPUIndex32,
    public var visibility: GPUShaderStageFlags,
    public var buffer: GPUBufferBindingLayout? = null,
    public var sampler: GPUSamplerBindingLayout? = null,
    public var texture: GPUTextureBindingLayout? = null,
    public var storageTexture: GPUStorageTextureBindingLayout? = null,
)
