package wgpu

/**
 * @param buffer - The [wgpu.GPUBuffer] to bind.
 * @param offset - The offset, in bytes, from the beginning of [wgpu.GPUBufferBinding.buffer] to the
 * beginning of the range exposed to the shader by the buffer binding.
 * @param size - The size, in bytes, of the buffer binding.
 * If not map/exist|provided, specifies the range starting at
 * [wgpu.GPUBufferBinding.offset] and ending at the end of [wgpu.GPUBufferBinding.buffer].
 */
public data class GPUBufferBinding(
    public var buffer: GPUBuffer,
    public var offset: GPUSize64 = 0UL,
    public var size: GPUSize64? = null,
) : GPUBindingResource
