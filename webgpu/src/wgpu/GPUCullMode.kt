package wgpu

import lib.wgpu.WGPUCullMode

public enum class GPUCullMode(
    public val interop: WGPUCullMode,
) {
    None(WGPUCullMode.None),
    Front(WGPUCullMode.Front),
    Back(WGPUCullMode.Back),
    ;
}
