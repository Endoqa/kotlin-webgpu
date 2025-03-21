package wgpu

import lib.wgpu.WGPUIndexFormat

public enum class GPUIndexFormat(
    public val interop: WGPUIndexFormat,
) {
    Uint16(WGPUIndexFormat.Uint16),
    Uint32(WGPUIndexFormat.Uint32),
    ;
}
