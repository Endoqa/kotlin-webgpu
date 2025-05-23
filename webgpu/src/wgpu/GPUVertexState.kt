package wgpu

/**
 * @param buffers - A list of [wgpu.GPUVertexBufferLayout]s, each defining the layout of vertex attribute data in a
 * vertex buffer used by this pipeline.
 */
public data class GPUVertexState(
    override var module: GPUShaderModule,
    override var entryPoint: String? = null,
    override var constants: HashMap<String, GPUPipelineConstantValue> = hashMapOf(),
    public var buffers: List<GPUVertexBufferLayout?> = listOf(),
) : GPUProgrammableStage(module = module, entryPoint = entryPoint, constants = constants)
