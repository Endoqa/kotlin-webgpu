package webgpu.gen.c

import c.lang.CField
import c.lang.CPointer
import c.lang.CStruct
import c.lang.Identifier
import webgpu.schema.Struct
import webgpu.schema.StructType


fun generateStruct(struct: Struct): CStruct {

    val identifier = Identifier("WGPU${struct.name.pascalCase}")

    val fields = mutableListOf<CField>()


    val baseField = when (struct.type) {
        StructType.BaseIn -> CField(Identifier("nextInChain"), CPointer(WGPUChainedStruct))

        StructType.BaseOut -> CField(Identifier("nextInChain"), CPointer(WGPUChainedStructOut))

        StructType.BaseInOrOut -> CField(Identifier("nextInChain"), CPointer(WGPUChainedStructOut))

        StructType.ExtensionIn -> CField(Identifier("chain"), WGPUChainedStruct)

        StructType.ExtensionOut -> CField(Identifier("chain"), WGPUChainedStructOut)

        StructType.ExtensionInOrOut -> CField(Identifier("chain"), WGPUChainedStructOut)

        StructType.Standalone -> null
    }

    baseField?.let { fields += it }



    fields += (struct.members ?: emptyList())
        .map { Member(it.name, it.type, it.pointer != null, it.doc) }
        .let { generateCMembers(it) }
        .map { CField(it.identifier, it.type, it.doc) }


    return CStruct(identifier, fields, struct.doc)

}