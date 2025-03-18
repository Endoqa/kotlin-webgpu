package idl.parse

import idl.*
import tree_sitter.idl.node.*

context(SourceAvailable)
fun parseType(type: _TypeNode): Type {
    return when (type) {
        is PromiseTypeNode -> PromiseType(parseType(type.resolveType))
        is UnionTypeNode -> {
            // Since _TypeNode extends UnionTypeNodeMemberTypes, we can safely cast
            val memberTypes = type.memberTypes.filterIsInstance<_TypeNode>().map { parseType(it) }
            UnionType(memberTypes)
        }

        is BufferRelatedTypeNode -> BufferRelatedType(type.content())
        is FrozenArrayTypeNode -> FrozenArrayType(parseType(type.elementType))
        is IdentifierNode -> Identifier(type.content())
        is NullableTypeNode -> NullableType(parseType(type.type))
        is ObservableArrayTypeNode -> ObservableArrayType(parseType(type.elementType))
        is IDLTSBaseNode.Unnamed -> Identifier(type.content())
        is RecordTypeNode -> RecordType(StringType, parseType(type.valueType))
        is SequenceTypeNode -> SequenceType(parseType(type.elementType))
        is StringTypeNode -> StringType
        is FloatTypeNode -> FloatType(type.base.content(), type.unrestricted != null)
        is IntegerTypeNode -> IntegerType(type.base.content(), type.unsigned != null)
    }
}
