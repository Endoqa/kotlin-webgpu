package idl.parse

import idl.ExtendedAttribute
import idl.ExtendedAttributeList
import idl.Parameter
import tree_sitter.idl.node.*

context(SourceAvailable)
fun parseExtendedAttributeList(node: ExtendedAttributeListNode?): ExtendedAttributeList {
    if (node == null) {
        return ExtendedAttributeList()
    }

    val attributes = node.attribute.map { parseExtendedAttribute(it) }
    return ExtendedAttributeList(attributes)
}

context(SourceAvailable)
private fun parseExtendedAttribute(node: _ExtendedAttributeNode): ExtendedAttribute {
    return when (node) {
        is ExtendedAttributeNoArgsNode -> {
            val name = node.name.content()
            ExtendedAttribute.NoArgs(name)
        }

        is ExtendedAttributeArgListNode -> {
            val name = node.name.content()
            val arguments = parseArgumentList(node.arguments)
            ExtendedAttribute.ArgList(name, arguments)
        }

        is ExtendedAttributeIdentNode -> {
            val name = node.name.content()
            val value = node.value.content()
            ExtendedAttribute.Ident(name, value)
        }

        is ExtendedAttributeIdentListNode -> {
            val name = node.name.content()
            val values = node.value.map { it.content() }
            ExtendedAttribute.IdentList(name, values)
        }

        is ExtendedAttributeNamedArgListNode -> {
            val name = node.name.content()
            val identifier = node.identifier.content()
            val arguments = parseArgumentList(node.arguments)
            ExtendedAttribute.NamedArgList(name, identifier, arguments)
        }

        else -> {
            throw IllegalArgumentException("Unsupported extended attribute type: ${node.javaClass.simpleName}")
        }
    }
}

context(SourceAvailable)
private fun parseArgumentList(node: ArgumentListNode): List<Parameter> {
    return node.argument.map { parseArgument(it) }
}
