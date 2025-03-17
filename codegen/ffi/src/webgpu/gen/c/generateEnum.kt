@file:OptIn(ExperimentalStdlibApi::class)

package webgpu.gen.c

import c.lang.ASTNumberValue
import c.lang.CEnum
import c.lang.CEnumarator
import c.lang.Identifier
import webgpu.gen.transformDoc
import webgpu.schema.Enum
import webgpu.schema.Schema

fun generateEnum(schema: Schema, enum: Enum): CEnum {
    val enumerators = (enum.entries ?: emptyList())
        .mapIndexed { index, entry ->


            val value = entry?.value?.value ?: index.toUShort()
            val name = entry?.name?.pascalCase ?: "Null"


            val enumerator = ASTNumberValue.Literal("${schema.enumPrefix}${value.toHexString()}")



            CEnumarator(
                Identifier(name),
                enumerator,
                entry?.doc?.let(::transformDoc)
            )
        }

    val cenum = CEnum(
        Identifier("WGPU${enum.name.pascalCase}"),
        enumerators,
        transformDoc(enum.doc)
    )

    return cenum
}