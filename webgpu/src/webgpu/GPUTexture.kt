package webgpu

import Converter
import webgpu.c.*
import java.lang.foreign.Arena

class GPUTexture(
    internal var texture: WGPUTexture,
    internal val desc_: GPUTextureDescriptor? = null,
    internal val arena: Arena
) {


    val width: GPUIntegerCoordinateOut get() = wgpuTextureGetWidth(texture)
    val height: GPUIntegerCoordinateOut get() = wgpuTextureGetHeight(texture)
    val depthOrArrayLayers: GPUIntegerCoordinateOut get() = wgpuTextureGetDepthOrArrayLayers(texture)
    val mipLevelCount: GPUIntegerCoordinateOut get() = wgpuTextureGetMipLevelCount(texture)
    val sampleCount: GPUSize32Out get() = wgpuTextureGetSampleCount(texture)
    val dimension: GPUTextureDimension get() = wgpuTextureGetDimension(texture)
    val format: GPUTextureFormat get() = wgpuTextureGetFormat(texture)
    val usage: GPUFlagsConstant get() = wgpuTextureGetUsage(texture)


    fun createView(descriptor: GPUTextureViewDescriptor = GPUTextureViewDescriptor()): GPUTextureView {
        val desc = WGPUTextureViewDescriptor.allocate(arena)
        with(arena) {
            desc.baseMipLevel = descriptor.baseMipLevel
            desc.mipLevelCount = descriptor.mipLevelCount
            desc.baseArrayLayer = descriptor.baseArrayLayer
            desc.arrayLayerCount = descriptor.arrayLayerCount
            desc.format = descriptor.format
            desc.dimension = descriptor.dimension
            desc.aspect = descriptor.aspect
            Converter.convert(this, descriptor.label) { desc.label = it }
        }

        val view = wgpuTextureCreateView(texture, desc.`$mem`)
        return GPUTextureView(view, descriptor)
    }

    fun destroy() {
        wgpuTextureDestroy(texture)
    }


    fun _updateInternalTexture(texture: WGPUTexture) {
        this.texture = texture
    }

    fun _opaqueTexture(): Boolean {
        return texture == WGPUTexture.NULL
    }

}