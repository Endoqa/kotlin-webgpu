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

    public fun into(): GPUCompareFunctionInterop = interop

    public companion object {
        public fun from(v: GPUCompareFunctionInterop): GPUCompareFunction = when (v) {
            GPUCompareFunctionInterop.Never -> Never
            GPUCompareFunctionInterop.Less -> Less
            GPUCompareFunctionInterop.Equal -> Equal
            GPUCompareFunctionInterop.LessEqual -> LessEqual
            GPUCompareFunctionInterop.Greater -> Greater
            GPUCompareFunctionInterop.NotEqual -> NotEqual
            GPUCompareFunctionInterop.GreaterEqual -> GreaterEqual
            GPUCompareFunctionInterop.Always -> Always
            else -> error("Invalid GPUCompareFunction: $v")
        }
    }
}
