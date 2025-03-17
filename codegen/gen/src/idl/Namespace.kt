package idl

/**
 * Represents a Web IDL namespace.
 */
data class Namespace(
    val name: String,
    val attributes: MutableList<Attribute> = mutableListOf(),
    val operations: MutableList<Operation> = mutableListOf(),
    val constants: MutableList<Constant> = mutableListOf(),
    val isPartial: Boolean = false
)