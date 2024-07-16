package webgpu

data class GPUShaderModuleCompilationHint(
    val entryPoint: String,
    val layout: GPUPipelineLayout? = null,
)
