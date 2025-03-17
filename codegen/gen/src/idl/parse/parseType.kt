package idl.parse

import idl.StringType
import tree_sitter.idl.node.*

context(SourceAvailable)
fun parseType(type: _TypeNode) {
    when (type) {
        is PromiseTypeNode -> TODO()
        is UnionTypeNode -> TODO()
        is BufferRelatedTypeNode -> TODO()
        is FrozenArrayTypeNode -> TODO()
        is IdentifierNode -> TODO()
        is NullableTypeNode -> TODO()
        is ObservableArrayTypeNode -> TODO()
        is IDLTSBaseNode.Unnamed -> TODO()
        is RecordTypeNode -> TODO()
        is SequenceTypeNode -> TODO()
        is StringTypeNode -> StringType
        is FloatTypeNode -> TODO()
        is IntegerTypeNode -> {
            println(type.unsigned != null)
        }
    }
}