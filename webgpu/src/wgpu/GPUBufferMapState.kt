package wgpu

import lib.wgpu.WGPUBufferMapState

public enum class GPUBufferMapState(
    public val interop: WGPUBufferMapState,
) {
    Unmapped(WGPUBufferMapState.Unmapped),
    Pending(WGPUBufferMapState.Pending),
    Mapped(WGPUBufferMapState.Mapped),
    ;
}
