package wgpu

/**
 * @param addressModeU -
 * @param addressModeV -
 * @param addressModeW - Specifies the {{GPUAddressMode|address modes}} for the texture width, height, and depth
 * coordinates, respectively.
 * @param magFilter - Specifies the sampling behavior when the sampled area is smaller than or equal to one
 * texel.
 * @param minFilter - Specifies the sampling behavior when the sampled area is larger than one texel.
 * @param mipmapFilter - Specifies behavior for sampling between mipmap levels.
 * @param lodMinClamp -
 * @param lodMaxClamp - Specifies the minimum and maximum levels of detail, respectively, used internally when
 * sampling a texture.
 * @param compare - When provided the sampler will be a comparison sampler with the specified
 * [wgpu.GPUCompareFunction].
 *
 * Note: Comparison samplers may use filtering, but the sampling results will be
 * implementation-dependent and may differ from the normal filtering rules.
 * @param maxAnisotropy - Specifies the maximum anisotropy value clamp used by the sampler. Anisotropic filtering is
 * enabled when [wgpu.GPUSamplerDescriptor.maxAnisotropy] is &gt; 1 and the implementation supports it.
 *
 * Anisotropic filtering improves the image quality of textures sampled at oblique viewing
 * angles. Higher [wgpu.GPUSamplerDescriptor.maxAnisotropy] values indicate the maximum ratio of
 * anisotropy supported when filtering.
 *
 * <div class="note" heading>
 *     Most implementations support [wgpu.GPUSamplerDescriptor.maxAnisotropy] values in range
 *     between 1 and 16, inclusive. The used value of [wgpu.GPUSamplerDescriptor.maxAnisotropy]
 *     will be clamped to the maximum value that the platform supports.
 *
 *     The precise filtering behavior is implementation-dependent.
 * </div>
 */
public data class GPUSamplerDescriptor(
    override var label: String = "",
    public var addressModeU: GPUAddressMode = GPUAddressMode.ClampToEdge,
    public var addressModeV: GPUAddressMode = GPUAddressMode.ClampToEdge,
    public var addressModeW: GPUAddressMode = GPUAddressMode.ClampToEdge,
    public var magFilter: GPUFilterMode = GPUFilterMode.Nearest,
    public var minFilter: GPUFilterMode = GPUFilterMode.Nearest,
    public var mipmapFilter: GPUMipmapFilterMode = GPUMipmapFilterMode.Nearest,
    public var lodMinClamp: Float = 0f,
    public var lodMaxClamp: Float = 32f,
    public var compare: GPUCompareFunction? = null,
    public var maxAnisotropy: UShort = 1U,
) : GPUObjectDescriptorBase(label = label)
