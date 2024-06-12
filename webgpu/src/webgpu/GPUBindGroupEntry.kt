package webgpu

import java.lang.foreign.Arena

public data class GPUBindGroupEntry(
    public val binding: GPUIndex32,
    public val resource: GPUBindingResource,
) {
    public companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(interop: GPUBindGroupEntry, native: WGPUBindGroupEntry) {
            native.binding = interop.binding
            when (val resource = interop.resource) {
                is GPUBufferBinding -> {
                    native.buffer = resource.buffer.buffer_
                    native.offset = resource.offset
                    native.size = resource.size
                }

                is GPUSampler -> {
                    native.sampler = resource.sampler_
                }

                is GPUTextureView -> {
                    native.textureView = resource.view_
                }
            }
        }
    }
}
