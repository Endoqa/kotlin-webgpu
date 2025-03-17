package idl.parse

import idl.Dictionary
import idl.DictionaryMember
import tree_sitter.idl.node.DictionaryMemberNode
import tree_sitter.idl.node.DictionaryNode
import tree_sitter.idl.node.PartialDictionaryNode

context(SourceAvailable)
fun parseDict(node: DictionaryNode): Dictionary {
    val name = node.name.content()
    val dictionary = Dictionary(name)

    node.body.members.forEach { member ->
        val dictMember = parseDictMember(member)
        dictionary.members.add(dictMember)
    }

    return dictionary
}

context(SourceAvailable)
fun parsePartialDict(node: PartialDictionaryNode): Dictionary {
    val name = node.name.content()
    val dictionary = Dictionary(name, isPartial = true)

    node.body.members.forEach { member ->
        val dictMember = parseDictMember(member)
        dictionary.members.add(dictMember)
    }

    return dictionary
}

context(SourceAvailable)
private fun parseDictMember(member: DictionaryMemberNode): DictionaryMember {
    val name = member.name.content()
    val type = parseType(member.type)
    val isRequired = member.content().contains("required")

    return DictionaryMember(name, type, isRequired)
}
