package idl.parse

import idl.Iterable
import tree_sitter.idl.node.IterableNode

context(SourceAvailable)
fun parseIterable(node: IterableNode): Iterable {
    val keyType = parseType(node.type)
    val valueType = node.valueType?.let { parseType(it) }

    return Iterable(keyType, valueType)
}