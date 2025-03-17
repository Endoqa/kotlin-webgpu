package idl

sealed interface Type


@JvmInline
value class Identifier(val name: String) : Type

data object StringType : Type