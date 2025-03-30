package wgpu

import lib.wgpu.WGPUStoreOp

public typealias GPUStoreOpInterop = WGPUStoreOp

public actual enum class GPUStoreOp(
    internal val interop: GPUStoreOpInterop,
) {
    Store(GPUStoreOpInterop.Store),
    Discard(GPUStoreOpInterop.Discard),
    ;

    public fun into(`out`: GPUStoreOpInterop): GPUStoreOpInterop = interop
}
