package wgpu

import lib.wgpu.WGPUPowerPreference

public typealias GPUPowerPreferenceInterop = WGPUPowerPreference

public actual enum class GPUPowerPreference(
    internal val interop: GPUPowerPreferenceInterop,
) {
    LowPower(GPUPowerPreferenceInterop.LowPower),
    HighPerformance(GPUPowerPreferenceInterop.HighPerformance),
    ;

    public fun into(`out`: GPUPowerPreferenceInterop): GPUPowerPreferenceInterop = interop
}
