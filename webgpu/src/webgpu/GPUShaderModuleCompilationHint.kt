package webgpu

public data class GPUShaderModuleCompilationHint(
    public val entryPoint: String,
    public val layout: GPUPipelineLayout? = null,
)
