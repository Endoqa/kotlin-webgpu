package wgpu

public data class GPUShaderModuleDescriptor(
    override var label: String = "",
    public var code: String,
    public var compilationHints: List<GPUShaderModuleCompilationHint> = listOf(),
) : GPUObjectDescriptorBase(label = label)
