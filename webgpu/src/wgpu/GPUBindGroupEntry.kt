package wgpu

/**
 * @param binding - A unique identifier for a resource binding within the [wgpu.GPUBindGroup], corresponding to a
 * {{GPUBindGroupLayoutEntry/binding|GPUBindGroupLayoutEntry.binding}} and a @binding
 * attribute in the [wgpu.GPUShaderModule].
 * @param resource - The resource to bind, which may be a [wgpu.GPUSampler], [wgpu.GPUTextureView],
 * [wgpu.GPUExternalTexture], or [wgpu.GPUBufferBinding].
 */
public data class GPUBindGroupEntry(
    public var binding: GPUIndex32,
    public var resource: GPUBindingResource,
)
