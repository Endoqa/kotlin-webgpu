package webgpu

import org.intellij.lang.annotations.Language

data class GPUShaderModuleDescriptor(
    override val label: String = "",
    @Language("wgsl") val code: String,
    val compilationHints: List<GPUShaderModuleCompilationHint> = emptyList(),
) : GPUObjectDescriptorBase
