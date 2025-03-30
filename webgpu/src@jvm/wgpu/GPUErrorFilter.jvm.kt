package wgpu

import lib.wgpu.WGPUErrorFilter

public typealias GPUErrorFilterInterop = WGPUErrorFilter

public actual enum class GPUErrorFilter(
    internal val interop: GPUErrorFilterInterop,
) {
    Validation(GPUErrorFilterInterop.Validation),
    OutOfMemory(GPUErrorFilterInterop.OutOfMemory),
    Internal(GPUErrorFilterInterop.Internal),
    ;

    public fun into(`out`: GPUErrorFilterInterop): GPUErrorFilterInterop = interop
}
