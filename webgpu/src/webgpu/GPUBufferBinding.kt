package webgpu

public data class GPUBufferBinding(
    public val buffer: GPUBuffer,
    public val offset: GPUSize64 = 0u,
    public val size: GPUSize64 = 0u,
) : GPUBindingResource {
//  public companion object {
//    context(Arena)
//    @JvmStatic
//    internal fun convert(interop: GPUBufferBinding, native: WGPUBuffer) {
//      TODO()
//    }
//  }
}
