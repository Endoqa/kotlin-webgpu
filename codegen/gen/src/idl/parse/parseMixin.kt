package idl.parse

import tree_sitter.idl.node.*

context(SourceAvailable)
fun parseMixin(node: MixinNode) {
    val name = node.name.content()
    println(name)

    node.body.members.forEach {
        when(val member = it.member) {
            is ConstNode -> TODO()
            is MaplikeNode -> TODO()
            is SetlikeNode -> TODO()
            is StaticMemberNode -> TODO()
            is StringifierNode -> TODO()
            is AttributeNode -> parseAttribute(member)
            is RegularOperationNode -> TODO()
            is SpecialOperationNode -> TODO()
        }
    }
}