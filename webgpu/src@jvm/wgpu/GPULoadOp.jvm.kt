package wgpu

import lib.wgpu.WGPULoadOp

public typealias GPULoadOpInterop = WGPULoadOp

public actual enum class GPULoadOp(
    internal val interop: GPULoadOpInterop,
) {
    Load(GPULoadOpInterop.Load),
    Clear(GPULoadOpInterop.Clear),
    ;

    public fun into(): GPULoadOpInterop = interop

    public companion object {
        public fun from(v: GPULoadOpInterop): GPULoadOp = when (v) {
            GPULoadOpInterop.Load -> Load
            GPULoadOpInterop.Clear -> Clear
            else -> error("Invalid GPULoadOp: ${'$'}v")
        }
    }
}
