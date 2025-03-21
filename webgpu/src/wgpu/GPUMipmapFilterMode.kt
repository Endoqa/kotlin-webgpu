package wgpu

import lib.wgpu.WGPUMipmapFilterMode

public enum class GPUMipmapFilterMode(
    public val interop: WGPUMipmapFilterMode,
) {
    Nearest(WGPUMipmapFilterMode.Nearest),
    Linear(WGPUMipmapFilterMode.Linear),
    ;
}
