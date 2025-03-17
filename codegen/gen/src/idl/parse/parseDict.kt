package idl.parse

import tree_sitter.idl.node.DictionaryMemberNode
import tree_sitter.idl.node.DictionaryNode

context(SourceAvailable)
fun parseDict(node: DictionaryNode) {
    val name = node.name.content()
    println(name)

    node.body.members.forEach { member ->
        parseDictMember(member)
    }
}

context(SourceAvailable)
private fun parseDictMember(member: DictionaryMemberNode) {
    val name = member.name.content()
    println(name)
    val type = member.type

    println(parseType(type))
}