package wgpu

import lib.wgpu.WGPUFrontFace

public enum class GPUFrontFace(
    public val interop: WGPUFrontFace,
) {
    CCW(WGPUFrontFace.CCW),
    CW(WGPUFrontFace.CW),
    ;
}
