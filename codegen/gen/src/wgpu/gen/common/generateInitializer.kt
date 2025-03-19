package wgpu.gen.common

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.CodeBlock
import idl.*
import wgpu.gen.GenerateContext
import wgpu.gen.WGPU_PACKAGE
import wgpu.gen.enum.resolveEnumFromString

context(GenerateContext)
fun generateInitializer(initializer: DefaultValue, type: Type): CodeBlock {
    return when (initializer) {
        is Constant -> TODO()
        DefaultValue.DictInitializer -> {
            when (type) {
                is Identifier -> CodeBlock.of("%T()", ClassName(WGPU_PACKAGE, type.name))
                is RecordType -> CodeBlock.of("hashMapOf()")
                else -> error("Unsupported default value type: $type")
            }
        }

        DefaultValue.ListInitializer -> CodeBlock.of("listOf()")
        DefaultValue.Null -> TODO()
        is DefaultValue.StringValue -> {
            if (isTypeEnum(type)) {
                resolveEnumFromString(type, initializer.value)
            } else {
                CodeBlock.of("%S", initializer.value)
            }
        }

        DefaultValue.Undefined -> TODO()
        is DefaultValue.PreGenerated -> initializer.cb
        is DefaultValue.BooleanValue -> CodeBlock.of("%L", initializer.value)
        is DefaultValue.FloatValue, is DefaultValue.IntegerValue -> {

            val t = resolveType(type)
            val raw = when (initializer) {
                is DefaultValue.FloatValue -> initializer.raw
                is DefaultValue.IntegerValue -> initializer.raw
                else -> error("Unknown default value type: $initializer")
            }


            val typeName = when (t) {
                is FloatType -> t.name
                is IntegerType -> t.name
                else -> error("Unknown default value type: $initializer")
            }

            val unsigned = when (t) {
                is IntegerType -> t.unsigned
                else -> false
            }

            val template = when (typeName) {
                "float" -> "%Lf"
                "double" -> "%L"
                "short", "long" -> if (unsigned) "%LU" else "%L"
                "long long" -> if (unsigned) "%LUL" else "%LL"
                else -> error("Unknown float type: $type")
            }
            CodeBlock.of(template, raw)


        }
    }
}
