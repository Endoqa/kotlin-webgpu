package idl

/**
 * Represents a Web IDL callback interface.
 */
data class CallbackInterface(
    val name: String,
    val members: MutableList<InterfaceMember> = mutableListOf()
) : IDLDefinition
