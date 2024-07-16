package webgpu

import webgpu.c.WGPUBindGroupEntry
import java.lang.foreign.Arena

data class GPUBindGroupEntry(
    val binding: GPUIndex32,
    val resource: GPUBindingResource,
) {
    companion object {
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
