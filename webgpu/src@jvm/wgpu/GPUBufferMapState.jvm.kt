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

    public fun into(): GPUBufferMapStateInterop = interop

    public companion object {
        public fun from(v: GPUBufferMapStateInterop): GPUBufferMapState = when (v) {
            GPUBufferMapStateInterop.Unmapped -> Unmapped
            GPUBufferMapStateInterop.Pending -> Pending
            GPUBufferMapStateInterop.Mapped -> Mapped
            else -> error("Invalid GPUBufferMapState: ${'$'}v")
        }
    }
}
