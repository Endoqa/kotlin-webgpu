package wgpu

public data class GPUTexelCopyBufferInfo(
    override var offset: GPUSize64 = 0UL,
    override var bytesPerRow: GPUSize32? = null,
    override var rowsPerImage: GPUSize32? = null,
    public var buffer: GPUBuffer,
) : GPUTexelCopyBufferLayout(offset = offset, bytesPerRow = bytesPerRow, rowsPerImage = rowsPerImage)
