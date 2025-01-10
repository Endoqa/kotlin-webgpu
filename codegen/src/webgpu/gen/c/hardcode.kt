package webgpu.gen.c

import c.lang.*

internal fun wgpuStringViewStruct(): CStruct {
    val struct = CStruct(
        Identifier("WGPUStringView"),
        listOf(
            CField(
                Identifier("data"),
                CPointer(CPrimitiveType(CBasicType.Char))
            ),
            CField(
                Identifier("length"),
                CPrimitiveType(CBasicType.Int, listOf(TypeModifier.Long, TypeModifier.Unsigned))
            )
        )
    )

    return struct
}

internal fun wgpuChainedStructStruct(): CStruct {
    val struct = CStruct(
        Identifier("WGPUChainedStruct"),
        listOf(
            CField(
                Identifier("next"),
                CPointer(ScopedIdentifier(IdentifierKind.struct, Identifier("WGPUChainedStruct")))
            ),
            CField(
                Identifier("sType"),
                ScopedIdentifier(IdentifierKind.enum, Identifier("WGPUSType"))
            ),
        )
    )

    return struct
}