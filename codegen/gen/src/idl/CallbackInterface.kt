package idl

/**
 * Represents a Web IDL callback interface.
 */
data class CallbackInterface(
    val name: String,
    val attributes: MutableList<Attribute> = mutableListOf(),
    val operations: MutableList<Operation> = mutableListOf(),
    val constants: MutableList<Constant> = mutableListOf()
)