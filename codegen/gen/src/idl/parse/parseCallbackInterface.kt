package idl.parse

import idl.CallbackInterface
import tree_sitter.idl.node.*

context(SourceAvailable)
fun parseCallbackInterface(node: CallbackInterfaceNode): CallbackInterface {
    val name = node.name.content()
    val callbackInterface = CallbackInterface(name)

    node.body.members.forEach { member ->
        parseInterfaceMember(member.member, callbackInterface)
    }

    return callbackInterface
}

context(SourceAvailable)
private fun parseInterfaceMember(member: _InterfaceMemberBodyNode, callbackInterface: CallbackInterface) {
    when (member) {
        is AttributeNode -> {
            val attribute = parseAttribute(member)
            callbackInterface.members.add(attribute)
        }

        is RegularOperationNode -> {
            val operation = parseRegularOperation(member)
            callbackInterface.members.add(operation)
        }

        is ConstNode -> {
            val constant = parseConst(member)
            callbackInterface.members.add(constant)
        }

        else -> {
            // Other member types are not expected in callback interfaces
            println("Unexpected member type in callback interface: ${member.content()}")
        }
    }
}
