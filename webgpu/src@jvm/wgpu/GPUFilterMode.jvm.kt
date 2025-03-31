package wgpu

import lib.wgpu.WGPUFilterMode

public typealias GPUFilterModeInterop = WGPUFilterMode

public actual enum class GPUFilterMode(
    internal val interop: GPUFilterModeInterop,
) {
    Nearest(GPUFilterModeInterop.Nearest),
    Linear(GPUFilterModeInterop.Linear),
    ;

    public fun into(): GPUFilterModeInterop = interop

    public companion object {
        public fun from(v: GPUFilterModeInterop): GPUFilterMode = when (v) {
            GPUFilterModeInterop.Nearest -> Nearest
            GPUFilterModeInterop.Linear -> Linear
            else -> error("Invalid GPUFilterMode: $v")
        }
    }
}
