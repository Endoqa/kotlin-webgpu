package idl.parser

import idl.Dictionary
import idl.DictionaryMember
import tree_sitter.Node
import java.lang.foreign.Arena

context(Arena, ParseContext)
fun parseDict(node: Node): Dictionary {
//    val name = ts_node_child_by_field_name(node, "name").content
//    val declsNode = ts_node_child_by_field_name(node, "decls")
//    val inheritsNode = ts_node_child_by_field_name(node, "inherit")

    val name = node["name"] ?: error("impossible")
    val declsNode = node["decls"]
    val inheritsNode = node["inherit"]

    val members = if (declsNode == null) {
        println(name.content + " has no members")
        emptyList()
    } else {
        declsNode.namedChildren.mapNotNull { memberNode ->

            if (memberNode.symbol != types.dictionary_declaration) {
                println("Unknown member type ${memberNode.symbol}")
                null
            } else {
                parseMember(memberNode)
            }
        }
    }

    val inherits =
        inheritsNode?.content


    return Dictionary(name.content, inherits, members.toMutableList())

}

context(Arena, ParseContext)
private fun parseMember(node: Node): DictionaryMember {

    val requiredNode = node["required"]
    val typeNode = node["type"] ?: impossible()
    val name = node["name"] ?: impossible()
    val valueNode = node["value"]

    val required = requiredNode != null

    val type = parseTypeNode(typeNode)


    val member = DictionaryMember(
        name = name.content,
        type = type,
        required = required,
        default = if (valueNode == null) null else parseLiteral(valueNode)
    )


    return member

}