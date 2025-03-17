package idl

/**
 * Represents a Web IDL document.
 */
class IDL {
    val interfaces = mutableListOf<Interface>()
    val mixins = mutableListOf<Mixin>()
    val dictionaries = mutableListOf<Dictionary>()
    val enums = mutableListOf<Enum>()
    val typedefs = mutableListOf<Typedef>()
    val includes = mutableListOf<Include>()
    val callbackInterfaces = mutableListOf<CallbackInterface>()
    val namespaces = mutableListOf<Namespace>()

    override fun toString(): String {
        return "IDL(interfaces=$interfaces, mixins=$mixins, dictionaries=$dictionaries, enums=$enums, typedefs=$typedefs, includes=$includes, callbackInterfaces=$callbackInterfaces, namespaces=$namespaces)"
    }
}

/**
 * Represents a Web IDL interface.
 */
data class Interface(
    val name: String,
    val attributes: MutableList<Attribute> = mutableListOf(),
    val operations: MutableList<Operation> = mutableListOf(),
    val constants: MutableList<Constant> = mutableListOf(),
    val constructors: MutableList<Constructor> = mutableListOf(),
    val maplikes: MutableList<Maplike> = mutableListOf(),
    val setlikes: MutableList<Setlike> = mutableListOf(),
    val stringifiers: MutableList<Stringifier> = mutableListOf(),
    val iterables: MutableList<Iterable> = mutableListOf(),
    val asyncIterables: MutableList<AsyncIterable> = mutableListOf(),
    val isPartial: Boolean = false
)

/**
 * Represents a Web IDL attribute.
 */
data class Attribute(
    val name: String,
    val type: Type,
    val isReadOnly: Boolean = false,
    val isStatic: Boolean = false,
    val isInherit: Boolean = false
)

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
)

/**
 * Represents a Web IDL parameter.
 */
data class Parameter(
    val name: String,
    val type: Type,
    val isOptional: Boolean = false,
    val defaultValue: Any? = null
)

/**
 * Represents a Web IDL constant.
 */
data class Constant(
    val name: String,
    val type: Type,
    val value: Any
)

/**
 * Represents a Web IDL constructor.
 */
data class Constructor(
    val parameters: List<Parameter> = emptyList()
)


/**
 * Represents a Web IDL dictionary.
 */
data class Dictionary(
    val name: String,
    val members: MutableList<DictionaryMember> = mutableListOf(),
    val isPartial: Boolean = false,
    val inherits: String? = null
)

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
)

/**
 * Represents a Web IDL typedef.
 */
data class Typedef(
    val name: String,
    val type: Type
)

/**
 * Represents a Web IDL includes statement.
 */
data class Include(
    val interfaceName: String,
    val mixinName: String
)

/**
 * Represents a Web IDL maplike declaration.
 */
data class Maplike(
    val keyType: Type,
    val valueType: Type,
    val isReadOnly: Boolean = false
)

/**
 * Represents a Web IDL setlike declaration.
 */
data class Setlike(
    val valueType: Type,
    val isReadOnly: Boolean = false
)

/**
 * Represents a Web IDL stringifier declaration.
 */
data class Stringifier(
    val attribute: Attribute? = null
)

/**
 * Represents a Web IDL iterable declaration.
 */
data class Iterable(
    val keyType: Type,
    val valueType: Type? = null
)

/**
 * Represents a Web IDL async iterable declaration.
 */
data class AsyncIterable(
    val keyType: Type,
    val valueType: Type? = null,
    val parameters: List<Parameter> = emptyList()
)
