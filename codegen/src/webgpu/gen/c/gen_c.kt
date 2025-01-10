package webgpu.gen.c

import c.lang.CBasicType
import c.lang.CEnum
import c.lang.CField
import c.lang.CPointer
import c.lang.CPrimitiveType
import c.lang.CStruct
import c.lang.CType
import c.lang.CUnion
import c.lang.Identifier
import c.lang.IdentifierKind
import c.lang.ScopedIdentifier
import c.lang.TypeModifier
import webgpu.gen.generateBitflag
import webgpu.schema.Schema


val WGPUFlags = Identifier("WGPUFlags")
val WGPUBool = Identifier("WGPUBool")
val WGPUStringView = Identifier("WGPUStringView")

val WGPUChainedStruct = Identifier("WGPUChainedStruct")


class GenerateCContext {
    val globals = mutableMapOf<Identifier, CType>()
    val enums = mutableMapOf<Identifier, CEnum>()
    val structs = mutableMapOf<Identifier, CStruct>()
//    val unions = mutableMapOf<Identifier, CUnion>()
}


context(GenerateCContext)
fun generate(schema: Schema) {
    // hardcoded typedefs

    globals[WGPUFlags] = CPrimitiveType(null, listOf(TypeModifier.Unsigned, TypeModifier.Long))
    globals[WGPUBool] = CPrimitiveType(CBasicType.Int, listOf(TypeModifier.Unsigned))

    structs[WGPUStringView] = wgpuStringViewStruct()
    structs[WGPUChainedStruct] = wgpuChainedStructStruct()

    globals[WGPUStringView] = ScopedIdentifier(IdentifierKind.struct, WGPUStringView)
    globals[WGPUChainedStruct] = ScopedIdentifier(IdentifierKind.struct, WGPUChainedStruct)



    schema.enums.forEach {
        val enum = generateEnum(schema, it)
        enums[enum.id!!] = enum
    }

    schema.functions.forEach {
        val (id, func) = generateFunction(it)
        globals[id] = func
    }

    schema.structs.forEach {
        val (struct, freeFunc) = generateStruct(it)
        structs[struct.id!!] = struct

        if (freeFunc != null) {
            val (id, func) = freeFunc
            globals[id] = func
        }
    }

    schema.objects.forEach {
        val (id, implId, implStruct, methods) = generateObject(it)
        structs[implId] = implStruct
        globals[id] = CPointer(ScopedIdentifier(IdentifierKind.struct, implId), it.doc)

        methods.forEach { (id, func) -> globals[id] = func }
    }

    schema.callbacks.forEach {
        val (id, func, infoId, infoStruct) = generateCallback(it)

        structs[infoId] = infoStruct
        globals[id] = CPointer(func)
    }
}