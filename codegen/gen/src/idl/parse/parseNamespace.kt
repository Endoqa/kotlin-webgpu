package idl.parse

import idl.Namespace
import tree_sitter.idl.node.*

context(SourceAvailable)
fun parseNamespace(node: NamespaceNode): Namespace {
    val name = node.name.content()
    val extendedAttributes = parseExtendedAttributeList(node.attributes)
    val namespace = Namespace(name, extendedAttributes = extendedAttributes)

    node.members.forEach { member ->
        parseNamespaceMember(member, namespace)
    }

    return namespace
}

context(SourceAvailable)
fun parsePartialNamespace(node: PartialNamespaceNode): Namespace {
    val name = node.name.content()
    val extendedAttributes = parseExtendedAttributeList(node.attributes)
    val namespace = Namespace(name, isPartial = true, extendedAttributes = extendedAttributes)

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
            namespace.members.add(attribute)
        }

        is RegularOperationNode -> {
            val operation = parseRegularOperation(member)
            namespace.members.add(operation)
        }

        is ConstNode -> {
            val constant = parseConst(member)
            namespace.members.add(constant)
        }

        else -> {
            // Other member types are not expected in namespaces
            println("Unexpected member type in namespace: ${member.content()}")
        }
    }
}
