package wgpu.schema


import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.asTypeName
import webgpu.schema.*

private const val WGPU_LIB_PACKAGE = "lib.wgpu"

fun Type.toKotlinType(): TypeName = when (this) {
    is CallbackType -> {
        ClassName(WGPU_LIB_PACKAGE, "WGPU${Name(name).pascalCase}CallbackInfo")
    }

    is ComplexType -> {

        when (this.namespace) {


            TypeNamespace.Enum -> ClassName(WGPU_LIB_PACKAGE, "WGPU${Name(name).pascalCase}")
            TypeNamespace.Bitflag -> ULong::class.asTypeName()
            TypeNamespace.Struct -> ClassName(WGPU_LIB_PACKAGE, "WGPU${Name(name).pascalCase}")


            TypeNamespace.Object -> ClassName(WGPU_LIB_PACKAGE, "WGPU${Name(name).pascalCase}")

            TypeNamespace.Typedef -> TODO()
            TypeNamespace.FunctionType -> TODO()
        }

    }

    is PrimitiveType -> when (this) {
        PrimitiveType.CVoid -> Unit::class.asTypeName()
        PrimitiveType.Bool -> Boolean::class.asTypeName()

        PrimitiveType.NullableString,
        PrimitiveType.StringWithDefaultEmpty,
        PrimitiveType.OutString -> String::class.asTypeName()

        PrimitiveType.UInt16 -> UShort::class.asTypeName()
        PrimitiveType.UInt32 -> UInt::class.asTypeName()
        PrimitiveType.UInt64 -> ULong::class.asTypeName()
        PrimitiveType.USize -> ULong::class.asTypeName()
        PrimitiveType.Int16 -> Short::class.asTypeName()
        PrimitiveType.Int32 -> Int::class.asTypeName()

        PrimitiveType.Float32,
        PrimitiveType.NullableFloat32 -> Float::class.asTypeName()

        PrimitiveType.Float64,
        PrimitiveType.Float64SuperType -> Double::class.asTypeName()

        PrimitiveType.ArrayBool -> Array::class.asTypeName().parameterizedBy(Boolean::class.asTypeName())
        PrimitiveType.ArrayString -> Array::class.asTypeName().parameterizedBy(String::class.asTypeName())

        PrimitiveType.ArrayUInt16 -> Array::class.asTypeName().parameterizedBy(UShort::class.asTypeName())
        PrimitiveType.ArrayUInt32 -> Array::class.asTypeName().parameterizedBy(UInt::class.asTypeName())
        PrimitiveType.ArrayUInt64 -> Array::class.asTypeName().parameterizedBy(ULong::class.asTypeName())
        PrimitiveType.ArrayUSize -> Array::class.asTypeName().parameterizedBy(ULong::class.asTypeName())
        PrimitiveType.ArrayInt16 -> Array::class.asTypeName().parameterizedBy(Short::class.asTypeName())
        PrimitiveType.ArrayInt32 -> Array::class.asTypeName().parameterizedBy(Int::class.asTypeName())
        PrimitiveType.ArrayFloat32 -> Array::class.asTypeName().parameterizedBy(Float::class.asTypeName())
        PrimitiveType.ArrayFloat64 -> Array::class.asTypeName().parameterizedBy(Double::class.asTypeName())
    }
}