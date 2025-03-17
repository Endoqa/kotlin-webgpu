package idl.parse

import idl.Attribute
import idl.Interface
import idl.Operation
import tree_sitter.idl.node.*

context(SourceAvailable)
fun parsePartialInterface(node: PartialInterfaceNode): Interface {
    val name = node.name.content()
    val interface_ = Interface(name, isPartial = true)

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
            interface_.asyncIterables.add(asyncIterable)
        }

        is ConstNode -> {
            val constant = parseConst(member)
            interface_.constants.add(constant)
        }

        is IterableNode -> {
            val iterable = parseIterable(member)
            interface_.iterables.add(iterable)
        }

        is MaplikeNode -> {
            val maplike = parseMaplike(member)
            interface_.maplikes.add(maplike)
        }

        is SetlikeNode -> {
            val setlike = parseSetlike(member)
            interface_.setlikes.add(setlike)
        }

        is StaticMemberNode -> {
            when (val staticMember = parseStaticMember(member)) {
                is Attribute -> interface_.attributes.add(staticMember)
                is Operation -> interface_.operations.add(staticMember)
            }
        }

        is StringifierNode -> {
            val stringifier = parseStringifier(member)
            interface_.stringifiers.add(stringifier)
        }

        is AttributeNode -> {
            val attribute = parseAttribute(member)
            interface_.attributes.add(attribute)
        }

        is RegularOperationNode -> {
            val operation = parseRegularOperation(member)
            interface_.operations.add(operation)
        }

        is SpecialOperationNode -> {
            val operation = parseSpecialOperation(member)
            interface_.operations.add(operation)
        }
    }
}
