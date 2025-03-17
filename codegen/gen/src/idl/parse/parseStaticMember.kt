package idl.parse

import idl.Attribute
import idl.Operation
import tree_sitter.idl.node.AttributeNode
import tree_sitter.idl.node.RegularOperationNode
import tree_sitter.idl.node.StaticMemberNode

context(SourceAvailable)
fun parseStaticMember(node: StaticMemberNode): Any {
    return when (val member = node.member) {
        is AttributeNode -> {
            val attribute = parseAttribute(member)
            // Mark the attribute as static
            Attribute(
                attribute.name,
                attribute.type,
                attribute.isReadOnly,
                isStatic = true,
                attribute.isInherit
            )
        }

        is RegularOperationNode -> {
            val operation = parseRegularOperation(member)
            // Mark the operation as static
            Operation(
                operation.name,
                operation.returnType,
                operation.parameters,
                isStatic = true,
                operation.isSpecial,
                operation.specialType
            )
        }

        else -> {
            throw IllegalArgumentException("Unsupported static member type: ${member.javaClass.simpleName}")
        }
    }
}