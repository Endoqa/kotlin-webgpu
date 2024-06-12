package idl

sealed interface Literal

// {}
data object ObjectLiteral : Literal

// []
data object ArrayLiteral : Literal

data class NumberLiteral(val value: String) : Literal

data class StringLiteral(val value: String) : Literal

data class BooleanLiteral(val value: Boolean) : Literal