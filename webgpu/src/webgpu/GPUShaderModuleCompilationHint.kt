package webgpu

public data class GPUShaderModuleCompilationHint(
    public val entryPoint: String,
    public val layout: GPUPipelineLayout? = null,
) {
//  public companion object {
//    context(Arena)
//    @JvmStatic
//    internal fun convert(interop: GPUShaderModuleCompilationHint,
//        native: WGPUShaderModuleCompilationHint) {
//      TODO()
//    }
//  }
}
