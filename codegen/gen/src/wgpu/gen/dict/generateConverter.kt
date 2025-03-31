@file:OptIn(ExperimentalKotlinPoetApi::class)

package wgpu.gen.dict

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import idl.*
import idl.Type
import webgpu.schema.*
import wgpu.gen.GenerateContext
import wgpu.gen.WGPU_PACKAGE
import wgpu.gen.common.resolveActualType
import wgpu.gen.common.resolveKotlinType
import wgpu.schema.toKotlinType
import java.lang.foreign.Arena
import java.lang.foreign.MemorySegment
import java.lang.foreign.ValueLayout

private data class ConverterContext(
    val interopName: ClassName,
    val nativeName: ClassName,
)

context(GenerateContext)
fun generateConverters(idl: IDL): FileSpec.Builder {
    val file = FileSpec.builder(WGPU_PACKAGE, "Converter")

    for (dictionary in idl.definitions.filterIsInstance<Dictionary>()) {
        generateConverter(file, dictionary)
    }


    return file
}


context(GenerateContext)
private fun generateConverter(file: FileSpec.Builder, dictionary: Dictionary) {
    val haveInheritChildren = hasChildInheritance(idl, dictionary)

    if (haveInheritChildren) {
        return
    }

    val interopName = ClassName(WGPU_PACKAGE, dictionary.name)
    val nativeName = ClassName(WGPU_PACKAGE, "Native${dictionary.name}")
    val schema = schema.structs.find { s -> "GPU${s.name.pascalCase}" == dictionary.name }

    if (schema == null) {
        file.addTypeAlias(
            TypeAliasSpec
                .builder(
                    "Native${dictionary.name}",
                    Any::class.asTypeName()
                )
                .addKdoc("TODO")
                .build()
        )
    } else {
        file.addTypeAlias(
            TypeAliasSpec.builder("Native${dictionary.name}", ClassName("lib.wgpu", "W${dictionary.name}")).build()
        )
    }

    val propertySpec = ParameterSpec.builder("out", nativeName)


    if (schema != null) {
        propertySpec.defaultValue("%T.allocate(this@Arena)", nativeName)
    }

    // ptr convert func
    kotlin.run {
        val ptrType = ClassName("lib.wgpu", "Pointer").parameterizedBy(nativeName)
        val func = FunSpec.builder("into")
            .receiver(interopName)
            .addParameter(
                ParameterSpec
                    .builder(
                        "out",
                        ptrType
                    ).build()
            )
            .contextReceivers(Arena::class.asClassName())
            .returns(ptrType)


        if (schema != null) {
            func.addCode("return into(%T(out)).%N", nativeName, "\$mem")
        } else {
            func.addCode("return TODO()")
        }
        file.addFunction(func.build())
    }

    val func = FunSpec.builder("into")
        .receiver(interopName)
        .addParameter(propertySpec.build())
        .contextReceivers(Arena::class.asClassName())
        .returns(nativeName)

    val ctx = ConverterContext(interopName, nativeName)

    with(ctx) {
        handleInheritance(idl, dictionary, func, schema)
        addMembers(func, dictionary.members, schema)
    }
    func.addCode("return out")
    file.addFunction(func.build())
}


context(GenerateContext, ConverterContext)
private fun handleInheritance(
    idl: IDL,
    dict: Dictionary,
    spec: FunSpec.Builder,
    schema: Struct?
) {
    if (dict.inherits == null) {
        return
    }

    val parent = idl.definitions.filterIsInstance<Dictionary>().find { it.name == dict.inherits }
    parent ?: error("Missing parent dictionary: ${dict.inherits}")
    handleInheritance(idl, parent, spec, schema)
    addMembers(
        spec,
        parent.members,
        schema
    )
}


context(GenerateContext, ConverterContext)
private fun addMembers(func: FunSpec.Builder, members: List<DictionaryMember>, schema: Struct?) {
    for (member in members) {
        addMember(func, member, schema)
    }
}

context(GenerateContext, ConverterContext)
private fun addMember(func: FunSpec.Builder, member: DictionaryMember, schema: Struct?) {
    val inSchema = checkMemberInSchema(func, member, schema) ?: return


    val type = resolveActualType(member.type)

    if (handleArrayType(func, member, inSchema)) return
    if (handleNumberType(func, member, type, inSchema)) return
    if (handleStringType(func, member, inSchema)) return
    if (handleStructType(func, member, inSchema)) return
    if (handleNullableEnumType(func, member, inSchema)) return
    if (handleEnumType(func, member, inSchema)) return
    if (handleObjectType(func, member, inSchema)) return

    handleOtherType(func, member, inSchema)
}

context(GenerateContext, ConverterContext)
private fun checkMemberInSchema(
    func: FunSpec.Builder,
    member: DictionaryMember,
    schema: Struct?
): ParameterType? {
    val inSchema = schema?.members?.find { it.name.camelCase == member.name }

    if (schema == null || inSchema == null) {
        func.addComment("todo: no interop for this.${member.name}")
        return null
    }

    return inSchema
}

context(GenerateContext, ConverterContext)
private fun handleNumberType(
    func: FunSpec.Builder,
    member: DictionaryMember,
    type: Type,
    inSchema: ParameterType
): Boolean {
    val isPrimitive = type is FloatType || type is IntegerType

    if (!isPrimitive) {
        return false
    }

    val interopType = resolveKotlinType(resolveActualType(member.type))
    val nativeType = inSchema.type.toKotlinType()
    require(interopType is ClassName)
    require(nativeType is ClassName)

    if (member.isRequired || member.defaultValue != null) {
        func.addStatement("out.${member.name} = this.${member.name}.to%L()", nativeType.simpleName)
    } else {
        func.addStatement(
            "out.${member.name} = this.${member.name}?.to%L() ?: %L",
            nativeType.simpleName,
            when (type) {
                is FloatType -> CodeBlock.of("%T.NaN", Float::class.asClassName())
                is IntegerType -> {
                    val unsigned = nativeType.simpleName.startsWith("U")
                    if (unsigned) {
                        CodeBlock.of("0u")
                    } else {
                        CodeBlock.of("0")
                    }
                }

                else -> error("Unknown type: $type")
            }
        )
    }


    return true
}

context(GenerateContext, ConverterContext)
private fun handleStructType(
    func: FunSpec.Builder,
    member: DictionaryMember,
    inSchema: ParameterType
): Boolean {

    val isStructType = inSchema.type is ComplexType &&
            (inSchema.type as ComplexType).namespace == TypeNamespace.Struct

    if (!isStructType) {
        return false
    }

    val nullable = member.isNullable()

    if (nullable) {
        func.addStatement(
            "this.%N?.into(out.%N)",
            member.name,
            member.name,
        )
    } else {
        func.addStatement(
            "this.%N.into(out.%N)",
            member.name,
            member.name,
        )
    }

    return true
}

context(GenerateContext, ConverterContext)
private fun handleNullableEnumType(
    func: FunSpec.Builder,
    member: DictionaryMember,
    inSchema: ParameterType
): Boolean {

    val isNullableEnum = inSchema.type is ComplexType &&
            (inSchema.type as ComplexType).namespace == TypeNamespace.Enum &&
            !(inSchema.type as ComplexType).isArray &&
            (!member.isRequired && member.defaultValue == null) // nullable and without default value

    if (!isNullableEnum) {
        return false
    }


    // special optional boolean
    if (resolveKotlinType(member.type) == Boolean::class.asTypeName()) {
        func.addStatement(
            "out.%N = this.%N.into()",
            member.name,
            member.name,
        )
        return true
    }


    func.addStatement(
        "out.%N = this.%N?.into() ?: %T.Undefined",
        member.name,
        member.name,
        inSchema.type.toKotlinType()
    )

    return true
}

context(GenerateContext, ConverterContext)
private fun handleEnumType(
    func: FunSpec.Builder,
    member: DictionaryMember,
    inSchema: ParameterType
): Boolean {

    val isEnum = inSchema.type is ComplexType &&
            (inSchema.type as ComplexType).namespace == TypeNamespace.Enum
            && member.type !is StringType

    if (!isEnum) {
        return false
    }


    func.addStatement(
        "out.%N = this.%N.into()",
        member.name,
        member.name,
    )

    return true
}

context(GenerateContext)
private fun DictionaryMember.isNullable() =
    (!isRequired && defaultValue == null) || resolveActualType(type) is NullableType


context(GenerateContext, ConverterContext)
private fun handleObjectType(
    func: FunSpec.Builder,
    member: DictionaryMember,
    inSchema: ParameterType
): Boolean {

    val isObjectType = inSchema.type is ComplexType &&
            (inSchema.type as ComplexType).namespace == TypeNamespace.Object

    if (!isObjectType) {
        return false
    }

    val nullable = member.isNullable()

    if (nullable) {
        func.addStatement(
            "out.%N = this.%N?.into() ?: %T.NULL",
            member.name,
            member.name,
            MemorySegment::class.asClassName()
        )
    } else {
        func.addStatement(
            "out.%N = this.%N.into()",
            member.name,
            member.name
        )
    }

    return true
}

context(GenerateContext, ConverterContext)
private fun handleArrayType(func: FunSpec.Builder, member: DictionaryMember, inSchema: ParameterType): Boolean {
    val isArray = inSchema.type is ComplexType &&
            (inSchema.type as ComplexType).isArray

    if (!isArray) {
        return false
    }

    val countName = singularize(member.name)

    func.addStatement("out.%NCount = this.%N.size.toULong()", countName, member.name)


    // if it is enum
    // example: out.viewFormats = allocateFrom(ValueLayout.JAVA_INT, *this.viewFormats.map { it.interop.value }.toIntArray())
    val isEnum = (inSchema.type as ComplexType).namespace == TypeNamespace.Enum

    if (isEnum) {
        val cb = CodeBlock.builder()
        cb.add(
            "allocateFrom(%T.JAVA_INT, *this.%N.map { it.interop.value }.toIntArray())",
            ValueLayout::class.asTypeName(),
            member.name
        )
        func.addStatement("out.%N = %L", member.name, cb.build())
    } else {
        // else
        // example: out.buffers = allocateList(this.buffers) { it?.into()?.`$mem` ?: MemorySegment.NULL }
        func.addStatement(
            "out.%N = allocateList(this.%N) { it?.into()?.%N ?: %T.NULL }",
            member.name,
            member.name,
            "\$mem",
            MemorySegment::class.asClassName()
        )
    }



    return true
}

context(GenerateContext)
private fun handleStringType(
    func: FunSpec.Builder,
    member: DictionaryMember,
    inSchema: ParameterType
): Boolean {
    val nativeType = inSchema.type
    if (nativeType !is PrimitiveType) {
        return false
    }

    // example: this.entryPoint?.into(out.entryPoint)
    func.addStatement(
        "this.%N?.into(out.%N)",
        member.name,
        member.name
    )

    return true
}

context(GenerateContext, ConverterContext)
private fun handleOtherType(func: FunSpec.Builder, member: DictionaryMember, inSchema: ParameterType) {
    if (!member.isRequired && member.defaultValue == null) {
        func.addStatement(
            "out.%N = this.%N?.into(out.%N) ?: %T.NULL",
            member.name,
            member.name,
            member.name,
            MemorySegment::class.asClassName()
        )
    } else {
        func.addStatement(
            "out.%N = this.%N.into(out.%N)",
            member.name,
            member.name,
            member.name,
        )
    }


}
