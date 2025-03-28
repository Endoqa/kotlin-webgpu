package idl.parse

import idl.DefaultValue
import tree_sitter.idl.node.*

/**
 * Parses a _DefaultValueNode into a DefaultValue.
 */
context(SourceAvailable)
fun parseDefaultValue(node: _DefaultValueNode): DefaultValue {
    return when (node) {
        is StringNode -> {
            // String values are enclosed in quotes, so we need to trim them
            val content = node.content().trim('"')
            DefaultValue.StringValue(content)
        }

        is BooleanLiteralNode -> {
            // Boolean values are "true" or "false"
            when (node.content().lowercase()) {
                "true" -> DefaultValue.BooleanValue(true)
                "false" -> DefaultValue.BooleanValue(false)
                else -> error("Invalid boolean value: ${node.content()}")
            }
        }

        is IntegerNode -> {
            // Integer values
            DefaultValue.IntegerValue(node.content())
        }

        is FloatLiteralNode -> {
            // Float values
            DefaultValue.FloatValue(node.content())
        }

        is DefaultDictionaryNode -> {
            // Dictionary initializer: {}
            DefaultValue.DictInitializer
        }

        is EmptySequenceNode -> {
            // Empty sequence: []
            DefaultValue.ListInitializer
        }

        else -> {
            // Handle other cases
            val content = node.content().lowercase()
            when {
                content == "null" -> DefaultValue.Null
                content == "undefined" -> DefaultValue.Undefined
                else -> DefaultValue.StringValue(node.content())
            }
        }
    }
}