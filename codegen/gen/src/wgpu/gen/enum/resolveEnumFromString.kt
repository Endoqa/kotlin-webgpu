package wgpu.gen.enum

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.CodeBlock
import idl.Enum
import idl.Identifier
import idl.Type
import wgpu.gen.GenerateContext
import wgpu.gen.common.kebabToPascalCase
import wgpu.gen.common.removeHyphens


context(GenerateContext)
fun resolveEnumFromString(type: Type, value: String): CodeBlock {

    if (type !is Identifier) {
        return CodeBlock.of("%L", value)
    }

    val enum = idl.definitions
        .filterIsInstance<Enum>()
        .find { it.name == type.name }

    enum ?: return CodeBlock.of("%L", value)


    val schemaEnum = schema.enums.firstOrNull { e ->
        "GPU${e.name.pascalCase}" == enum.name
    }


    if (schemaEnum == null) {
        return CodeBlock.of(
            "%T.%L",
            ClassName("wgpu", enum.name),
            kebabToPascalCase(value)
        )
    }

    val trimmed = removeHyphens(value)

    val enumerator = schemaEnum.entries
        ?.filterNotNull()
        ?.firstOrNull { v ->
            v.name.pascalCase.equals(trimmed, ignoreCase = true)
        }

    enumerator ?: error("Unknown enumerator $value for enum ${enum.name}")

    return CodeBlock.of("%T.%N", ClassName("wgpu", "GPU${schemaEnum.name.pascalCase}"), enumerator.name.pascalCase)


}
