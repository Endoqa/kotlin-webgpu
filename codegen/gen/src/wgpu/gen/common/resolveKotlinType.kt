package wgpu.gen.common

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.asTypeName
import idl.*
import wgpu.gen.NativeBufferClass
import wgpu.gen.WGPU_PACKAGE

fun resolveKotlinType(type: Type): TypeName {
    return when (type) {
        is BufferRelatedType -> NativeBufferClass
        is FloatType -> resolveFloatType(type)
        is FrozenArrayType -> Array::class.asTypeName().parameterizedBy(resolveKotlinType(type.elementType))
        is Identifier -> ClassName(WGPU_PACKAGE, type.name)
        is IntegerType -> resolveIntegerType(type)
        is NullableType -> resolveKotlinType(type.innerType).copy(nullable = true)
        is ObservableArrayType -> TODO()
        is PromiseType -> resolveKotlinType(type.resolveType)
        is RecordType -> {
            val k = resolveKotlinType(type.keyType)
            val v = resolveKotlinType(type.valueType)
            HashMap::class.asTypeName().parameterizedBy(k, v)
        }

        is SequenceType -> List::class.asTypeName().parameterizedBy(resolveKotlinType(type.elementType))
        StringType -> String::class.asTypeName()

        is UnionType -> {
            error("Union types are not supported, it should be preprocessed")
        }

        UndefinedType -> Unit::class.asTypeName()
        BooleanType -> Boolean::class.asTypeName()
    }
}


fun resolveIntegerType(type: IntegerType): TypeName {
    val baseType = when (type.name) {
        "long" -> Int::class.asTypeName()
        "long long" -> Long::class.asTypeName()
        "short" -> Short::class.asTypeName()
        else -> error("Unknown integer type: $type")
    }

    var ktType = baseType

    if (type.unsigned) { // add U
        ktType = ClassName("kotlin", "U${baseType.simpleName}")
    }

    return ktType

}

fun resolveFloatType(type: FloatType): TypeName {
    return when (type.name) {
        "float" -> Float::class.asTypeName()
        "double" -> Double::class.asTypeName()
        else -> error("Unknown float type: $type")
    }
}