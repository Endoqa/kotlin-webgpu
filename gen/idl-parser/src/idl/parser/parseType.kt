package idl.parser

import idl.IdentifierType
import idl.ParameterizedType
import idl.PrimitiveType
import idl.Type
import tree_sitter.Node
import java.lang.foreign.Arena

context(Arena, ParseContext)
internal fun parseTypeNode(node: Node): Type {
    val typeNode = node["type"] ?: impossible()
    val nullableNode = node["nullable"]

    // check with ts_node_null
    val nullable = nullableNode != null

    return parseBaseType(typeNode).copy(nullable = nullable)
}


context(Arena, ParseContext)
private fun parseBaseType(node: Node): Type {

    return when (node.symbol) {
        types.primitive_type -> {
            val primitiveType = node.content
            Type(PrimitiveType(primitiveType))
        }

        types.identifier -> {
            val name = node.content
            Type(IdentifierType(name))
        }

        types.parameterized -> {
            val name = (node["name"] ?: impossible()).content
            val types = node["types"] ?: impossible()


            val params = types.namedChildren.map {
                parseTypeNode(it)
            }


            Type(ParameterizedType(IdentifierType(name), params))
        }

        else -> error("Unknown base type ${node.symbol}")


    }

}