package wgpu.gen.dict

import com.squareup.kotlinpoet.*
import idl.Dictionary
import idl.DictionaryMember
import idl.IDL
import wgpu.gen.GenerateContext
import wgpu.gen.WGPU_PACKAGE
import wgpu.gen.common.generateInitializer
import wgpu.gen.common.resolveKotlinType
import wgpu.gen.typedef.getUnionSuperclasses

context(GenerateContext)
fun generateDict(dict: Dictionary, idl: IDL): FileSpec.Builder {
    val className = ClassName(WGPU_PACKAGE, dict.name)
    val file = FileSpec.builder(className)

    val haveInheritChildren = hasChildInheritance(idl, dict)

    val spec = TypeSpec.classBuilder(className)

    spec.addSuperinterfaces(getUnionSuperclasses(dict.name))

    if (haveInheritChildren) {
        spec.addModifiers(KModifier.ABSTRACT)
    } else {
        spec.addModifiers(KModifier.DATA)
    }

    if (dict.inherits != null) {
        spec.superclass(ClassName(WGPU_PACKAGE, dict.inherits))
        val parent = getParent(idl, dict)
        parent ?: error("Missing parent dictionary: ${dict.inherits}")
        addSuperclassConstructorParams(spec, parent)
    }
    val constructor = FunSpec.constructorBuilder()


    handleInheritance(idl, dict, spec, constructor)
    addMembers(spec, constructor, dict.members, open = haveInheritChildren)




    spec.primaryConstructor(constructor.build())
    file.addType(spec.build())
    return file
}

context(GenerateContext)
private fun getParent(idl: IDL, dict: Dictionary): Dictionary? {
    if (dict.inherits == null) {
        return null
    }

    return idl.definitions.filterIsInstance<Dictionary>().find { it.name == dict.inherits }
}

context(GenerateContext)
private fun addSuperclassConstructorParams(spec: TypeSpec.Builder, parent: Dictionary) {
    parent.members.forEach { member ->
        spec.addSuperclassConstructorParameter("%N = %N", member.name, member.name)
    }
}

context(GenerateContext)
private fun handleInheritance(
    idl: IDL,
    dict: Dictionary,
    spec: TypeSpec.Builder,
    constructor: FunSpec.Builder
) {
    if (dict.inherits == null) {
        return
    }

    val parent = idl.definitions.filterIsInstance<Dictionary>().find { it.name == dict.inherits }
    parent ?: error("Missing parent dictionary: ${dict.inherits}")
    handleInheritance(idl, parent, spec, constructor)
    addMembers(
        spec,
        constructor,
        parent.members,
        override = true,
    )
}

context(GenerateContext)
private fun addMembers(
    spec: TypeSpec.Builder,
    constructor: FunSpec.Builder,
    members: List<DictionaryMember>,
    override: Boolean = false,
    open: Boolean = false,
) {
    for (member in members) {
        var type = resolveKotlinType(member.type)
        if (!member.isRequired && member.defaultValue == null) {
            type = type.copy(nullable = true)
        }


        val property = PropertySpec.builder(member.name, type)
        property.initializer(member.name)
        property.mutable(true)

        if (override) {
            property.addModifiers(KModifier.OVERRIDE)
        }

        if (open) {
            property.addModifiers(KModifier.OPEN)
        }


        val parameter = ParameterSpec.builder(member.name, type)


        if (member.defaultValue != null) {
            parameter.defaultValue(generateInitializer(member.defaultValue, member.type))
        }
        if (!member.isRequired && member.defaultValue == null) {
            parameter.defaultValue("null")
        }

        constructor.addParameter(parameter.build())
        spec.addProperty(property.build())
    }
}