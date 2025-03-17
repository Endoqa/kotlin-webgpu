package idl.parse

import idl.Maplike
import tree_sitter.idl.node.MaplikeNode

context(SourceAvailable)
fun parseMaplike(node: MaplikeNode): Maplike {
    val keyType = parseType(node.keyType)
    val valueType = parseType(node.valueType)
    val isReadOnly = node.readonly != null

    return Maplike(keyType, valueType, isReadOnly)
}