package idl.parser

import idl.Dictionary
import idl.DictionaryMember
import tree_sitter.*
import java.lang.foreign.Arena

context(Arena, WithSource)
fun parseDict(node: TSNode): Dictionary {
    val name = ts_node_child_by_field_name(node, "name").content
    val declsNode = ts_node_child_by_field_name(node, "decls")
    val inheritsNode = ts_node_child_by_field_name(node, "inherit")

    val members = if (ts_node_is_null(declsNode)) {
        println(name + " has no members")
        emptyList()
    } else {
        (0u until ts_node_named_child_count(declsNode)).mapNotNull {
            val memberNode = ts_node_named_child(declsNode, it)
            val memberType = ts_node_type(memberNode).getString(0)

            if (memberType != "dictionary_member") {
                println("Unknown member type $memberType")
                null
            } else {
                parseMember(memberNode)
            }
        }
    }

    val inherits =
        if (ts_node_is_null(inheritsNode)) null else inheritsNode.content


    return Dictionary(name, inherits, members.toMutableList())

}

context(Arena, WithSource)
private fun parseMember(node: TSNode): DictionaryMember {

    val requiredNode = ts_node_child_by_field_name(node, "required")
    val typeNode = ts_node_child_by_field_name(node, "type")
    val name = ts_node_child_by_field_name(node, "name").content
    val valueNode = ts_node_child_by_field_name(node, "value")

    val required = !ts_node_is_null(requiredNode)

    val type = parseTypeNode(typeNode)


    val member = DictionaryMember(
        name = name,
        type = type,
        required = required,
        default = if (ts_node_is_null(valueNode)) null else parseLiteral(valueNode)
    )


    return member

}