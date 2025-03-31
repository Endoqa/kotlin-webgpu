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

    public fun into(): GPUDeviceLostReasonInterop = interop

    public companion object {
        public fun from(v: GPUDeviceLostReasonInterop): GPUDeviceLostReason = when (v) {
            GPUDeviceLostReasonInterop.Unknown -> Unknown
            GPUDeviceLostReasonInterop.Destroyed -> Destroyed
            GPUDeviceLostReasonInterop.CallbackCancelled -> CallbackCancelled
            GPUDeviceLostReasonInterop.FailedCreation -> FailedCreation
            else -> error("Invalid GPUDeviceLostReason: $v")
        }
    }
}
