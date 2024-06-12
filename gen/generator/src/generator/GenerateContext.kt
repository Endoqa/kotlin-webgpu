package generator

import idl.*
import idl.Enum

data class GenerateContext(
    val idl: IDL
) {


    //todo: plz plz plz make it better in the future. add a cache or id bitmap or whatever shit
    fun Dictionary.noParentInheritance(): Boolean {
        return idl.roots.values
            .filterIsInstance<Dictionary>()
            .none { it.inherits == this.name }
    }

    fun Type.isEnum(): Boolean {

        return when (val type = this.type) {
            is IdentifierType -> isEnum(type.name)
            else -> false
        }
    }

    private fun isEnum(type: String): Boolean {
        val t = idl.roots[type] ?: return false

        return t is Enum
    }

}

context(GenerateContext)
fun Type.actualType(): Type {
    // unwrap typedef
    return when (val type = type) {
        is IdentifierType -> {
            val typedef = idl.roots[type.name]
            if (typedef is TypeDef) {
                typedef.type.actualType()
            } else {
                this
            }
        }

        else -> this
    }
}

context(GenerateContext)
fun Type.isPrimitiveNumber(): Boolean {
    return when (val type = actualType().type) {
        is PrimitiveType -> type.representation != "DOMString" && type.representation != "USVString"
        is IdentifierType -> {
            val typedef = idl.roots[type.name]
            if (typedef is TypeDef) {
                typedef.type.isPrimitiveNumber()
            } else {
                false
            }
        }

        else -> false
    }
}