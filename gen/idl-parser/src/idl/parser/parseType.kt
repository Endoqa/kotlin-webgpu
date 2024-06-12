package idl.parser

import idl.IdentifierType
import idl.ParameterizedType
import idl.PrimitiveType
import idl.Type
import tree_sitter.*
import java.lang.foreign.Arena

context(Arena, WithSource)
internal fun parseTypeNode(node: TSNode): Type {
    val typeNode = ts_node_child_by_field_name(node, "type")
    val nullableNode = ts_node_child_by_field_name(node, "nullable")

    // check with ts_node_null
    val nullable = !ts_node_is_null(nullableNode)

    return parseBaseType(typeNode).copy(nullable = nullable)
}


context(Arena, WithSource)
private fun parseBaseType(node: TSNode): Type {
    val nodeType = ts_node_type(node).getString(0)

    return when (nodeType) {
        "primitive_type" -> {
            val primitiveType = node.content
            Type(PrimitiveType(primitiveType))
        }

        "identifier" -> {
            val name = node.content
            Type(IdentifierType(name))
        }

        "parameterized" -> {
            val name = ts_node_child_by_field_name(node, "name").content
            val types = ts_node_child_by_field_name(node, "types")

            println()
            println(ts_node_named_child_count(types))

            val params = (0u until ts_node_named_child_count(types)).map {
                val typeNode = ts_node_named_child(types, it)
                parseTypeNode(typeNode)
            }


            Type(ParameterizedType(IdentifierType(name), params))
        }

        else -> error("Unknown base type $nodeType")


    }

}