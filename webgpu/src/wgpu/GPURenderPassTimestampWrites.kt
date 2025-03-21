package wgpu

public data class GPURenderPassTimestampWrites(
    public var querySet: GPUQuerySet,
    public var beginningOfPassWriteIndex: GPUSize32? = null,
    public var endOfPassWriteIndex: GPUSize32? = null,
)
