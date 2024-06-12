package idl

sealed interface BaseType

data class IdentifierType(
    val name: String,
) : BaseType


data class PrimitiveType(
    val representation: String,
) : BaseType

// simple idl only got 1
data class ParameterizedType(
    val base: IdentifierType,
    val parameters: List<Type>,
) : BaseType


data class Type(
    val type: BaseType,
    val nullable: Boolean = false,
)