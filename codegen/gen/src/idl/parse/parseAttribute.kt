package idl.parse

import idl.Attribute
import tree_sitter.idl.node.AttributeNode

context(SourceAvailable)
fun parseAttribute(node: AttributeNode): Attribute {
    val isReadOnly = node.readonly != null
    val name = node.name.content()
    val type = parseType(node.type.type)
    val isInherit = node.inherit != null

    return Attribute(name, type, isReadOnly, isInherit = isInherit)
}
