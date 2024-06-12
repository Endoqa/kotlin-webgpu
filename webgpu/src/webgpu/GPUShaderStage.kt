package webgpu


object GPUShaderStage {
    @JvmStatic
    val VERTEX: GPUFlagsConstant = 0x1u

    @JvmStatic
    val FRAGMENT: GPUFlagsConstant = 0x2u

    @JvmStatic
    val COMPUTE: GPUFlagsConstant = 0x4u
}