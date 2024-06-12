package webgpu


object GPUTextureUsage {
    @JvmStatic
    val COPY_SRC: GPUFlagsConstant = 0x01u

    @JvmStatic
    val COPY_DST: GPUFlagsConstant = 0x02u

    @JvmStatic
    val TEXTURE_BINDING: GPUFlagsConstant = 0x04u

    @JvmStatic
    val STORAGE_BINDING: GPUFlagsConstant = 0x08u

    @JvmStatic
    val RENDER_ATTACHMENT: GPUFlagsConstant = 0x10u
}