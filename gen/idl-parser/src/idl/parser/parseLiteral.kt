package idl.parser

import idl.*
import tree_sitter.TSNode
import tree_sitter.ts_node_type
import java.lang.foreign.Arena


//   string_literal: ($) => token(seq('"', repeat(/[^"]*/), '"')),
//    number_literal: ($) => token(/[0-9]+/),
//    hex_literal: ($) => token(/0x[0-9a-fA-F]+/),
//    object_literal: ($) => "{}",
//    boolean_literal: ($) => choice("true", "false"),
//    array_literal: ($) => "[]",
//
//    literal: ($) =>
//      choice(
//        $.string_literal,
//        $.number_literal,
//        $.hex_literal,
//        $.object_literal,
//        $.boolean_literal,
//        $.array_literal,
//      ),
context(Arena, WithSource)
fun parseLiteral(node: TSNode): Literal {
    val nodeType = ts_node_type(node).getString(0)

    return when (nodeType) {
        "string_literal" -> {
            val content = node.content
            StringLiteral(content.substring(1, content.length - 1))
        }

        "number_literal", "hex_literal" -> {
            val content = node.content
            NumberLiteral(content)
        }

        "object_literal" -> {
            ObjectLiteral
        }

        "array_literal" -> {
            ArrayLiteral
        }

        "boolean_literal" -> {
            val content = node.content
            BooleanLiteral(content == "true")
        }

        else -> error("Unknown literal type $nodeType")
    }
}