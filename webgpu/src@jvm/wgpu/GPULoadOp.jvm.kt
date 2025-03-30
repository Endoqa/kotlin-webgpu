package wgpu

import lib.wgpu.WGPULoadOp

public typealias GPULoadOpInterop = WGPULoadOp

public actual enum class GPULoadOp(
    internal val interop: GPULoadOpInterop,
) {
    Load(GPULoadOpInterop.Load),
    Clear(GPULoadOpInterop.Clear),
    ;

    public fun into(`out`: GPULoadOpInterop): GPULoadOpInterop = interop
}
