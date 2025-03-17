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
            interface_.asyncIterables.add(asyncIterable)
        }

        is ConstNode -> {
            val constant = parseConst(member)
            interface_.constants.add(constant)
        }

        is ConstructorNode -> {
            val constructor = Constructor()
            interface_.constructors.add(constructor)
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
