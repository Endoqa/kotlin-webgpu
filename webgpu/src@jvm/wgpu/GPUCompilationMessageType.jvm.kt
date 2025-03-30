package wgpu

import lib.wgpu.WGPUCompilationMessageType

public typealias GPUCompilationMessageTypeInterop = WGPUCompilationMessageType

public actual enum class GPUCompilationMessageType(
    internal val interop: GPUCompilationMessageTypeInterop,
) {
    Error(GPUCompilationMessageTypeInterop.Error),
    Warning(GPUCompilationMessageTypeInterop.Warning),
    Info(GPUCompilationMessageTypeInterop.Info),
    ;

    public fun into(`out`: GPUCompilationMessageTypeInterop): GPUCompilationMessageTypeInterop = interop
}
