package webgpu

interface GPUProgrammableStage {
    val module: GPUShaderModule

    val entryPoint: String?

    val constants: MutableMap<String, GPUPipelineConstantValue>?
}
