package wgpu

import lib.wgpu.WGPUBufferMapState

public typealias GPUBufferMapStateInterop = WGPUBufferMapState

public actual enum class GPUBufferMapState(
    internal val interop: GPUBufferMapStateInterop,
) {
    Unmapped(GPUBufferMapStateInterop.Unmapped),
    Pending(GPUBufferMapStateInterop.Pending),
    Mapped(GPUBufferMapStateInterop.Mapped),
    ;

    public fun into(`out`: GPUBufferMapStateInterop): GPUBufferMapStateInterop = interop
}
