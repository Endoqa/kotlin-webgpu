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

    public fun into(): GPUCompilationMessageTypeInterop = interop

    public companion object {
        public fun from(v: GPUCompilationMessageTypeInterop): GPUCompilationMessageType = when (v) {
            GPUCompilationMessageTypeInterop.Error -> Error
            GPUCompilationMessageTypeInterop.Warning -> Warning
            GPUCompilationMessageTypeInterop.Info -> Info
            else -> error("Invalid GPUCompilationMessageType: ${'$'}v")
        }
    }
}
