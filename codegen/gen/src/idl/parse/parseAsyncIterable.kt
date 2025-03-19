package idl.parse

import idl.AsyncIterable
import tree_sitter.idl.node.AsyncIterableNode

context(SourceAvailable)
fun parseAsyncIterable(node: AsyncIterableNode): AsyncIterable {
    val keyType = parseType(node.type)
    val valueType = node.valueType?.let { parseType(it) }

    val parameters = node.arguments?.argument?.map { parseArgument(it) } ?: emptyList()

    return AsyncIterable(keyType, valueType, parameters)
}
