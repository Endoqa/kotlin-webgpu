package webgpu

object GPUColorWriteMask {

    @JvmStatic
    val None: GPUColorWriteMaskFlags = 0x0000000000000000u;

    @JvmStatic
    val Red: GPUColorWriteMaskFlags = 0x0000000000000001u;

    @JvmStatic
    val Green: GPUColorWriteMaskFlags = 0x0000000000000002u;

    @JvmStatic
    val Blue: GPUColorWriteMaskFlags = 0x0000000000000004u;

    @JvmStatic
    val Alpha: GPUColorWriteMaskFlags = 0x0000000000000008u;

    @JvmStatic
    val All: GPUColorWriteMaskFlags = 0x000000000000000Fu;
}