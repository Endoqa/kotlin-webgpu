package wgpu.gen.enum

import com.squareup.kotlinpoet.*
import webgpu.schema.Enum
import wgpu.gen.GenerateContext
import wgpu.gen.WGPU_PACKAGE
import wgpu.gen.common.kebabToPascalCase


context(GenerateContext)
fun generateEnum(enum: idl.Enum, isActual: Boolean = false): FileSpec.Builder {
    val file = FileSpec.builder(WGPU_PACKAGE, if (isActual) "${enum.name}.jvm" else enum.name)

    val schemaEnum = schema.enums.firstOrNull { e ->
        "GPU${e.name.pascalCase}" == enum.name
    }

    val spec = if (schemaEnum != null) {
        interopGen(enum, file, schemaEnum, isActual)
    } else {
        println("Missing schema enum: ${enum.name}, prefer idl")
        idlGen(enum)
    }

    file.addType(spec.build())
    return file
}

context(GenerateContext)
private fun interopGen(
    enum: idl.Enum,
    fileSpec: FileSpec.Builder,
    schemaEnum: Enum,
    isActual: Boolean
): TypeSpec.Builder {
    val specClass = ClassName(WGPU_PACKAGE, enum.name)
    val interopClass = ClassName(WGPU_PACKAGE, "${enum.name}Interop")

    val interopSpec =
        TypeAliasSpec.builder("${enum.name}Interop", ClassName("lib.wgpu", "WGPU${schemaEnum.name.pascalCase}"))


    val spec = TypeSpec.enumBuilder(enum.name)

    if (isActual) {
        spec.addModifiers(KModifier.ACTUAL)
    } else {
        spec.addModifiers(KModifier.EXPECT)
    }

    if (isActual) {

        fileSpec.addTypeAlias(interopSpec.build())

        spec
            .addProperty(
                PropertySpec
                    .builder(
                        "interop",
//                    ClassName("lib.wgpu", "WGPU${schemaEnum.name.pascalCase}"), // this is for ffi
                        interopClass
                    )
                    .initializer("interop")
                    .addModifiers(KModifier.INTERNAL)
                    .build()
            )
            .primaryConstructor(
                FunSpec.constructorBuilder()
                    .addParameter(
                        "interop",
//                    ClassName("lib.wgpu", "WGPU${schemaEnum.name.pascalCase}") // this is for ffi
                        interopClass
                    )
                    .build()
            )
    }

    if (isActual) {
        spec.addFunction(
            FunSpec.builder("into")
                .addParameter("out", interopClass)
                .returns(interopClass)
                .addCode("return interop")
                .build()
        )
    }





    (schemaEnum.entries ?: emptyList())
        .filterNotNull()
        .filter { it.name.pascalCase != "Undefined" || it.name.pascalCase == "Null" }
        .forEach { entry ->

            if (isActual) {
                spec.addEnumConstant(
                    entry.name.pascalCase,
                    TypeSpec.anonymousClassBuilder()
                        .addSuperclassConstructorParameter(
                            "%T.%N",
//                        ClassName("lib.wgpu", "WGPU${schemaEnum.name.pascalCase}"), // this is for ffi
                            interopClass,
                            entry.name.pascalCase
                        )
                        .build()
                )
            } else {
                spec.addEnumConstant(
                    entry.name.pascalCase,
                )
            }


        }

//    spec.addType(interopSpec.build())

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