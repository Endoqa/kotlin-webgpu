package idl.parse


import tree_sitter.idl.node.*

context(SourceAvailable)
fun parseInterface(node: InterfaceNode) {
    val name = node.name.content()
    println(name)

    node.body.members.forEach { member ->
        parseInterfaceMember(member.member)
    }
}

context(SourceAvailable)
private fun parseInterfaceMember(member: _InterfaceMemberBodyNode) {
   when(member) {
       is AsyncIterableNode -> TODO()
       is ConstNode -> TODO()
       is ConstructorNode -> TODO()
       is IterableNode -> TODO()
       is MaplikeNode -> TODO()
       is SetlikeNode -> TODO()
       is StaticMemberNode -> TODO()
       is StringifierNode -> TODO()
       is AttributeNode -> parseAttribute(member)
       is RegularOperationNode -> TODO()
       is SpecialOperationNode -> TODO()
   }
}