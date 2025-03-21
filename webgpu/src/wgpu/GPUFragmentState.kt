package wgpu

public data class GPUFragmentState(
    override var module: GPUShaderModule,
    override var entryPoint: String? = null,
    override var constants: HashMap<String, GPUPipelineConstantValue> = hashMapOf(),
    public var targets: List<GPUColorTargetState?>,
) : GPUProgrammableStage(module = module, entryPoint = entryPoint, constants = constants)
