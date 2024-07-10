package idl.parser

import idl.Enum
import tree_sitter.Node
import java.lang.foreign.Arena

context(Arena, ParseContext)
fun parseEnum(node: Node): Enum {
    val name = (node["name"] ?: impossible()).content

    return Enum(name)
}