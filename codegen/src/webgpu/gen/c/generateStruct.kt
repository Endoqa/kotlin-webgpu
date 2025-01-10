package webgpu.gen.c

import c.lang.CBasicType
import c.lang.CField
import c.lang.CFunction
import c.lang.CFunctionParam
import c.lang.CPointer
import c.lang.CPrimitiveType
import c.lang.CStruct
import c.lang.Identifier
import c.lang.IdentifierKind
import c.lang.ScopedIdentifier
import webgpu.gen.transformDoc
import webgpu.schema.Struct
import webgpu.schema.StructType

data class GeneratedStruct(
    val cStruct: CStruct,
    val freeFunction: Pair<Identifier, CFunction>? = null,
)

fun generateStruct(struct: Struct): GeneratedStruct {

    val identifier = Identifier("WGPU${struct.name.pascalCase}")

    val fields = mutableListOf<CField>()


    val baseField = when (struct.type) {
        StructType.Extensible,
        StructType.ExtensibleCallbackArg -> CField(Identifier("nextInChain"), CPointer(WGPUChainedStruct))


        StructType.Extension -> CField(Identifier("chain"), WGPUChainedStruct)

        StructType.Standalone -> null
    }

    baseField?.let { fields += it }



    fields += (struct.members ?: emptyList())
        .map { Member(it.name, it.type, it.pointer != null, it.doc) }
        .let { generateCMembers(it) }
        .map { CField(it.identifier, it.type, transformDoc(it.doc)) }

    val freeMembers = if (struct.freeMembers == true) {
        val func = CFunction(
            listOf(
                CFunctionParam(
                    Identifier(struct.name.camelCase),
                    ScopedIdentifier(IdentifierKind.struct, identifier)
                )
            ),
            CPrimitiveType(CBasicType.Void)
        )

        Identifier("wgpu${struct.name.pascalCase}FreeMembers") to func
    } else {
        null
    }


    return GeneratedStruct(
        CStruct(identifier, fields, transformDoc(struct.doc)),
        freeMembers
    )

}