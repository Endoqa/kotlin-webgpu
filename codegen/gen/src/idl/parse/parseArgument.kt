package idl.parse

import idl.Parameter
import tree_sitter.idl.node.ArgumentNode

/**
 * Parses a single ArgumentNode into a Parameter.
 */
context(SourceAvailable)
fun parseArgument(arg: ArgumentNode): Parameter {
    val name = arg.name.content()
    val type = parseType(arg.type)
    val isOptional = arg.default != null
    val defaultValue = if (isOptional) arg.default?.let { parseDefaultValue(it) } else null

    return Parameter(name, type, isOptional, defaultValue)
}
