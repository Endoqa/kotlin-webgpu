package wgpu

import lib.wgpu.WGPUIndexFormat

public typealias GPUIndexFormatInterop = WGPUIndexFormat

public actual enum class GPUIndexFormat(
    internal val interop: GPUIndexFormatInterop,
) {
    Uint16(GPUIndexFormatInterop.Uint16),
    Uint32(GPUIndexFormatInterop.Uint32),
    ;

    public fun into(`out`: GPUIndexFormatInterop): GPUIndexFormatInterop = interop
}
