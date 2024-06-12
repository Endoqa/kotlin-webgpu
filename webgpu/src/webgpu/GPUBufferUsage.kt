package webgpu


object GPUBufferUsage {
    @JvmStatic
    val MAP_READ: GPUFlagsConstant = 0x0001u

    @JvmStatic
    val MAP_WRITE: GPUFlagsConstant = 0x0002u

    @JvmStatic
    val COPY_SRC: GPUFlagsConstant = 0x0004u

    @JvmStatic
    val COPY_DST: GPUFlagsConstant = 0x0008u

    @JvmStatic
    val INDEX: GPUFlagsConstant = 0x0010u

    @JvmStatic
    val VERTEX: GPUFlagsConstant = 0x0020u

    @JvmStatic
    val UNIFORM: GPUFlagsConstant = 0x0040u

    @JvmStatic
    val STORAGE: GPUFlagsConstant = 0x0080u

    @JvmStatic
    val INDIRECT: GPUFlagsConstant = 0x0100u

    @JvmStatic
    val QUERY_RESOLVE: GPUFlagsConstant = 0x0200u

}