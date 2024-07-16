package webgpu


object GPUBufferUsage {
    @JvmStatic
    val None: GPUBufferUsageFlags = 0x0000000000000000u

    @JvmStatic
    val MapRead: GPUBufferUsageFlags = 0x0000000000000001u

    @JvmStatic
    val MapWrite: GPUBufferUsageFlags = 0x0000000000000002u

    @JvmStatic
    val CopySrc: GPUBufferUsageFlags = 0x0000000000000004u

    @JvmStatic
    val CopyDst: GPUBufferUsageFlags = 0x0000000000000008u

    @JvmStatic
    val Index: GPUBufferUsageFlags = 0x0000000000000010u

    @JvmStatic
    val Vertex: GPUBufferUsageFlags = 0x0000000000000020u

    @JvmStatic
    val Uniform: GPUBufferUsageFlags = 0x0000000000000040u

    @JvmStatic
    val Storage: GPUBufferUsageFlags = 0x0000000000000080u

    @JvmStatic
    val Indirect: GPUBufferUsageFlags = 0x0000000000000100u

    @JvmStatic
    val QueryResolve: GPUBufferUsageFlags = 0x0000000000000200u
}