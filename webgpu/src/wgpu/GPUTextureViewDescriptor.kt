package wgpu

/**
 * @param format - The format of the texture view. Must be either the [wgpu.GPUTextureDescriptor.format] of the
 * texture or one of the [wgpu.GPUTextureDescriptor.viewFormats] specified during its creation.
 * @param dimension - The dimension to view the texture as.
 * @param usage - The allowed {{GPUTextureUsage|usage(s)}} for the texture view. Must be a subset of the
 * [wgpu.GPUTexture.usage] flags of the texture. If 0, defaults to the full set of
 * [wgpu.GPUTexture.usage] flags of the texture.
 *
 * Note: If the view's [wgpu.GPUTextureViewDescriptor.format] doesn't support all of the
 * texture's [wgpu.GPUTextureDescriptor.usage]s, the default will fail,
 * and the view's [wgpu.GPUTextureViewDescriptor.usage] must be specified explicitly.
 * @param aspect - Which {{GPUTextureAspect|aspect(s)}} of the texture are accessible to the texture view.
 * @param baseMipLevel - The first (most detailed) mipmap level accessible to the texture view.
 * @param mipLevelCount - How many mipmap levels, starting with [wgpu.GPUTextureViewDescriptor.baseMipLevel], are accessible to
 * the texture view.
 * @param baseArrayLayer - The index of the first array layer accessible to the texture view.
 * @param arrayLayerCount - How many array layers, starting with [wgpu.GPUTextureViewDescriptor.baseArrayLayer], are accessible
 * to the texture view.
 */
public data class GPUTextureViewDescriptor(
    override var label: String = "",
    public var format: GPUTextureFormat? = null,
    public var dimension: GPUTextureViewDimension? = null,
    public var usage: GPUTextureUsageFlags = 0U,
    public var aspect: GPUTextureAspect = GPUTextureAspect.All,
    public var baseMipLevel: GPUIntegerCoordinate = 0U,
    public var mipLevelCount: GPUIntegerCoordinate? = null,
    public var baseArrayLayer: GPUIntegerCoordinate = 0U,
    public var arrayLayerCount: GPUIntegerCoordinate? = null,
) : GPUObjectDescriptorBase(label = label)
