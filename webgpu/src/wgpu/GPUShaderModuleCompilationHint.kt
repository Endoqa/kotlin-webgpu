package wgpu

public data class GPUShaderModuleCompilationHint(
    public var entryPoint: String,
    public var layout: GPUPipelineLayout? = null,
)
