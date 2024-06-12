package webgpu

public interface GPUProgrammableStage {
    public val module: GPUShaderModule

    public val entryPoint: String?

    public val constants: MutableMap<String, GPUPipelineConstantValue>?
}
