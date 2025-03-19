package wgpu.gen.preprocess

import idl.Dictionary
import idl.IDL
import idl.NullableType
import idl.UnionType

/**
 * transform `(GPUPipelineLayout or GPUAutoLayoutMode)` into `GPUPipelineLayout?`
 * null means "auto" after transformation.
 *
 * Currently only occurs in [wgpu.GPUPipelineDescriptorBase] and [wgpu.GPUShaderModuleCompilationHint]
 */
fun preprocessAutoLayoutUnion(idl: IDL) {
    transform(idl, "GPUShaderModuleCompilationHint")
    transform(idl, "GPUPipelineDescriptorBase")

    idl.definitions.removeIf { it is idl.Enum && it.name == "GPUAutoLayoutMode" }
}

private fun transform(idl: IDL, identifier: String) {
    val dict = idl.definitions
        .filterIsInstance<Dictionary>()
        .find { it.name == identifier }

    dict ?: error("Could not find $dict")

    val layout = dict.members.find { it.name == "layout" }
    layout ?: error("Could not find layout in $dict")

    val union = layout.type
    require(union is UnionType)

    val newMember = layout.copy(type = NullableType(union.memberTypes[0]))

    val idx = dict.members.indexOf(layout)
    dict.members[idx] = newMember
}
