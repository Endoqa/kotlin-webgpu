package wgpu.gen.preprocess

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.CodeBlock
import idl.*
import webgpu.schema.PrimitiveType
import webgpu.schema.Schema
import webgpu.schema.Type
import wgpu.gen.GenerateContext
import wgpu.gen.common.resolveKotlinType

context(GenerateContext)
fun preprocess() {
    removeUnwanted()
    replaceGPULimits(idl, schema)
    processUnionTypedefs(idl)
    preprocessAutoLayoutUnion(idl)
}


private fun replaceGPULimits(idl: IDL, schema: Schema) {
    val limits = schema.structs.find { it.name.name == "limits" }
    limits ?: error("limits struct not found, can't generate limits class")

    val members = mutableListOf<DictionaryMember>()

    val dict = Dictionary("GPULimits", members)

    limits.members?.forEach { member ->

        val type = member.type.toIDLType()
        val ktType = resolveKotlinType(type)


        require(ktType is ClassName)
        members.add(
            DictionaryMember(
                member.name.camelCase,
                type,
                defaultValue = DefaultValue.PreGenerated(
                    CodeBlock.of(
                    run {
                        val name = ktType.simpleName
                        when {
                            name.endsWith("Long") -> "0UL"
                            name.endsWith("Int") -> "0U"
                            else -> error("Unknown type $name for gpu limits")
                        }
                    }
                ))
            )
        )
    }
    idl.definitions.add(dict)


    val deviceDescriptor = idl.definitions.filterIsInstance<Dictionary>().find { it.name == "GPUDeviceDescriptor" }
    deviceDescriptor ?: error("deviceDescriptor dictionary not found, can't generate GPULimits class")

    deviceDescriptor.members.removeIf { it.name == "requiredLimits" }
    deviceDescriptor.members.add(
        1,
        DictionaryMember(
            "requiredLimits",
            Identifier("GPULimits"),
            defaultValue = DefaultValue.DictInitializer
        )
    )


}

private fun Type.toIDLType(): idl.Type {
    return when (this) {
        PrimitiveType.UInt32 -> IntegerType("long", unsigned = true)
        PrimitiveType.UInt64 -> IntegerType("long long", unsigned = true)
        else -> error("Unknown type $this for gpu limits")
    }
}
