package wgpu

import lib.wgpu.WGPUStoreOp

public enum class GPUStoreOp(
    public val interop: WGPUStoreOp,
) {
    Store(WGPUStoreOp.Store),
    Discard(WGPUStoreOp.Discard),
    ;
}
