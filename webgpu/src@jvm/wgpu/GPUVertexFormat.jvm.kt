package wgpu

import lib.wgpu.WGPUVertexFormat

public typealias GPUVertexFormatInterop = WGPUVertexFormat

public actual enum class GPUVertexFormat(
    internal val interop: GPUVertexFormatInterop,
) {
    Uint8(GPUVertexFormatInterop.Uint8),
    Uint8x2(GPUVertexFormatInterop.Uint8x2),
    Uint8x4(GPUVertexFormatInterop.Uint8x4),
    Sint8(GPUVertexFormatInterop.Sint8),
    Sint8x2(GPUVertexFormatInterop.Sint8x2),
    Sint8x4(GPUVertexFormatInterop.Sint8x4),
    Unorm8(GPUVertexFormatInterop.Unorm8),
    Unorm8x2(GPUVertexFormatInterop.Unorm8x2),
    Unorm8x4(GPUVertexFormatInterop.Unorm8x4),
    Snorm8(GPUVertexFormatInterop.Snorm8),
    Snorm8x2(GPUVertexFormatInterop.Snorm8x2),
    Snorm8x4(GPUVertexFormatInterop.Snorm8x4),
    Uint16(GPUVertexFormatInterop.Uint16),
    Uint16x2(GPUVertexFormatInterop.Uint16x2),
    Uint16x4(GPUVertexFormatInterop.Uint16x4),
    Sint16(GPUVertexFormatInterop.Sint16),
    Sint16x2(GPUVertexFormatInterop.Sint16x2),
    Sint16x4(GPUVertexFormatInterop.Sint16x4),
    Unorm16(GPUVertexFormatInterop.Unorm16),
    Unorm16x2(GPUVertexFormatInterop.Unorm16x2),
    Unorm16x4(GPUVertexFormatInterop.Unorm16x4),
    Snorm16(GPUVertexFormatInterop.Snorm16),
    Snorm16x2(GPUVertexFormatInterop.Snorm16x2),
    Snorm16x4(GPUVertexFormatInterop.Snorm16x4),
    Float16(GPUVertexFormatInterop.Float16),
    Float16x2(GPUVertexFormatInterop.Float16x2),
    Float16x4(GPUVertexFormatInterop.Float16x4),
    Float32(GPUVertexFormatInterop.Float32),
    Float32x2(GPUVertexFormatInterop.Float32x2),
    Float32x3(GPUVertexFormatInterop.Float32x3),
    Float32x4(GPUVertexFormatInterop.Float32x4),
    Uint32(GPUVertexFormatInterop.Uint32),
    Uint32x2(GPUVertexFormatInterop.Uint32x2),
    Uint32x3(GPUVertexFormatInterop.Uint32x3),
    Uint32x4(GPUVertexFormatInterop.Uint32x4),
    Sint32(GPUVertexFormatInterop.Sint32),
    Sint32x2(GPUVertexFormatInterop.Sint32x2),
    Sint32x3(GPUVertexFormatInterop.Sint32x3),
    Sint32x4(GPUVertexFormatInterop.Sint32x4),
    Unorm1010102(GPUVertexFormatInterop.Unorm1010102),
    Unorm8x4BGRA(GPUVertexFormatInterop.Unorm8x4BGRA),
    ;

    public fun into(): GPUVertexFormatInterop = interop

    public companion object {
        public fun from(v: GPUVertexFormatInterop): GPUVertexFormat = when (v) {
            GPUVertexFormatInterop.Uint8 -> Uint8
            GPUVertexFormatInterop.Uint8x2 -> Uint8x2
            GPUVertexFormatInterop.Uint8x4 -> Uint8x4
            GPUVertexFormatInterop.Sint8 -> Sint8
            GPUVertexFormatInterop.Sint8x2 -> Sint8x2
            GPUVertexFormatInterop.Sint8x4 -> Sint8x4
            GPUVertexFormatInterop.Unorm8 -> Unorm8
            GPUVertexFormatInterop.Unorm8x2 -> Unorm8x2
            GPUVertexFormatInterop.Unorm8x4 -> Unorm8x4
            GPUVertexFormatInterop.Snorm8 -> Snorm8
            GPUVertexFormatInterop.Snorm8x2 -> Snorm8x2
            GPUVertexFormatInterop.Snorm8x4 -> Snorm8x4
            GPUVertexFormatInterop.Uint16 -> Uint16
            GPUVertexFormatInterop.Uint16x2 -> Uint16x2
            GPUVertexFormatInterop.Uint16x4 -> Uint16x4
            GPUVertexFormatInterop.Sint16 -> Sint16
            GPUVertexFormatInterop.Sint16x2 -> Sint16x2
            GPUVertexFormatInterop.Sint16x4 -> Sint16x4
            GPUVertexFormatInterop.Unorm16 -> Unorm16
            GPUVertexFormatInterop.Unorm16x2 -> Unorm16x2
            GPUVertexFormatInterop.Unorm16x4 -> Unorm16x4
            GPUVertexFormatInterop.Snorm16 -> Snorm16
            GPUVertexFormatInterop.Snorm16x2 -> Snorm16x2
            GPUVertexFormatInterop.Snorm16x4 -> Snorm16x4
            GPUVertexFormatInterop.Float16 -> Float16
            GPUVertexFormatInterop.Float16x2 -> Float16x2
            GPUVertexFormatInterop.Float16x4 -> Float16x4
            GPUVertexFormatInterop.Float32 -> Float32
            GPUVertexFormatInterop.Float32x2 -> Float32x2
            GPUVertexFormatInterop.Float32x3 -> Float32x3
            GPUVertexFormatInterop.Float32x4 -> Float32x4
            GPUVertexFormatInterop.Uint32 -> Uint32
            GPUVertexFormatInterop.Uint32x2 -> Uint32x2
            GPUVertexFormatInterop.Uint32x3 -> Uint32x3
            GPUVertexFormatInterop.Uint32x4 -> Uint32x4
            GPUVertexFormatInterop.Sint32 -> Sint32
            GPUVertexFormatInterop.Sint32x2 -> Sint32x2
            GPUVertexFormatInterop.Sint32x3 -> Sint32x3
            GPUVertexFormatInterop.Sint32x4 -> Sint32x4
            GPUVertexFormatInterop.Unorm1010102 -> Unorm1010102
            GPUVertexFormatInterop.Unorm8x4BGRA -> Unorm8x4BGRA
            else -> error("Invalid GPUVertexFormat: $v")
        }
    }
}
