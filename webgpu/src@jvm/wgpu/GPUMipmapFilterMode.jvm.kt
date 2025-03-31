package wgpu

import lib.wgpu.WGPUMipmapFilterMode

public typealias GPUMipmapFilterModeInterop = WGPUMipmapFilterMode

public actual enum class GPUMipmapFilterMode(
    internal val interop: GPUMipmapFilterModeInterop,
) {
    Nearest(GPUMipmapFilterModeInterop.Nearest),
    Linear(GPUMipmapFilterModeInterop.Linear),
    ;

    public fun into(): GPUMipmapFilterModeInterop = interop

    public companion object {
        public fun from(v: GPUMipmapFilterModeInterop): GPUMipmapFilterMode = when (v) {
            GPUMipmapFilterModeInterop.Nearest -> Nearest
            GPUMipmapFilterModeInterop.Linear -> Linear
            else -> error("Invalid GPUMipmapFilterMode: $v")
        }
    }
}
