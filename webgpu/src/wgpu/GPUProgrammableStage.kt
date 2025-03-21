package wgpu

public abstract class GPUProgrammableStage(
    public open var module: GPUShaderModule,
    public open var entryPoint: String? = null,
    public open var constants: HashMap<String, GPUPipelineConstantValue> = hashMapOf(),
)
