package idl.parse

import idl.Operation
import idl.Parameter
import tree_sitter.idl.node.ArgumentNode
import tree_sitter.idl.node.RegularOperationNode
import tree_sitter.idl.node.SpecialOperationNode

context(SourceAvailable)
fun parseRegularOperation(node: RegularOperationNode): Operation {
    val name = node.name?.content()
    val returnType = parseType(node.returnType)
    val parameters = parseArguments(node.arguments.argument)

    return Operation(name, returnType, parameters)
}

context(SourceAvailable)
fun parseSpecialOperation(node: SpecialOperationNode): Operation {
    val operation = parseRegularOperation(node.operation)
    val specialType = node.special.content()

    return Operation(
        operation.name,
        operation.returnType,
        operation.parameters,
        isStatic = operation.isStatic,
        isSpecial = true,
        specialType = specialType
    )
}

context(SourceAvailable)
private fun parseArguments(arguments: List<ArgumentNode>): List<Parameter> {
    return arguments.map { parseArgument(it) }
}
