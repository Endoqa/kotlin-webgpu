package wgpu

/**
 * @param size - The size of the buffer in bytes.
 * @param usage - The allowed usages for the buffer.
 * @param mappedAtCreation - If `true` creates the buffer in an already mapped state, allowing
 * [wgpu.GPUBuffer.getMappedRange] to be called immediately. It is valid to set
 * [wgpu.GPUBufferDescriptor.mappedAtCreation] to `true` even if [wgpu.GPUBufferDescriptor.usage]
 * does not contain [wgpu.GPUBufferUsage.MAP_READ] or [wgpu.GPUBufferUsage.MAP_WRITE]. This can be
 * used to set the buffer's initial data.
 *
 * Guarantees that even if the buffer creation eventually fails, it will still appear as if the
 * mapped range can be written/read to until it is unmapped.
 */
public data class GPUBufferDescriptor(
    override var label: String = "",
    public var size: GPUSize64,
    public var usage: GPUBufferUsageFlags,
    public var mappedAtCreation: Boolean = false,
) : GPUObjectDescriptorBase(label = label)
