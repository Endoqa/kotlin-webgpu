package wgpu

import lib.wgpu.*

public actual class GPUTexture(
    private val texture: WGPUTexture
) : GPUObjectBase {
    actual override var label: String
        get() = TODO()
        set(value) {
            unsafeScope { wgpuTextureSetLabel(texture, value.into()) }
        }

    public actual val width: GPUIntegerCoordinateOut get() = wgpuTextureGetWidth(texture)

    public actual val height: GPUIntegerCoordinateOut get() = wgpuTextureGetHeight(texture)

    public actual val depthOrArrayLayers: GPUIntegerCoordinateOut get() = wgpuTextureGetDepthOrArrayLayers(texture)

    public actual val mipLevelCount: GPUIntegerCoordinateOut get() = wgpuTextureGetMipLevelCount(texture)

    public actual val sampleCount: GPUSize32Out get() = wgpuTextureGetSampleCount(texture)

    public actual val dimension: GPUTextureDimension get() = GPUTextureDimension.from(wgpuTextureGetDimension(texture))

    public actual val format: GPUTextureFormat get() = GPUTextureFormat.from(wgpuTextureGetFormat(texture))

    public actual val usage: GPUFlagsConstant get() = wgpuTextureGetUsage(texture).toUInt()

    public actual fun createView(descriptor: GPUTextureViewDescriptor): GPUTextureView {
        return unsafeScope {
            GPUTextureView(wgpuTextureCreateView(texture, descriptor.into().`$mem`))
        }
    }

    public actual fun destroy() {
        wgpuTextureDestroy(texture)
    }

    public fun into(): WGPUTexture = texture
}
