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

    public fun into(): GPUPrimitiveTopologyInterop = interop

    public companion object {
        public fun from(v: GPUPrimitiveTopologyInterop): GPUPrimitiveTopology = when (v) {
            GPUPrimitiveTopologyInterop.PointList -> PointList
            GPUPrimitiveTopologyInterop.LineList -> LineList
            GPUPrimitiveTopologyInterop.LineStrip -> LineStrip
            GPUPrimitiveTopologyInterop.TriangleList -> TriangleList
            GPUPrimitiveTopologyInterop.TriangleStrip -> TriangleStrip
            else -> error("Invalid GPUPrimitiveTopology: ${'$'}v")
        }
    }
}
