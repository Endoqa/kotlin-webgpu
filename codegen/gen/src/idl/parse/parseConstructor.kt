package idl.parse

import idl.Constructor
import idl.Parameter
import tree_sitter.idl.node.ArgumentNode
import tree_sitter.idl.node.ConstructorNode

/**
 * Parses a ConstructorNode into a Constructor.
 */
context(SourceAvailable)
fun parseConstructor(node: ConstructorNode): Constructor {
    val parameters = parseConstructorArguments(node.arguments.argument)
    return Constructor(parameters)
}

/**
 * Parses a list of ArgumentNode into a list of Parameter.
 */
context(SourceAvailable)
private fun parseConstructorArguments(arguments: List<ArgumentNode>): List<Parameter> {
    return arguments.map { parseArgument(it) }
}