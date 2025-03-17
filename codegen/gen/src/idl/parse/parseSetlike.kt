package idl.parse

import idl.Setlike
import tree_sitter.idl.node.SetlikeNode

context(SourceAvailable)
fun parseSetlike(node: SetlikeNode): Setlike {
    val valueType = parseType(node.valueType)
    val isReadOnly = node.readonly != null

    return Setlike(valueType, isReadOnly)
}