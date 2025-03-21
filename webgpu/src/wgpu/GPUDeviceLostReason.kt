package wgpu

import lib.wgpu.WGPUDeviceLostReason

public enum class GPUDeviceLostReason(
    public val interop: WGPUDeviceLostReason,
) {
    Unknown(WGPUDeviceLostReason.Unknown),
    Destroyed(WGPUDeviceLostReason.Destroyed),
    InstanceDropped(WGPUDeviceLostReason.InstanceDropped),
    FailedCreation(WGPUDeviceLostReason.FailedCreation),
    ;
}
