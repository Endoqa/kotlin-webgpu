package wgpu

import lib.wgpu.WGPUCompilationMessageType

public enum class GPUCompilationMessageType(
    public val interop: WGPUCompilationMessageType,
) {
    Error(WGPUCompilationMessageType.Error),
    Warning(WGPUCompilationMessageType.Warning),
    Info(WGPUCompilationMessageType.Info),
    ;
}
