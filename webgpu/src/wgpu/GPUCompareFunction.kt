package wgpu

import lib.wgpu.WGPUCompareFunction

public enum class GPUCompareFunction(
    public val interop: WGPUCompareFunction,
) {
    Never(WGPUCompareFunction.Never),
    Less(WGPUCompareFunction.Less),
    Equal(WGPUCompareFunction.Equal),
    LessEqual(WGPUCompareFunction.LessEqual),
    Greater(WGPUCompareFunction.Greater),
    NotEqual(WGPUCompareFunction.NotEqual),
    GreaterEqual(WGPUCompareFunction.GreaterEqual),
    Always(WGPUCompareFunction.Always),
    ;
}
