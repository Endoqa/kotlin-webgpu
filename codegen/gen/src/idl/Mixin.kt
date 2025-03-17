package idl

/**
 * Represents a Web IDL mixin.
 */
data class Mixin(
    val name: String,
    val attributes: MutableList<Attribute> = mutableListOf(),
    val operations: MutableList<Operation> = mutableListOf(),
    val constants: MutableList<Constant> = mutableListOf(),
    val maplikes: MutableList<Maplike> = mutableListOf(),
    val setlikes: MutableList<Setlike> = mutableListOf(),
    val stringifiers: MutableList<Stringifier> = mutableListOf()
)
