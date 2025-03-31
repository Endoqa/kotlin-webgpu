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

    public fun into(): GPUErrorFilterInterop = interop

    public companion object {
        public fun from(v: GPUErrorFilterInterop): GPUErrorFilter = when (v) {
            GPUErrorFilterInterop.Validation -> Validation
            GPUErrorFilterInterop.OutOfMemory -> OutOfMemory
            GPUErrorFilterInterop.Internal -> Internal
            else -> error("Invalid GPUErrorFilter: $v")
        }
    }
}
