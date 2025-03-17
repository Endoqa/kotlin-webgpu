package idl.parse

import idl.Namespace
import tree_sitter.idl.node.*

context(SourceAvailable)
fun parseNamespace(node: NamespaceNode): Namespace {
    val name = node.name.content()
    val namespace = Namespace(name)

    node.members.forEach { member ->
        parseNamespaceMember(member, namespace)
    }

    return namespace
}

context(SourceAvailable)
fun parsePartialNamespace(node: PartialNamespaceNode): Namespace {
    val name = node.name.content()
    val namespace = Namespace(name, isPartial = true)

    node.members.forEach { member ->
        parseNamespaceMember(member, namespace)
    }

    return namespace
}

context(SourceAvailable)
private fun parseNamespaceMember(member: _NamespaceMemberNode, namespace: Namespace) {
    when (member) {
        is AttributeNode -> {
            val attribute = parseAttribute(member)
            namespace.attributes.add(attribute)
        }

        is RegularOperationNode -> {
            val operation = parseRegularOperation(member)
            namespace.operations.add(operation)
        }

        is ConstNode -> {
            val constant = parseConst(member)
            namespace.constants.add(constant)
        }

        else -> {
            // Other member types are not expected in namespaces
            println("Unexpected member type in namespace: ${member.content()}")
        }
    }
}
