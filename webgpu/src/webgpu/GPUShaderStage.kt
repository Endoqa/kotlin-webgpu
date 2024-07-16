package webgpu


object GPUShaderStage {
    @JvmStatic
    val None: GPUShaderStageFlags = 0x0000000000000000u

    @JvmStatic
    val Vertex: GPUShaderStageFlags = 0x0000000000000001u

    @JvmStatic
    val Fragment: GPUShaderStageFlags = 0x0000000000000002u

    @JvmStatic
    val Compute: GPUShaderStageFlags = 0x0000000000000004u
}