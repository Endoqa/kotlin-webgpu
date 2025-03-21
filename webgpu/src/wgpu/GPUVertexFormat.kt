package wgpu

import lib.wgpu.WGPUVertexFormat

public enum class GPUVertexFormat(
    public val interop: WGPUVertexFormat,
) {
    Uint8(WGPUVertexFormat.Uint8),
    Uint8x2(WGPUVertexFormat.Uint8x2),
    Uint8x4(WGPUVertexFormat.Uint8x4),
    Sint8(WGPUVertexFormat.Sint8),
    Sint8x2(WGPUVertexFormat.Sint8x2),
    Sint8x4(WGPUVertexFormat.Sint8x4),
    Unorm8(WGPUVertexFormat.Unorm8),
    Unorm8x2(WGPUVertexFormat.Unorm8x2),
    Unorm8x4(WGPUVertexFormat.Unorm8x4),
    Snorm8(WGPUVertexFormat.Snorm8),
    Snorm8x2(WGPUVertexFormat.Snorm8x2),
    Snorm8x4(WGPUVertexFormat.Snorm8x4),
    Uint16(WGPUVertexFormat.Uint16),
    Uint16x2(WGPUVertexFormat.Uint16x2),
    Uint16x4(WGPUVertexFormat.Uint16x4),
    Sint16(WGPUVertexFormat.Sint16),
    Sint16x2(WGPUVertexFormat.Sint16x2),
    Sint16x4(WGPUVertexFormat.Sint16x4),
    Unorm16(WGPUVertexFormat.Unorm16),
    Unorm16x2(WGPUVertexFormat.Unorm16x2),
    Unorm16x4(WGPUVertexFormat.Unorm16x4),
    Snorm16(WGPUVertexFormat.Snorm16),
    Snorm16x2(WGPUVertexFormat.Snorm16x2),
    Snorm16x4(WGPUVertexFormat.Snorm16x4),
    Float16(WGPUVertexFormat.Float16),
    Float16x2(WGPUVertexFormat.Float16x2),
    Float16x4(WGPUVertexFormat.Float16x4),
    Float32(WGPUVertexFormat.Float32),
    Float32x2(WGPUVertexFormat.Float32x2),
    Float32x3(WGPUVertexFormat.Float32x3),
    Float32x4(WGPUVertexFormat.Float32x4),
    Uint32(WGPUVertexFormat.Uint32),
    Uint32x2(WGPUVertexFormat.Uint32x2),
    Uint32x3(WGPUVertexFormat.Uint32x3),
    Uint32x4(WGPUVertexFormat.Uint32x4),
    Sint32(WGPUVertexFormat.Sint32),
    Sint32x2(WGPUVertexFormat.Sint32x2),
    Sint32x3(WGPUVertexFormat.Sint32x3),
    Sint32x4(WGPUVertexFormat.Sint32x4),
    Unorm1010102(WGPUVertexFormat.Unorm1010102),
    Unorm8x4BGRA(WGPUVertexFormat.Unorm8x4BGRA),
    ;
}
