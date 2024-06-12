package webgpu

import java.lang.foreign.Arena

public data class GPUBindGroupLayoutEntry(
    public val binding: GPUIndex32,
    public val visibility: GPUShaderStageFlags,
    public val buffer: GPUBufferBindingLayout? = null,
    public val sampler: GPUSamplerBindingLayout? = null,
    public val texture: GPUTextureBindingLayout? = null,
    public val storageTexture: GPUStorageTextureBindingLayout? = null,
) {
    public companion object {
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
