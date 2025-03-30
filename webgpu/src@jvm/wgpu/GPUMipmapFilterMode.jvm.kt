package wgpu

import lib.wgpu.WGPUMipmapFilterMode

public typealias GPUMipmapFilterModeInterop = WGPUMipmapFilterMode

public actual enum class GPUMipmapFilterMode(
    internal val interop: GPUMipmapFilterModeInterop,
) {
    Nearest(GPUMipmapFilterModeInterop.Nearest),
    Linear(GPUMipmapFilterModeInterop.Linear),
    ;

    public fun into(`out`: GPUMipmapFilterModeInterop): GPUMipmapFilterModeInterop = interop
}
