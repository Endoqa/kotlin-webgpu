package idl.parser

import idl.TypeDef
import tree_sitter.Node
import java.lang.foreign.Arena

context(Arena, ParseContext)
fun parseTypedef(node: Node): TypeDef {
    val typeNode = node["type"] ?: impossible()
    val nameNode = node["name"] ?: impossible()


    val typedef = TypeDef(nameNode.content, parseTypeNode(typeNode))

    return typedef
}