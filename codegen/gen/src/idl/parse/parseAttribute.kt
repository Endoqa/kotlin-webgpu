package idl.parse

import tree_sitter.idl.node.AttributeNode

context(SourceAvailable)
fun parseAttribute(node: AttributeNode) {
    println(node.readonly != null)
    val name = node.name.content()
    println(name)
    val type = node.type

    println(parseType(type.type))

}