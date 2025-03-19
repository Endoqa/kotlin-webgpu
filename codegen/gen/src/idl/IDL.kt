package idl

/**
 * Sealed interface for all IDL definitions.
 */
sealed interface IDLDefinition

/**
 * Represents a Web IDL document.
 */
class IDL {
    val definitions = mutableListOf<IDLDefinition>()

    override fun toString(): String {
        return "IDL(definitions=$definitions)"
    }
}

/**
 * Represents a Web IDL interface.
 */
data class Interface(
    val name: String,
    val members: MutableList<InterfaceMember> = mutableListOf(),
    val isPartial: Boolean = false,
    val superClass: String? = null,
    val extendedAttributes: ExtendedAttributeList = ExtendedAttributeList()
) : IDLDefinition

/**
 * Represents a Web IDL attribute.
 */
data class Attribute(
    val name: String,
    val type: Type,
    val isReadOnly: Boolean = false,
    val isStatic: Boolean = false,
    val isInherit: Boolean = false
) : InterfaceMember

/**
 * Represents a Web IDL operation.
 */
data class Operation(
    val name: String?,
    val returnType: Type,
    val parameters: List<Parameter> = emptyList(),
    val isStatic: Boolean = false,
    val isSpecial: Boolean = false,
    val specialType: String? = null
) : InterfaceMember

/**
 * Represents a Web IDL parameter.
 */
data class Parameter(
    val name: String,
    val type: Type,
    val isOptional: Boolean = false,
    val defaultValue: DefaultValue? = null
)

/**
 * Represents a Web IDL constant.
 */
data class Constant(
    val name: String,
    val type: Type,
    val value: Any
) : InterfaceMember, DefaultValue

/**
 * Represents a Web IDL constructor.
 */
data class Constructor(
    val parameters: List<Parameter> = emptyList()
) : InterfaceMember


/**
 * Represents a Web IDL dictionary.
 */
data class Dictionary(
    val name: String,
    val members: MutableList<DictionaryMember> = mutableListOf(),
    val isPartial: Boolean = false,
    val inherits: String? = null,
    val extendedAttributes: ExtendedAttributeList = ExtendedAttributeList()
) : IDLDefinition

/**
 * Represents a Web IDL dictionary member.
 */
data class DictionaryMember(
    val name: String,
    val type: Type,
    val isRequired: Boolean = false,
    val defaultValue: Any? = null
)

/**
 * Represents a Web IDL enum.
 */
data class Enum(
    val name: String,
    val values: List<String> = emptyList()
) : IDLDefinition

/**
 * Represents a Web IDL typedef.
 */
data class Typedef(
    val name: String,
    val type: Type
) : IDLDefinition

/**
 * Represents a Web IDL includes statement.
 */
data class Include(
    val interfaceName: String,
    val mixinName: String
) : IDLDefinition

/**
 * Represents a Web IDL maplike declaration.
 */
data class Maplike(
    val keyType: Type,
    val valueType: Type,
    val isReadOnly: Boolean = false
) : InterfaceMember

/**
 * Represents a Web IDL setlike declaration.
 */
data class Setlike(
    val valueType: Type,
    val isReadOnly: Boolean = false
) : InterfaceMember

/**
 * Represents a Web IDL stringifier declaration.
 */
data class Stringifier(
    val attribute: Attribute? = null
) : InterfaceMember

/**
 * Represents a Web IDL iterable declaration.
 */
data class Iterable(
    val keyType: Type,
    val valueType: Type? = null
) : InterfaceMember

/**
 * Represents a Web IDL async iterable declaration.
 */
data class AsyncIterable(
    val keyType: Type,
    val valueType: Type? = null,
    val parameters: List<Parameter> = emptyList()
) : InterfaceMember


sealed interface DefaultValue {
    data class StringValue(val value: String) : DefaultValue
    data object Null : DefaultValue
    data object Undefined : DefaultValue
    data object DictInitializer : DefaultValue
    data object ListInitializer : DefaultValue
}