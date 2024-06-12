package idl

sealed interface Decl


data class TypeDef(val name: String, val type: Type) : Decl