package wgpu.gen.interfaces

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import idl.*
import idl.Iterable
import wgpu.gen.common.generateInitializer
import wgpu.gen.common.resolveKotlinType

fun generateInterfaceMember(
    typeSpec: TypeSpec.Builder,
    member: InterfaceMember,
    inherit: Boolean,
    inMixin: Boolean = false
) {
    when (member) {
        is AsyncIterable -> TODO()
        is Attribute -> {
            val attribute = generateAttribute(member)
            if (inherit) {
                attribute.addModifiers(KModifier.OVERRIDE)
            }
            typeSpec.addProperty(attribute.build())
        }

        is Constant -> TODO()
        is Constructor -> {
            typeSpec.addFunction(generateConstructor(member).build())
        }

        is Iterable -> TODO()
        is Maplike -> TODO()
        is Operation -> {
            val operation = generateOperation(member)
            if (inherit) {
                operation.addModifiers(KModifier.OVERRIDE)
            }

            if (inMixin) {
                operation.addModifiers(KModifier.ABSTRACT)
            }
            typeSpec.addFunction(operation.build())
        }

        is Setlike -> {
            typeSpec.addSuperinterface(
                Set::class.asTypeName().parameterizedBy(resolveKotlinType(member.valueType))
            )
        }

        is Stringifier -> TODO()
    }
}

private fun generateAttribute(member: Attribute): PropertySpec.Builder {
    val property = PropertySpec
        .builder(member.name, resolveKotlinType(member.type))
        .mutable(true)

    if (member.isReadOnly) {
        property.mutable(false)
    }

    return property
}

private fun generateFunSpec(func: FunSpec.Builder, params: List<Parameter>, returnType: Type): FunSpec.Builder {
    for (param in params) {
        var pType = resolveKotlinType(param.type)

        if (param.isOptional && param.defaultValue == null) {
            pType = pType.copy(nullable = true)
        }

        val p = ParameterSpec.builder(param.name, pType)

        if (param.defaultValue != null) {
            val cb = generateInitializer(param.defaultValue, param.type)
            p.defaultValue(cb)
        }


        func.addParameter(p.build())
    }
    if (returnType != UndefinedType) {
        func.returns(resolveKotlinType(returnType))
    }

    if (returnType is PromiseType) {
        func.addModifiers(KModifier.SUSPEND)
    }

    return func
}

private fun generateOperation(op: Operation): FunSpec.Builder {
    val func = FunSpec.builder(op.name ?: error("Operation has no name"))
    generateFunSpec(func, op.parameters, op.returnType)
    return func
}

private fun generateConstructor(constructor: Constructor): FunSpec.Builder {
    val func = FunSpec.constructorBuilder()

    println(constructor)

    generateFunSpec(func, constructor.parameters, UndefinedType)

    return func
}
