package wgpu

import lib.wgpu.WGPUFilterMode

public enum class GPUFilterMode(
    public val interop: WGPUFilterMode,
) {
    Nearest(WGPUFilterMode.Nearest),
    Linear(WGPUFilterMode.Linear),
    ;
}
