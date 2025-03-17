package idl.parse

import idl.Typedef
import tree_sitter.idl.node.TypedefNode

context(SourceAvailable)
fun parseTypedef(node: TypedefNode): Typedef {
    val name = node.name.content()
    val type = parseType(node.type.type)
    return Typedef(name, type)
}