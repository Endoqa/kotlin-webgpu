package webgpu

import org.intellij.lang.annotations.Language

public data class GPUShaderModuleDescriptor(
    override val label: String = "",
    @Language("wgsl") public val code: String,
    public val compilationHints: List<GPUShaderModuleCompilationHint> = emptyList(),
) : GPUObjectDescriptorBase {

}
