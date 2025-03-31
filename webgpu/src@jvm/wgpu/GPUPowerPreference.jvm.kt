package wgpu

import lib.wgpu.WGPUPowerPreference

public typealias GPUPowerPreferenceInterop = WGPUPowerPreference

public actual enum class GPUPowerPreference(
    internal val interop: GPUPowerPreferenceInterop,
) {
    LowPower(GPUPowerPreferenceInterop.LowPower),
    HighPerformance(GPUPowerPreferenceInterop.HighPerformance),
    ;

    public fun into(): GPUPowerPreferenceInterop = interop

    public companion object {
        public fun from(v: GPUPowerPreferenceInterop): GPUPowerPreference = when (v) {
            GPUPowerPreferenceInterop.LowPower -> LowPower
            GPUPowerPreferenceInterop.HighPerformance -> HighPerformance
            else -> error("Invalid GPUPowerPreference: $v")
        }
    }
}
