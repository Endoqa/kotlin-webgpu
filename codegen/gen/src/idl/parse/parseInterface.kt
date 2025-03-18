package idl.parse

import idl.Attribute
import idl.Constructor
import idl.Interface
import idl.Operation
import tree_sitter.idl.node.*

context(SourceAvailable)
fun parseInterface(node: InterfaceNode): Interface {
    val name = node.name.content()
    val interface_ = Interface(name)

    node.body.members.forEach { member ->
        parseInterfaceMember(member.member, interface_)
    }

    return interface_
}

context(SourceAvailable)
private fun parseInterfaceMember(member: _InterfaceMemberBodyNode, interface_: Interface) {
    when (member) {
        is AsyncIterableNode -> {
            val asyncIterable = parseAsyncIterable(member)
            interface_.members.add(asyncIterable)
        }

        is ConstNode -> {
            val constant = parseConst(member)
            interface_.members.add(constant)
        }

        is ConstructorNode -> {
            val constructor = Constructor()
            interface_.members.add(constructor)
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
