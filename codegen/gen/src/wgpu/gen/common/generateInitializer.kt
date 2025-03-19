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
        DefaultValue.DictInitializer -> generateDictInitializer(type)
        DefaultValue.ListInitializer -> CodeBlock.of("listOf()")
        DefaultValue.Null -> TODO()
        is DefaultValue.StringValue -> generateStringInitializer(initializer.value, type)
        DefaultValue.Undefined -> TODO()
        is DefaultValue.PreGenerated -> initializer.cb
        is DefaultValue.BooleanValue -> CodeBlock.of("%L", initializer.value)
        is DefaultValue.FloatValue, is DefaultValue.IntegerValue -> generateNumericInitializer(initializer, type)
    }
}

context(GenerateContext)
private fun generateDictInitializer(type: Type): CodeBlock = when (type) {
    is Identifier -> CodeBlock.of("%T()", ClassName(WGPU_PACKAGE, type.name))
    is RecordType -> CodeBlock.of("hashMapOf()")
    else -> error("Unsupported dictionary type: $type")
}

context(GenerateContext)
private fun generateStringInitializer(value: String, type: Type): CodeBlock =
    if (isTypeEnum(type)) {
        resolveEnumFromString(type, value)
    } else {
        CodeBlock.of("%S", value)
    }

context(GenerateContext)
private fun generateNumericInitializer(initializer: DefaultValue, type: Type): CodeBlock {
    val resolvedType = resolveType(type)
    val rawValue = extractRawValue(initializer)

    return when (resolvedType) {
        is FloatType -> generateFloatInitializer(resolvedType, rawValue)
        is IntegerType -> generateIntegerInitializer(resolvedType, rawValue)
        else -> error("Unsupported numeric type: $resolvedType")
    }
}

private fun extractRawValue(initializer: DefaultValue): String = when (initializer) {
    is DefaultValue.FloatValue -> initializer.raw
    is DefaultValue.IntegerValue -> initializer.raw
    else -> error("Not a numeric value: $initializer")
}

context(GenerateContext)
private fun generateFloatInitializer(type: FloatType, rawValue: String): CodeBlock {
    val template = when (type.name) {
        "float" -> "%Lf"
        "double" -> "%L"
        else -> error("Unsupported float type: ${type.name}")
    }
    return CodeBlock.of(template, rawValue)
}

context(GenerateContext)
private fun generateIntegerInitializer(type: IntegerType, rawValue: String): CodeBlock {
    val template = when (type.name) {
        "short", "long" -> if (type.unsigned) "%LU" else "%L"
        "long long" -> if (type.unsigned) "%LUL" else "%LL"
        else -> error("Unsupported integer type: ${type.name}")
    }
    return CodeBlock.of(template, rawValue)
}
