package wgpu.gen.common

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.asTypeName
import idl.*
import wgpu.gen.WGPU_PACKAGE
import java.lang.foreign.MemorySegment

fun resolveKotlinType(type: Type): TypeName {
    return when (type) {
        is BufferRelatedType -> MemorySegment::class.asTypeName()
        is FloatType -> resolveFloatType(type)
        is FrozenArrayType -> TODO()
        is Identifier -> ClassName(WGPU_PACKAGE, type.name)
        is IntegerType -> resolveIntegerType(type)
        is NullableType -> resolveKotlinType(type.innerType).copy(nullable = true)
        is ObservableArrayType -> TODO()
        is PromiseType -> TODO()
        is RecordType -> TODO()
        is SequenceType -> List::class.asTypeName().parameterizedBy(resolveKotlinType(type.elementType))
        StringType -> String::class.asTypeName()

        // assume first is a seq, send is dict
        // TODO: add verification for the assumption
        is UnionType -> {
            resolveKotlinType(type.memberTypes[1])
        }
    }
}


fun resolveIntegerType(type: IntegerType): TypeName {
    val baseType = when (type.name) {
        "long" -> Int::class.asTypeName()
        "long long" -> Long::class.asTypeName()
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