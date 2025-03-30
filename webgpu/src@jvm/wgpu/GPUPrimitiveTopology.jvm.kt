package wgpu

import lib.wgpu.WGPUPrimitiveTopology

public typealias GPUPrimitiveTopologyInterop = WGPUPrimitiveTopology

public actual enum class GPUPrimitiveTopology(
    internal val interop: GPUPrimitiveTopologyInterop,
) {
    PointList(GPUPrimitiveTopologyInterop.PointList),
    LineList(GPUPrimitiveTopologyInterop.LineList),
    LineStrip(GPUPrimitiveTopologyInterop.LineStrip),
    TriangleList(GPUPrimitiveTopologyInterop.TriangleList),
    TriangleStrip(GPUPrimitiveTopologyInterop.TriangleStrip),
    ;

    public fun into(`out`: GPUPrimitiveTopologyInterop): GPUPrimitiveTopologyInterop = interop
}
