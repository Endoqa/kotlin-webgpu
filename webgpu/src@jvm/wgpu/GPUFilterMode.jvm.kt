package wgpu

import lib.wgpu.WGPUFilterMode

public typealias GPUFilterModeInterop = WGPUFilterMode

public actual enum class GPUFilterMode(
    internal val interop: GPUFilterModeInterop,
) {
    Nearest(GPUFilterModeInterop.Nearest),
    Linear(GPUFilterModeInterop.Linear),
    ;

    public fun into(`out`: GPUFilterModeInterop): GPUFilterModeInterop = interop
}
