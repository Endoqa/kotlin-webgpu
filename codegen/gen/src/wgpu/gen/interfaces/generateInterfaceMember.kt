package wgpu.gen.interfaces

import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import idl.*
import idl.Iterable
import wgpu.gen.common.resolveKotlinType

fun generateInterfaceMember(typeSpec: TypeSpec.Builder, member: InterfaceMember) {
    when (member) {
        is AsyncIterable -> TODO()
        is Attribute -> {
            typeSpec.addProperty(generateAttribute(member).build())
        }

        is Constant -> TODO()
        is Constructor -> TODO()
        is Iterable -> TODO()
        is Maplike -> TODO()
        is Operation -> {
            typeSpec.addFunction(generateOperation(member).addModifiers(KModifier.ABSTRACT).build())
        }

        is Setlike -> TODO()
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

private fun generateOperation(op: Operation): FunSpec.Builder {
    val func = FunSpec.builder(op.name ?: error("Operation has no name"))


    for (param in op.parameters) {
        func.addParameter(param.name, resolveKotlinType(param.type))
    }
    func.returns(resolveKotlinType(op.returnType))

    if (op.returnType is PromiseType) {
        func.addModifiers(KModifier.SUSPEND)
    }


    return func
}