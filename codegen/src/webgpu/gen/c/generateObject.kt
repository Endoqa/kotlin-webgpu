package webgpu.gen.c

import c.lang.CBasicType
import c.lang.CFunction
import c.lang.CFunctionParam
import c.lang.CPrimitiveType
import c.lang.CStruct
import c.lang.Identifier
import webgpu.schema.Function
import webgpu.schema.Object

data class GeneratedObject(
    val identifier: Identifier,
    val implIdentifier: Identifier,
    val implType: CStruct,
    val methods: List<Pair<Identifier, CFunction>> = emptyList(),
)

fun generateObject(obj: Object): GeneratedObject {

    val identifier = Identifier("WGPU${obj.name.pascalCase}")

    val implIdentifier = Identifier("WGPU${obj.name.pascalCase}Impl")

    val implStruct = CStruct(implIdentifier, emptyList())

    val methods = mutableListOf<Pair<Identifier, CFunction>>()

    obj.methods?.map { generateObjectMethod(obj, identifier, it) }?.let { methods.addAll(it) }

    methods += Identifier("wgpu${obj.name.pascalCase}AddRef") to CFunction(
        listOf(
            CFunctionParam(Identifier(obj.name.camelCase), identifier),
        ),
        CPrimitiveType(CBasicType.Void),
    )

    methods += Identifier("wgpu${obj.name.pascalCase}Release") to CFunction(
        listOf(
            CFunctionParam(Identifier(obj.name.camelCase), identifier),
        ),
        CPrimitiveType(CBasicType.Void),
    )




    return GeneratedObject(identifier, implIdentifier, implStruct, methods)

}


private fun generateObjectMethod(
    obj: Object,
    objIdentifier: Identifier,
    method: Function
): Pair<Identifier, CFunction> {

    val cFunc = method.toCFunction()

    val args = mutableListOf<CFunctionParam>()

    args += CFunctionParam(Identifier(obj.name.camelCase), objIdentifier)
    args += cFunc.params


    val functionName = Identifier("wgpu${obj.name.pascalCase}${method.name.pascalCase}")


    val finalFunction = cFunc.copy(
        params = args,
    )


    return functionName to finalFunction
}