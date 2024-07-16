package webgpu

data class GPUBufferBinding(
    val buffer: GPUBuffer,
    val offset: GPUSize64 = 0u,
    val size: GPUSize64 = 0u,
) : GPUBindingResource