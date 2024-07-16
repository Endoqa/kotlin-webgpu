package webgpu


object GPUTextureUsage {
    @JvmStatic
    val None: GPUTextureUsageFlags = 0x0000000000000000u

    @JvmStatic
    val CopySrc: GPUTextureUsageFlags = 0x0000000000000001u

    @JvmStatic
    val CopyDst: GPUTextureUsageFlags = 0x0000000000000002u

    @JvmStatic
    val TextureBinding: GPUTextureUsageFlags = 0x0000000000000004u

    @JvmStatic
    val StorageBinding: GPUTextureUsageFlags = 0x0000000000000008u

    @JvmStatic
    val RenderAttachment: GPUTextureUsageFlags = 0x0000000000000010u

    @JvmStatic
    val TransientAttachment: GPUTextureUsageFlags = 0x0000000000000020u

    @JvmStatic
    val StorageAttachment: GPUTextureUsageFlags = 0x0000000000000040u
}