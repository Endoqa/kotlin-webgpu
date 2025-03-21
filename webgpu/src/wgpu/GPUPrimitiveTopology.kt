package wgpu

import lib.wgpu.WGPUPrimitiveTopology

public enum class GPUPrimitiveTopology(
    public val interop: WGPUPrimitiveTopology,
) {
    PointList(WGPUPrimitiveTopology.PointList),
    LineList(WGPUPrimitiveTopology.LineList),
    LineStrip(WGPUPrimitiveTopology.LineStrip),
    TriangleList(WGPUPrimitiveTopology.TriangleList),
    TriangleStrip(WGPUPrimitiveTopology.TriangleStrip),
    ;
}
