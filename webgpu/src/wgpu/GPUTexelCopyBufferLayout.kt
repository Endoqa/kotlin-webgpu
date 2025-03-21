package wgpu

public abstract class GPUTexelCopyBufferLayout(
    public open var offset: GPUSize64 = 0UL,
    public open var bytesPerRow: GPUSize32? = null,
    public open var rowsPerImage: GPUSize32? = null,
)
