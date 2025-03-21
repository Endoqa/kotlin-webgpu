package wgpu

public data class GPUExtent3D(
    public var width: GPUIntegerCoordinate,
    public var height: GPUIntegerCoordinate = 1U,
    public var depthOrArrayLayers: GPUIntegerCoordinate = 1U,
)
