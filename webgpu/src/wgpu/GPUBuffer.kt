package wgpu

public expect class GPUBuffer : GPUObjectBase {
    override var label: String

    public val size: GPUSize64Out

    public val usage: GPUFlagsConstant

    public val mapState: GPUBufferMapState

    public suspend fun mapAsync(
        mode: GPUMapModeFlags,
        offset: GPUSize64 = 0UL,
        size: GPUSize64,
    )

    public fun getMappedRange(offset: GPUSize64 = 0UL, size: GPUSize64): NativeBuffer

    public fun unmap()

    public fun destroy()
}
