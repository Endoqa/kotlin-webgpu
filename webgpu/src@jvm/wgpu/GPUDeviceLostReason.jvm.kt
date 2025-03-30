package wgpu

import lib.wgpu.WGPUDeviceLostReason

public typealias GPUDeviceLostReasonInterop = WGPUDeviceLostReason

public actual enum class GPUDeviceLostReason(
    internal val interop: GPUDeviceLostReasonInterop,
) {
    Unknown(GPUDeviceLostReasonInterop.Unknown),
    Destroyed(GPUDeviceLostReasonInterop.Destroyed),
    CallbackCancelled(GPUDeviceLostReasonInterop.CallbackCancelled),
    FailedCreation(GPUDeviceLostReasonInterop.FailedCreation),
    ;

    public fun into(`out`: GPUDeviceLostReasonInterop): GPUDeviceLostReasonInterop = interop
}
