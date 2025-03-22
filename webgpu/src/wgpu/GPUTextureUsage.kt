package wgpu

public object GPUTextureUsage {
    public const val COPY_SRC: GPUFlagsConstant = 1U

    public const val COPY_DST: GPUFlagsConstant = 2U

    public const val TEXTURE_BINDING: GPUFlagsConstant = 4U

    public const val STORAGE_BINDING: GPUFlagsConstant = 8U

    public const val RENDER_ATTACHMENT: GPUFlagsConstant = 16U
}
