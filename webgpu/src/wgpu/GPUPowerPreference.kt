package wgpu

import lib.wgpu.WGPUPowerPreference

public enum class GPUPowerPreference(
    public val interop: WGPUPowerPreference,
) {
    LowPower(WGPUPowerPreference.LowPower),
    HighPerformance(WGPUPowerPreference.HighPerformance),
    ;
}
