package wgpu

import lib.wgpu.WGPUStoreOp

public typealias GPUStoreOpInterop = WGPUStoreOp

public actual enum class GPUStoreOp(
    internal val interop: GPUStoreOpInterop,
) {
    Store(GPUStoreOpInterop.Store),
    Discard(GPUStoreOpInterop.Discard),
    ;

    public fun into(): GPUStoreOpInterop = interop

    public companion object {
        public fun from(v: GPUStoreOpInterop): GPUStoreOp = when (v) {
            GPUStoreOpInterop.Store -> Store
            GPUStoreOpInterop.Discard -> Discard
            else -> error("Invalid GPUStoreOp: $v")
        }
    }
}
