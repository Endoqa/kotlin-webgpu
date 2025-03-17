package tree_sitter.idl.node

import tree_sitter.Node

public class RecordTypeNode(
    override val `$node`: Node,
) : IDLTSBaseNode,
    _SingleTypeNode {
    public val keyType: StringTypeNode
        get() = StringTypeNode(
            `$node`.getChildByFieldName("key_type") ?: error("required field key_type is null")
        )

    public val valueType: _TypeNode
        get() = _TypeNode(
            `$node`.getChildByFieldName("value_type") ?: error("required field value_type is null")
        )
}
