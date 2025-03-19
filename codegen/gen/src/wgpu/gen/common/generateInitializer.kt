package wgpu.gen.common

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.CodeBlock
import idl.Constant
import idl.DefaultValue
import idl.Identifier
import idl.Type
import wgpu.gen.WGPU_PACKAGE

fun generateInitializer(initializer: DefaultValue, type: Type): CodeBlock {
    return when (initializer) {
        is Constant -> TODO()
        DefaultValue.DictInitializer -> {
            require(type is Identifier)
            CodeBlock.of("%T()", ClassName(WGPU_PACKAGE, type.name))
        }

        DefaultValue.ListInitializer -> CodeBlock.of("listOf()")
        DefaultValue.Null -> TODO()
        is DefaultValue.StringValue -> CodeBlock.of("%S", initializer.value)
        DefaultValue.Undefined -> TODO()
    }
}