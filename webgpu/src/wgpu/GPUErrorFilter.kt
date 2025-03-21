package wgpu

import lib.wgpu.WGPUErrorFilter

public enum class GPUErrorFilter(
    public val interop: WGPUErrorFilter,
) {
    Validation(WGPUErrorFilter.Validation),
    OutOfMemory(WGPUErrorFilter.OutOfMemory),
    Internal(WGPUErrorFilter.Internal),
    ;
}
