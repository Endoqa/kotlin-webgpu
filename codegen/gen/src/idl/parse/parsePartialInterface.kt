package idl.parse

import idl.Attribute
import idl.Interface
import idl.Operation
import tree_sitter.idl.node.*

context(SourceAvailable)
fun parsePartialInterface(node: PartialInterfaceNode): Interface {
    val name = node.name.content()
    val extendedAttributes = parseExtendedAttributeList(node.attributes)
    val interface_ = Interface(name, isPartial = true, extendedAttributes = extendedAttributes)

    node.members.forEach { member ->
        parsePartialInterfaceMember(member.member, interface_)
    }

    return interface_
}

context(SourceAvailable)
private fun parsePartialInterfaceMember(member: _PartialInterfaceMemberBodyNode, interface_: Interface) {
    when (member) {
        is AsyncIterableNode -> {
            val asyncIterable = parseAsyncIterable(member)
            interface_.members.add(asyncIterable)
        }

        is ConstNode -> {
            val constant = parseConst(member)
            interface_.members.add(constant)
        }

        is IterableNode -> {
            val iterable = parseIterable(member)
            interface_.members.add(iterable)
        }

        is MaplikeNode -> {
            val maplike = parseMaplike(member)
            interface_.members.add(maplike)
        }

        is SetlikeNode -> {
            val setlike = parseSetlike(member)
            interface_.members.add(setlike)
        }

        is StaticMemberNode -> {
            when (val staticMember = parseStaticMember(member)) {
                is Attribute -> interface_.members.add(staticMember)
                is Operation -> interface_.members.add(staticMember)
            }
        }

        is StringifierNode -> {
            val stringifier = parseStringifier(member)
            interface_.members.add(stringifier)
        }

        is AttributeNode -> {
            val attribute = parseAttribute(member)
            interface_.members.add(attribute)
        }

        is RegularOperationNode -> {
            val operation = parseRegularOperation(member)
            interface_.members.add(operation)
        }

        is SpecialOperationNode -> {
            val operation = parseSpecialOperation(member)
            interface_.members.add(operation)
        }
    }
}
