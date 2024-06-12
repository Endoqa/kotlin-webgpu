package idl.parser

import idl.TypeDef
import tree_sitter.TSNode
import tree_sitter.ts_node_child_by_field_name
import java.lang.foreign.Arena

context(Arena, WithSource)
fun parseTypedef(node: TSNode): TypeDef {
    val typeNode = ts_node_child_by_field_name(node, "type")
    val nameNode = ts_node_child_by_field_name(node, "name")


    val typedef = TypeDef(nameNode.content, parseTypeNode(typeNode))

    return typedef
}