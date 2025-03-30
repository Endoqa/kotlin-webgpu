package wgpu

import lib.wgpu.WGPUAddressMode

public typealias GPUAddressModeInterop = WGPUAddressMode

public actual enum class GPUAddressMode(
    internal val interop: GPUAddressModeInterop,
) {
    ClampToEdge(GPUAddressModeInterop.ClampToEdge),
    Repeat(GPUAddressModeInterop.Repeat),
    MirrorRepeat(GPUAddressModeInterop.MirrorRepeat),
    ;

    public fun into(`out`: GPUAddressModeInterop): GPUAddressModeInterop = interop
}
