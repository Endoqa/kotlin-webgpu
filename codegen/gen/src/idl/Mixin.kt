package idl

/**
 * Represents a Web IDL mixin.
 */
data class Mixin(
    val name: String,
    val members: MutableList<InterfaceMember> = mutableListOf()
) : IDLDefinition
