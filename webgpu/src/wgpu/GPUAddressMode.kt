package wgpu

import lib.wgpu.WGPUAddressMode

public enum class GPUAddressMode(
    public val interop: WGPUAddressMode,
) {
    ClampToEdge(WGPUAddressMode.ClampToEdge),
    Repeat(WGPUAddressMode.Repeat),
    MirrorRepeat(WGPUAddressMode.MirrorRepeat),
    ;
}
