package webgpu

public data class GPUBufferDescriptor(
    override val label: String = "",
    public val size: GPUSize64,
    public val usage: GPUBufferUsageFlags,
    public val mappedAtCreation: Boolean = false,
) : GPUObjectDescriptorBase {

}
