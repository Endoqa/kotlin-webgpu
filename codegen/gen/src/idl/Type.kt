package idl

sealed interface Type

@JvmInline
value class Identifier(val name: String) : Type

data object StringType : Type

data class PromiseType(val resolveType: Type) : Type

data class UnionType(val memberTypes: List<Type>) : Type

data class BufferRelatedType(val name: String) : Type

data class FrozenArrayType(val elementType: Type) : Type

data class NullableType(val innerType: Type) : Type

data class ObservableArrayType(val elementType: Type) : Type

data class RecordType(val keyType: Type, val valueType: Type) : Type

data class SequenceType(val elementType: Type) : Type

data class FloatType(val name: String, val unrestricted: Boolean = false) : Type

data class IntegerType(val name: String, val unsigned: Boolean = false) : Type
