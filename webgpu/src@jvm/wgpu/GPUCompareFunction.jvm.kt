package wgpu

import lib.wgpu.WGPUCompareFunction

public typealias GPUCompareFunctionInterop = WGPUCompareFunction

public actual enum class GPUCompareFunction(
    internal val interop: GPUCompareFunctionInterop,
) {
    Never(GPUCompareFunctionInterop.Never),
    Less(GPUCompareFunctionInterop.Less),
    Equal(GPUCompareFunctionInterop.Equal),
    LessEqual(GPUCompareFunctionInterop.LessEqual),
    Greater(GPUCompareFunctionInterop.Greater),
    NotEqual(GPUCompareFunctionInterop.NotEqual),
    GreaterEqual(GPUCompareFunctionInterop.GreaterEqual),
    Always(GPUCompareFunctionInterop.Always),
    ;

    public fun into(`out`: GPUCompareFunctionInterop): GPUCompareFunctionInterop = interop
}
