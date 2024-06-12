package webgpu

import java.lang.foreign.Arena

public data class GPUStorageTextureBindingLayout(
    public val access: GPUStorageTextureAccess = GPUStorageTextureAccess.WriteOnly,
    public val format: GPUTextureFormat,
    public val viewDimension: GPUTextureViewDimension = GPUTextureViewDimension.`2D`,
) {
    public companion object {
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
