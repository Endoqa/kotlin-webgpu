package wgpu.gen.preprocess

import com.squareup.kotlinpoet.CodeBlock
import idl.*
import webgpu.schema.*
import webgpu.schema.Type
import wgpu.gen.common.resolveKotlinType

fun preprocess(idl: IDL, schema: Schema) {
    removeWebContent(idl)
    replaceGPULimits(idl, schema)
}

private fun removeWebContent(idl: IDL) {

    idl.definitions
        .filterIsInstance<Dictionary>()
        .toList()
        .forEach { dict ->
            if (dict.inherits == "EventInit") {
                val newDict = dict.copy(inherits = null)
                val idx = idl.definitions.indexOf(dict)
                require(idx >= 0)
                idl.definitions[idx] = newDict
            }

        }

}

private fun replaceGPULimits(idl: IDL, schema: Schema) {
    val limits = schema.structs.find { it.name.name == "limits" }
    limits ?: error("limits struct not found, can't generate limits class")

    val members = mutableListOf<DictionaryMember>()

    val dict = Dictionary("GPULimits", members)

    limits.members?.forEach { member ->

        val type = member.type.toIDLType()
        val ktType = resolveKotlinType(type)


        members.add(
            DictionaryMember(
                member.name.camelCase,
                type,
                defaultValue = DefaultValue.PreGenerated(CodeBlock.of("%T.MAX_VALUE", ktType))
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
        is CallbackType -> TODO()
        is ComplexType -> TODO()
        PrimitiveType.CVoid -> TODO()
        PrimitiveType.Bool -> TODO()
        PrimitiveType.NullableString -> TODO()
        PrimitiveType.StringWithDefaultEmpty -> TODO()
        PrimitiveType.OutString -> TODO()
        PrimitiveType.UInt16 -> TODO()
        PrimitiveType.UInt32 -> IntegerType("long", unsigned = true)
        PrimitiveType.UInt64 -> IntegerType("long long", unsigned = true)
        PrimitiveType.USize -> TODO()
        PrimitiveType.Int16 -> TODO()
        PrimitiveType.Int32 -> TODO()
        PrimitiveType.Float32 -> TODO()
        PrimitiveType.NullableFloat32 -> TODO()
        PrimitiveType.Float64 -> TODO()
        PrimitiveType.Float64SuperType -> TODO()
        PrimitiveType.ArrayBool -> TODO()
        PrimitiveType.ArrayString -> TODO()
        PrimitiveType.ArrayUInt16 -> TODO()
        PrimitiveType.ArrayUInt32 -> TODO()
        PrimitiveType.ArrayUInt64 -> TODO()
        PrimitiveType.ArrayUSize -> TODO()
        PrimitiveType.ArrayInt16 -> TODO()
        PrimitiveType.ArrayInt32 -> TODO()
        PrimitiveType.ArrayFloat32 -> TODO()
        PrimitiveType.ArrayFloat64 -> TODO()
    }
}