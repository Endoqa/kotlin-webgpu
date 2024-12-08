package webgpu.gen.c

import c.lang.*
import webgpu.schema.*

fun Type.toCType(): CType = when (this) {
    is CallbackType -> {
        ScopedIdentifier(IdentifierKind.struct, Identifier("WGPU${Name(name).pascalCase}CallbackInfo"))
    }

    is ComplexType -> {

        when (this.namespace) {


            TypeNamespace.Enum -> ScopedIdentifier(IdentifierKind.enum, Identifier("WGPU${Name(name).pascalCase}"))
            TypeNamespace.Bitflag -> CPrimitiveType(null, listOf(TypeModifier.Unsigned, TypeModifier.Long))
            TypeNamespace.Struct -> ScopedIdentifier(IdentifierKind.struct, Identifier("WGPU${Name(name).pascalCase}"))


            TypeNamespace.Object -> Identifier("WGPU${Name(name).pascalCase}")

            TypeNamespace.Typedef -> TODO()
            TypeNamespace.FunctionType -> TODO()
        }

    }

    is PrimitiveType -> when (this) {
        PrimitiveType.CVoid -> CPrimitiveType(CBasicType.Void)
        PrimitiveType.Bool -> WGPUBool

        PrimitiveType.NullableString,
        PrimitiveType.StringWithDefaultEmpty,
        PrimitiveType.OutString -> WGPUStringView

        PrimitiveType.UInt16 -> CPrimitiveType(null, listOf(TypeModifier.Unsigned, TypeModifier.Short))
        PrimitiveType.UInt32 -> CPrimitiveType(CBasicType.Int, listOf(TypeModifier.Unsigned))
        PrimitiveType.UInt64 -> CPrimitiveType(null, listOf(TypeModifier.Unsigned, TypeModifier.Long))
        PrimitiveType.USize -> CPrimitiveType(null, listOf(TypeModifier.Unsigned, TypeModifier.Long))
        PrimitiveType.Int16 -> CPrimitiveType(null, listOf(TypeModifier.Short))
        PrimitiveType.Int32 -> CPrimitiveType(CBasicType.Int)
        PrimitiveType.Float32 -> CPrimitiveType(CBasicType.Float)
        PrimitiveType.Float64 -> CPrimitiveType(CBasicType.Double)

        PrimitiveType.ArrayBool -> CArrayType(PrimitiveType.Bool.toCType())
        PrimitiveType.ArrayString -> CArrayType(WGPUStringView)

        PrimitiveType.ArrayUInt16 -> CArrayType(PrimitiveType.UInt16.toCType())
        PrimitiveType.ArrayUInt32 -> CArrayType(PrimitiveType.UInt32.toCType())
        PrimitiveType.ArrayUInt64 -> CArrayType(PrimitiveType.UInt64.toCType())
        PrimitiveType.ArrayUSize -> CArrayType(PrimitiveType.USize.toCType())
        PrimitiveType.ArrayInt16 -> CArrayType(PrimitiveType.Int16.toCType())
        PrimitiveType.ArrayInt32 -> CArrayType(PrimitiveType.Int32.toCType())
        PrimitiveType.ArrayFloat32 -> CArrayType(PrimitiveType.Float32.toCType())
        PrimitiveType.ArrayFloat64 -> CArrayType(PrimitiveType.Float64.toCType())
    }
}