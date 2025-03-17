package idl.parse

import idl.Enum
import tree_sitter.idl.node.EnumNode

context(SourceAvailable)
fun parseEnum(node: EnumNode): Enum {
    val name = node.name.content()
    val values = node.value.map { it.content().trim('"') }

    return Enum(name, values)
}