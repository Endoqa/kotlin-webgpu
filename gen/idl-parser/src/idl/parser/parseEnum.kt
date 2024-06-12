package idl.parser

import idl.Enum
import tree_sitter.TSNode
import tree_sitter.ts_node_child_by_field_name
import java.lang.foreign.Arena

context(Arena, WithSource)
fun parseEnum(node: TSNode): Enum {
    val name = ts_node_child_by_field_name(node, "name").content

    return Enum(name)
}