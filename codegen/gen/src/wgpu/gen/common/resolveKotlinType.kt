package wgpu.gen.common

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.asTypeName
import idl.*
import wgpu.gen.WGPU_PACKAGE

fun resolveKotlinType(type: Type): TypeName {
    return when (type) {
        is BufferRelatedType -> TODO()
        is FloatType -> resolveFloatType(type)
        is FrozenArrayType -> TODO()
        is Identifier -> ClassName(WGPU_PACKAGE, type.name)
        is IntegerType -> resolveIntegerType(type)
        is NullableType -> TODO()
        is ObservableArrayType -> TODO()
        is PromiseType -> TODO()
        is RecordType -> TODO()
        is SequenceType -> TODO()
        StringType -> String::class.asTypeName()

        // assume first is a seq, send is dict
        // TODO: add verification for the assumption
        is UnionType -> {
            println(type)
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