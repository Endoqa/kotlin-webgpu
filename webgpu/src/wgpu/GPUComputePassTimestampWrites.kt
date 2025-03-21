package wgpu

public data class GPUComputePassTimestampWrites(
    public var querySet: GPUQuerySet,
    public var beginningOfPassWriteIndex: GPUSize32? = null,
    public var endOfPassWriteIndex: GPUSize32? = null,
)
