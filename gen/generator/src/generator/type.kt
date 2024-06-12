package generator

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeName
import idl.IdentifierType
import idl.ParameterizedType
import idl.PrimitiveType
import idl.Type

fun Type.toKtType(): TypeName {
    val t = when (val type = type) {
        is IdentifierType -> ClassName("webgpu", type.name)
        is ParameterizedType -> {
            // if it is sequence<Type>, convert to List<Type>
            when (val baseType = type.base.name) {
                "sequence" -> {
                    val parameter = type.parameters.first().toKtType()
                    ClassName("kotlin.collections", "List").parameterizedBy(parameter)
                }

                "Promise" -> {
                    // return the type of the promise
                    type.parameters.first().toKtType()
                }

                "record" -> {
                    // kotlin map
                    val key = type.parameters[0].toKtType()
                    val value = type.parameters[1].toKtType()
                    ClassName("kotlin.collections", "MutableMap").parameterizedBy(key, value)
                }

                else -> error("Unsupported parameterized type $baseType")
            }

        }

        is PrimitiveType -> type.toKtType()
    }

    if (nullable) {
        return t.copy(nullable = true)
    }


    return t
}

fun Type.isPromise(): Boolean {
    val type = type
    if (type !is ParameterizedType) {
        return false
    }

    return type.base.name == "Promise"
}


fun PrimitiveType.toKtType(): ClassName {
    return when (representation) {
        "undefined" -> ClassName("kotlin", "Unit")
        "boolean" -> ClassName("kotlin", "Boolean")
        "short" -> ClassName("kotlin", "Short")
        "long" -> ClassName("kotlin", "Int")
        "long long" -> ClassName("kotlin", "Long")
        "double" -> ClassName("kotlin", "Double")

        "unsigned short" -> ClassName("kotlin", "UShort")
        "unsigned long" -> ClassName("kotlin", "UInt")
        "unsigned long long" -> ClassName("kotlin", "ULong")

        "float" -> ClassName("kotlin", "Float")

        "DOMString" -> ClassName("kotlin", "String")
        "USVString" -> ClassName("kotlin", "String")


        else -> error("Unsupported primitive type $representation")
    }
}