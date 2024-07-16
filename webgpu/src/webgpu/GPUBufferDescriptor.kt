package webgpu

data class GPUBufferDescriptor(
    override val label: String = "",
    val size: GPUSize64,
    val usage: GPUBufferUsageFlags,
    val mappedAtCreation: Boolean = false,
) : GPUObjectDescriptorBase
