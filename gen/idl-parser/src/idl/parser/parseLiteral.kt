package idl.parser

import idl.*
import tree_sitter.Node
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
context(Arena, ParseContext)
fun parseLiteral(node: Node): Literal {
    return when (node.symbol) {
        types.string_literal -> {
            val content = node.content
            StringLiteral(content.substring(1, content.length - 1))
        }

        types.number_literal, types.hex_literal -> {
            val content = node.content
            NumberLiteral(content)
        }

        types.object_literal -> {
            ObjectLiteral
        }

        types.array_literal -> {
            ArrayLiteral
        }

        types.boolean_literal -> {
            val content = node.content
            BooleanLiteral(content == "true")
        }

        else -> error("Unknown literal type ${node.symbol}")
    }
}