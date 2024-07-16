package webgpu

import webgpu.c.WGPUBindGroupLayoutEntry
import java.lang.foreign.Arena

data class GPUBindGroupLayoutEntry(
    val binding: GPUIndex32,
    val visibility: GPUShaderStageFlags,
    val buffer: GPUBufferBindingLayout? = null,
    val sampler: GPUSamplerBindingLayout? = null,
    val texture: GPUTextureBindingLayout? = null,
    val storageTexture: GPUStorageTextureBindingLayout? = null,
) {
    companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(interop: GPUBindGroupLayoutEntry, native: WGPUBindGroupLayoutEntry) {
            native.binding = interop.binding
            native.visibility = interop.visibility

            if (interop.buffer != null) {
                GPUBufferBindingLayout.convert(interop.buffer, native.buffer)
            }

            if (interop.sampler != null) {
                GPUSamplerBindingLayout.convert(interop.sampler, native.sampler)
            }

            if (interop.texture != null) {
                GPUTextureBindingLayout.convert(interop.texture, native.texture)
            }

            if (interop.storageTexture != null) {
                GPUStorageTextureBindingLayout.convert(interop.storageTexture, native.storageTexture)
            }


        }
    }
}
