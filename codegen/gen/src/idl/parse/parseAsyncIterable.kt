package idl.parse

import idl.AsyncIterable
import idl.Parameter
import tree_sitter.idl.node.AsyncIterableNode

context(SourceAvailable)
fun parseAsyncIterable(node: AsyncIterableNode): AsyncIterable {
    val keyType = parseType(node.type)
    val valueType = node.valueType?.let { parseType(it) }

    val parameters = node.arguments?.argument?.map { arg ->
        val name = arg.name.content()
        val type = parseType(arg.type)
        val isOptional = arg.default != null
        val defaultValue = if (isOptional) arg.default?.content() else null

        Parameter(name, type, isOptional, defaultValue)
    } ?: emptyList()

    return AsyncIterable(keyType, valueType, parameters)
}