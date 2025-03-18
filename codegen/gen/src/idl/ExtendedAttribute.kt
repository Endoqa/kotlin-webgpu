package idl

/**
 * Represents a Web IDL extended attribute.
 */
sealed class ExtendedAttribute {
    /**
     * Represents a Web IDL extended attribute with no arguments, like `[Exposed]`.
     */
    data class NoArgs(val name: String) : ExtendedAttribute()

    /**
     * Represents a Web IDL extended attribute with an argument list, like `[Constructor(DOMString str)]`.
     */
    data class ArgList(val name: String, val arguments: List<Parameter>) : ExtendedAttribute()

    /**
     * Represents a Web IDL extended attribute with an identifier value, like `[Exposed=Window]`.
     */
    data class Ident(val name: String, val value: String) : ExtendedAttribute()

    /**
     * Represents a Web IDL extended attribute with a list of identifier values, like `[Exposed=(Window,Worker)]`.
     */
    data class IdentList(val name: String, val values: List<String>) : ExtendedAttribute()

    /**
     * Represents a Web IDL extended attribute with a named argument list, like `[NamedConstructor=Audio(DOMString src)]`.
     */
    data class NamedArgList(val name: String, val identifier: String, val arguments: List<Parameter>) : ExtendedAttribute()
}

/**
 * Represents a list of Web IDL extended attributes.
 */
data class ExtendedAttributeList(val attributes: List<ExtendedAttribute> = emptyList())