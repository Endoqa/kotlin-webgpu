package webgpu

object GPUMapMode {
    @JvmStatic
    val None: GPUMapModeFlags = 0x0000000000000000u

    @JvmStatic
    val Read: GPUMapModeFlags = 0x0000000000000001u

    @JvmStatic
    val Write: GPUMapModeFlags = 0x0000000000000002u
}