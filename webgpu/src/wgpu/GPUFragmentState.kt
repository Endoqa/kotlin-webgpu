package wgpu

/**
 * @param targets - A list of [wgpu.GPUColorTargetState] defining the formats and behaviors of the color targets
 * this pipeline writes to.
 */
public data class GPUFragmentState(
    override var module: GPUShaderModule,
    override var entryPoint: String? = null,
    override var constants: HashMap<String, GPUPipelineConstantValue> = hashMapOf(),
    public var targets: List<GPUColorTargetState?>,
) : GPUProgrammableStage(module = module, entryPoint = entryPoint, constants = constants)
