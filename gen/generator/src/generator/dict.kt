@file:OptIn(ExperimentalKotlinPoetApi::class)

package generator

import com.squareup.kotlinpoet.*
import idl.*
import idl.parser.hyphenToCamelCase
import java.io.File
import java.lang.foreign.Arena

context(GenerateContext)
fun genDict(dictionary: Dictionary) {


    val file = FileSpec.builder("webgpu", dictionary.name)
    val ktType = ClassName("webgpu", dictionary.name)

    val noParent = dictionary.noParentInheritance()

    val type = if (noParent) {
        TypeSpec.classBuilder(ktType)
    } else {
        TypeSpec.interfaceBuilder(ktType)
    }

    dictionary.inherits?.let { inherit ->
        type.addSuperinterface(ClassName("webgpu", inherit))
    }




    genMembers(dictionary, type, false, noParent)


    if (noParent) {
        type.addModifiers(KModifier.DATA)

        genConstructor(dictionary, type)

        generateConverter(type, dictionary)
    }

    file.addType(type.build())

    file.build().writeTo(File("interop"))
}

context(GenerateContext)
private fun generateConverter(type: TypeSpec.Builder, dictionary: Dictionary) {
    val obj = TypeSpec.companionObjectBuilder()
    val func = FunSpec.builder("convert")
        .addParameter("interop", ClassName("webgpu", dictionary.name))
        .addParameter("native", ClassName("webgpu", "W${dictionary.name}"))
        .contextReceivers(Arena::class.asTypeName())
        .addModifiers(KModifier.INTERNAL)
        .addAnnotation(JvmStatic::class)
        .addCode("TODO()")
    obj.addFunction(func.build())
    type.addType(obj.build())
}


context(GenerateContext)
private fun genConstructor(dictionary: Dictionary, type: TypeSpec.Builder) {
    val constructor = FunSpec.constructorBuilder()

    genParameters(dictionary, constructor)

    type.primaryConstructor(constructor.build())
}

context(GenerateContext)
private fun genParameters(dictionary: Dictionary, type: FunSpec.Builder) {
    val inherit = dictionary.inherits?.let {
        idl.roots[it] as? Dictionary ?: error("Parent $it not found")
    }

    if (inherit != null) {
        genParameters(inherit, type)
    }

    dictionary.members.forEach { member ->
        type.addParameter(genParameter(member))
    }
}


context(GenerateContext)
private fun genParameter(member: DictionaryMember): ParameterSpec {
    val param = ParameterSpec.builder(member.name, member.type.toKtType().copy(nullable = member.isNullable))

    val defaultValue = member.default
    if (defaultValue != null) {
        val actualType = member.type.actualType()
        when (val mType = actualType.type) {
            is IdentifierType, is ParameterizedType -> {
                when (defaultValue) {
                    ArrayLiteral -> {
                        param.defaultValue("mutableList()")
                    }

                    ObjectLiteral -> {
                        if (mType is IdentifierType) {
                            param.defaultValue("%T()", ClassName("webgpu", mType.name))
                        } else if (mType is ParameterizedType) {
                            val base = mType.base.name
                            if (base == "record") {
                                param.defaultValue("mutableMapOf()")
                            } else {
                                error("Unsupported default value for parameterized type")
                            }
                        }


                    }

                    is StringLiteral -> {
                        require(actualType.isEnum()) { actualType }
                        val enumType = actualType.type as? IdentifierType ?: error("Expected IdentifierType")
                        param.defaultValue(
                            "%T.%L",
                            ClassName("webgpu", enumType.name),
                            defaultValue.value.hyphenToCamelCase()
                        )
                    }

                    else -> error("Unsupported default value for $defaultValue")
                }
            }

            is PrimitiveType -> {
                when (defaultValue) {


                    is BooleanLiteral -> {
                        param.defaultValue("%L", defaultValue.value)
                    }

                    is NumberLiteral -> {
                        param.defaultValue("%L", defaultValue.value)
                    }

                    is StringLiteral -> {
                        param.defaultValue("%S", defaultValue.value)
                    }

                    else -> error("Unsupported default value for primitive type")
                }
            }
        }
    }

    if (!member.required && member.default == null) {
        genInitializer(member, param)
    }

    return param.build()
}

context(GenerateContext)
private fun genInitializer(member: DictionaryMember, parameterSpec: ParameterSpec.Builder) {
    require(!member.required && member.default == null) { member }
    val type = member.type.actualType()

    when (val memberType = type.type) {
        is IdentifierType -> {
            if (type.isEnum()) {
                val enumType = memberType.name
                parameterSpec.defaultValue("%T.Undefined", ClassName("webgpu", enumType))
            } else {
                parameterSpec.defaultValue("null")
            }
        }

        is ParameterizedType -> parameterSpec.defaultValue("null")
        is PrimitiveType -> parameterSpec.defaultValue("0.0")
    }

}

context(GenerateContext)
private fun genMembers(
    dictionary: Dictionary,
    type: TypeSpec.Builder,
    override: Boolean = false,
    noParent: Boolean = false
) {
    val inherit = dictionary.inherits?.let {
        idl.roots[it] as? Dictionary ?: error("Parent $it not found")
    }



    if (inherit != null) {
        genMembers(inherit, type, true, noParent)
    }

    dictionary.members.forEach { member ->
        type.addProperty(genMember(member, override, noParent))
    }
}

context(GenerateContext)
val DictionaryMember.isNullable: Boolean
    get() = when {
        type.nullable -> true // explicitly nullable
        required -> false
        !required && default != null -> false
        !required && default == null -> !type.isEnum() && !type.actualType().isPrimitiveNumber()
        else -> !type.actualType().isPrimitiveNumber()
    }

context(GenerateContext)
private fun genMember(member: DictionaryMember, override: Boolean, noParent: Boolean): PropertySpec {


    println()

    val memberType = member.type.toKtType().copy(nullable = member.isNullable)

    val prop = PropertySpec.builder(member.name, memberType)

    if (noParent && override) {
        prop.addModifiers(KModifier.OVERRIDE)
    }

    if (noParent) {
        prop.initializer(member.name)
    }


    return prop.build()
}