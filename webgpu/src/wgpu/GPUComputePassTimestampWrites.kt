package wgpu

/**
 * @param querySet - The [wgpu.GPUQuerySet], of type {{GPUQueryType/"timestamp"}}, that the query results will be
 * written to.
 * @param beginningOfPassWriteIndex - If defined, indicates the query index in [wgpu.GPURenderPassTimestampWrites.querySet] into
 * which the timestamp at the beginning of the compute pass will be written.
 * @param endOfPassWriteIndex - If defined, indicates the query index in [wgpu.GPURenderPassTimestampWrites.querySet] into
 * which the timestamp at the end of the compute pass will be written.
 */
public data class GPUComputePassTimestampWrites(
    public var querySet: GPUQuerySet,
    public var beginningOfPassWriteIndex: GPUSize32? = null,
    public var endOfPassWriteIndex: GPUSize32? = null,
)
