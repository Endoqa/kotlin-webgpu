package idl

/**
 * Represents a Web IDL namespace.
 */
data class Namespace(
    val name: String,
    val members: MutableList<InterfaceMember> = mutableListOf(),
    val isPartial: Boolean = false
) : IDLDefinition
