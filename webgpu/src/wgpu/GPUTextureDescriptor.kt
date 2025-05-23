package wgpu

/**
 * @param size - The width, height, and depth or layer count of the texture.
 * @param mipLevelCount - The number of mip levels the texture will contain.
 * @param sampleCount - The sample count of the texture. A [wgpu.GPUTextureDescriptor.sampleCount] &gt; `1` indicates
 * a multisampled texture.
 * @param dimension - Whether the texture is one-dimensional, an array of two-dimensional layers, or three-dimensional.
 * @param format - The format of the texture.
 * @param usage - The allowed usages for the texture.
 * @param viewFormats - Specifies what view [wgpu.GPUTextureViewDescriptor.format] values will be allowed when calling
 * [wgpu.GPUTexture.createView] on this texture (in addition to the texture's actual
 * [wgpu.GPUTextureDescriptor.format]).
 *
 * <div class="note" heading>
 *     Adding a format to this list may have a significant performance impact, so it is best
 *     to avoid adding formats unnecessarily.
 *
 *     The actual performance impact is highly dependent on the target system; developers must
 *     test various systems to find out the impact on their particular application.
 *     For example, on some systems any texture with a [wgpu.GPUTextureDescriptor.format] or
 *     [wgpu.GPUTextureDescriptor.viewFormats] entry including
 *     {{GPUTextureFormat/"rgba8unorm-srgb"}} will perform less optimally than a
 *     {{GPUTextureFormat/"rgba8unorm"}} texture which does not.
 *     Similar caveats exist for other formats and pairs of formats on other systems.
 * </div>
 *
 * Formats in this list must be texture view format compatible with the texture format.
 *
 * <div algorithm data-timeline="const">
 *     Two [wgpu.GPUTextureFormat]s |format| and |viewFormat| are <dfn dfn for="">texture view format compatible</dfn> if:
 *
 *     - |format| equals |viewFormat|, or
 *     - |format| and |viewFormat| differ only in whether they are `srgb` formats (have the `-srgb` suffix).
 * </div>
 */
public data class GPUTextureDescriptor(
    override var label: String = "",
    public var size: GPUExtent3D,
    public var mipLevelCount: GPUIntegerCoordinate = 1U,
    public var sampleCount: GPUSize32 = 1U,
    public var dimension: GPUTextureDimension = GPUTextureDimension.`2D`,
    public var format: GPUTextureFormat,
    public var usage: GPUTextureUsageFlags,
    public var viewFormats: List<GPUTextureFormat> = listOf(),
) : GPUObjectDescriptorBase(label = label)
