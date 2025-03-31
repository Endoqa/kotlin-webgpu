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

    public fun into(): GPUAddressModeInterop = interop

    public companion object {
        public fun from(v: GPUAddressModeInterop): GPUAddressMode = when (v) {
            GPUAddressModeInterop.ClampToEdge -> ClampToEdge
            GPUAddressModeInterop.Repeat -> Repeat
            GPUAddressModeInterop.MirrorRepeat -> MirrorRepeat
            else -> error("Invalid GPUAddressMode: $v")
        }
    }
}
