package idl

class Interface(
    val isMixin: Boolean,
    val name: String,
    val setlike: BaseType?,
    val members: MutableList<InterfaceMember>,
    val includes: MutableList<String>,
) : Decl {
}


sealed interface InterfaceMember

class InterfaceField(
    val name: String,
    val type: Type,
    val readonly: Boolean,
    val initializer: Any?,
) : InterfaceMember

class OpParameter(
    val name: String,
    val type: Type,
    val optional: Boolean,
    val initializer: Any?
)

class InterfaceOp(
    val name: String,
    val returnType: Type,
    val parameters: List<OpParameter>,
) : InterfaceMember