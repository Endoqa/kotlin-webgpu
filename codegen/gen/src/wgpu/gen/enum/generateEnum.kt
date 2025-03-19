package wgpu.gen.enum

import com.squareup.kotlinpoet.*
import webgpu.schema.Enum
import wgpu.gen.GenerateContext
import wgpu.gen.WGPU_PACKAGE
import wgpu.gen.common.kebabToPascalCase


context(GenerateContext)
fun generateEnum(enum: idl.Enum): FileSpec.Builder {
    val file = FileSpec.builder(WGPU_PACKAGE, enum.name)

    val schemaEnum = schema.enums.firstOrNull { e ->
        "GPU${e.name.pascalCase}" == enum.name
    }

    val spec = if (schemaEnum != null) {
        interopGen(enum, schemaEnum)
    } else {
        println("Missing schema enum: ${enum.name}, prefer idl")
        idlGen(enum)
    }

    file.addType(spec.build())
    return file
}

context(GenerateContext)
private fun interopGen(enum: idl.Enum, schemaEnum: Enum): TypeSpec.Builder {
    val spec = TypeSpec.enumBuilder(enum.name)

    spec
        .addProperty(
            PropertySpec
                .builder(
                    "interop",
                    ClassName("lib.wgpu", "WGPU${schemaEnum.name.pascalCase}")
                )
                .initializer("interop")
                .build()
        )
        .primaryConstructor(
            FunSpec.constructorBuilder()
                .addParameter("interop", ClassName("lib.wgpu", "WGPU${schemaEnum.name.pascalCase}"))
                .build()
        )


    (schemaEnum.entries ?: emptyList())
        .filterNotNull()
        .filter { it.name.pascalCase != "Undefined" || it.name.pascalCase == "Null" }
        .forEach { entry ->
            spec.addEnumConstant(
                entry.name.pascalCase,
                TypeSpec.anonymousClassBuilder()
                    .addSuperclassConstructorParameter(
                        "%T.%N",
                        ClassName("lib.wgpu", "WGPU${schemaEnum.name.pascalCase}"),
                        entry.name.pascalCase
                    )
                    .build()
            )
        }

    return spec
}

context(GenerateContext)
private fun idlGen(enum: idl.Enum): TypeSpec.Builder {
    val spec = TypeSpec.enumBuilder(enum.name)

    enum.values.forEach { name ->
        val transformedName = kebabToPascalCase(name)

        spec.addEnumConstant(transformedName)
    }

    return spec
}