package webgpu

import webgpu.c.WGPUStorageTextureBindingLayout
import java.lang.foreign.Arena

data class GPUStorageTextureBindingLayout(
    val access: GPUStorageTextureAccess = GPUStorageTextureAccess.WriteOnly,
    val format: GPUTextureFormat,
    val viewDimension: GPUTextureViewDimension = GPUTextureViewDimension.`2D`,
) {
    companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(
            interop: GPUStorageTextureBindingLayout,
            native: WGPUStorageTextureBindingLayout
        ) {
            native.access = interop.access
            native.format = interop.format
            native.viewDimension = interop.viewDimension
        }
    }
}
