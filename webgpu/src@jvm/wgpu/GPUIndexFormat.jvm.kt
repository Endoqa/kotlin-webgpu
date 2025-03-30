package wgpu

import lib.wgpu.WGPUIndexFormat

public typealias GPUIndexFormatInterop = WGPUIndexFormat

public actual enum class GPUIndexFormat(
    internal val interop: GPUIndexFormatInterop,
) {
    Uint16(GPUIndexFormatInterop.Uint16),
    Uint32(GPUIndexFormatInterop.Uint32),
    ;

    public fun into(): GPUIndexFormatInterop = interop

    public companion object {
        public fun from(v: GPUIndexFormatInterop): GPUIndexFormat = when (v) {
            GPUIndexFormatInterop.Uint16 -> Uint16
            GPUIndexFormatInterop.Uint32 -> Uint32
            else -> error("Invalid GPUIndexFormat: ${'$'}v")
        }
    }
}
