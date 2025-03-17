package idl.parse

import idl.Constant
import idl.Type
import tree_sitter.idl.node.*

context(SourceAvailable)
fun parseConst(node: ConstNode): Constant {
    val name = node.name.content()
    val type = parseConstType(node.type)
    val value = parseConstValue(node.value)

    return Constant(name, type, value)
}

context(SourceAvailable)
private fun parseConstType(node: _ConstTypeNode): Type {
    return when (node) {
        is IdentifierNode -> parseType(node)
        is PrimitiveTypeNode -> parseType(node)
        else -> throw IllegalArgumentException("Unsupported const type: ${node.javaClass.simpleName}")
    }
}

context(SourceAvailable)
private fun parseConstValue(node: _ConstValueNode): Any {
    return when (node) {
        is BooleanLiteralNode -> node.content().toBoolean()
        is IntegerNode -> {
            val content = node.content()
            if (content.startsWith("0x", ignoreCase = true)) {
                content.substring(2).toInt(16)
            } else {
                content.toInt()
            }
        }

        is FloatLiteralNode -> node.content().toDouble()
        else -> node.content() // Fallback for any other types
    }
}
