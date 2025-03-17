package idl.parse

import idl.Stringifier
import tree_sitter.idl.node.AttributeNode
import tree_sitter.idl.node.StringifierNode

context(SourceAvailable)
fun parseStringifier(node: StringifierNode): Stringifier {
    val children = node.children()
        ?: // Empty stringifier
        return Stringifier()

    return when (children) {
        is AttributeNode -> {
            val attribute = parseAttribute(children)
            Stringifier(attribute)
        }

        else -> {
            // For other types of stringifier children, just return an empty stringifier
            Stringifier()
        }
    }
}